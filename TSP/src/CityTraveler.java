import java.util.*;

public class CityTraveler {
    private final Set<City> citySet;
    private int counter;

    public CityTraveler(Set<City> citySet) {
        this.citySet = citySet;
        counter = citySet.size();
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int startJourney(SalesMan salesMan) {
        List<City> cities = getPossibleCities(salesMan.getCurrentCity());
        City currentCity = new City(salesMan.getCurrentCity().getCityName(), salesMan.getCurrentCity().getCityId(), salesMan.getCurrentCity().getCitiesConnectedWithThisCitySet(), salesMan.getCurrentCity().getDistanceFromOtherCitiesMap());
        citySet.remove(salesMan.getCurrentCity());
        for (City city : cities) {
            salesMan.setDistanceCovered(city.getDistanceFromCity(currentCity));
            salesMan.setCurrentCity(city);
            if (startJourney(salesMan) == 1) {
                salesMan.addCity(city, counter);
                citySet.add(currentCity);
                counter--;
                return 1;
            }
            salesMan.setDistanceCovered(-1 * city.getDistanceFromCity(currentCity));
            salesMan.setCurrentCity(currentCity);

        }
        if (citySet.isEmpty()) {
            citySet.add(salesMan.getCurrentCity());
            System.out.println("Distance Traveled = " + salesMan.getDistanceCovered());
            return 1;
        }
        else {
            citySet.add(salesMan.getCurrentCity());
            System.out.println("Distance Traveled = " + salesMan.getDistanceCovered());
            return 0;
        }
    }


    private List<City> getPossibleCities(City currentCity) {
        Set<City> cities = currentCity.getCitiesConnectedWithThisCitySet();
        List<City> citiesPossible = new ArrayList<>();
        for (City city : cities) {
            if (citySet.contains(city)) {
                citiesPossible.add(city);
            }
        }
        return arrangeCities(citiesPossible, currentCity);
    }

    private List<City> arrangeCities(List<City> cities, City currentCity) {
        CityComparator cityComparator = new CityComparator(currentCity);
        cities.sort(cityComparator);
        return cities;
    }

}
