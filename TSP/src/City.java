import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class City {
    private final String cityName;
    private final CityId cityId;
    private City nearestNeighbour;
    private final Set<City> citiesConnectedWithThisCitySet;
    private final Map<CityId,Integer> distanceFromOtherCitiesMap;

    public City(String cityName, CityId cityId, Set<City> citySet, Map<CityId, Integer> distanceFromOtherCitiesMap) {
        this.cityName = cityName;
        this.cityId = cityId;
        this.citiesConnectedWithThisCitySet = citySet;
        this.distanceFromOtherCitiesMap = distanceFromOtherCitiesMap;
        this.nearestNeighbour = assignNearestNeighbour();
    }

    public Map<CityId, Integer> getDistanceFromOtherCitiesMap() {
        return distanceFromOtherCitiesMap;
    }

    public String getCityName() {
        return cityName;
    }

    public CityId getCityId() {
        return cityId;
    }

    public Set<City> getCitiesConnectedWithThisCitySet() {
        return citiesConnectedWithThisCitySet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(cityId, city.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId);
    }

    private void addNeighbours(City city) {
        citiesConnectedWithThisCitySet.add(city);
        nearestNeighbour = assignNearestNeighbour();
    }
    public void addDistanceFromNeighbourCity(City city, int distance) {
        distanceFromOtherCitiesMap.put(city.getCityId(), distance);
        addNeighbours(city);

    }

    private City assignNearestNeighbour() {
        double distance = Double.POSITIVE_INFINITY;
        City nearestNeighbour = null;
        for (City c : citiesConnectedWithThisCitySet) {
            if (distanceFromOtherCitiesMap.containsKey(c.getCityId())) {
                if (distance > distanceFromOtherCitiesMap.get(c.getCityId())) {
                    nearestNeighbour = c;
                }
            }
        }
        return nearestNeighbour;
    }
    public City getNearestNeighbour() {
        return nearestNeighbour;
    }

    public int getDistanceFromCity(City city) {
        return distanceFromOtherCitiesMap.get(city.getCityId());
    }
}
