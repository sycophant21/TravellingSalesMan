import java.util.HashSet;
import java.util.Set;

public class CityDatabase {
    private final Set<City> cityDatabaseSet;

    public CityDatabase(Set<City> cityDatabaseSet) {
        this.cityDatabaseSet = cityDatabaseSet;
    }

    public Set<City> getCityDatabaseSet() {
        return cityDatabaseSet;
    }
    public Set<City> getCityFromCityName(String cityName) {
        Set<City> citySet = new HashSet<>();
        for (City c : cityDatabaseSet) {
            if (c.getCityName().equals(cityName)) {
                citySet.add(c);
            }
        }
        return citySet;
    }
    public City getCityFromCityId(CityId cityId) {
        for (City c : cityDatabaseSet) {
            if (c.getCityId().equals(cityId)) {
                return c;
            }
        }
        return null;
    }

    public void addCity(City city) {
        cityDatabaseSet.add(city);
    }
}
