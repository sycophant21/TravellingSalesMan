import java.util.Set;

public class SalesMan {
    private int distanceCovered;
    private City currentCity;
    private final Set<CityTravelEntry> citiesCovered;

    public SalesMan(int distanceCovered, City currentCity, Set<CityTravelEntry> citiesCovered) {
        this.distanceCovered = distanceCovered;
        this.currentCity = currentCity;
        this.citiesCovered = citiesCovered;
        addCity(currentCity, 1);
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public int getDistanceCovered() {
        return distanceCovered;
    }

    public Set<CityTravelEntry> getCitiesCovered() {
        return citiesCovered;
    }

    public void addCity(City city, int index) {
        CityTravelEntry cityTravelEntry = new CityTravelEntry(city, index);
        citiesCovered.add(cityTravelEntry);
    }

    public void setDistanceCovered(int distanceCovered) {
        this.distanceCovered += distanceCovered;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public void removeCity(City city) {
        citiesCovered.remove(new CityTravelEntry(city, 0));
    }
}
