import java.util.Comparator;

public class CityComparator implements Comparator<City> {
    private final City city;

    public CityComparator(City city) {
        this.city = city;
    }

    @Override
    public int compare(City o1, City o2) {
        return o1.getDistanceFromCity(city) - o2.getDistanceFromCity(city);
    }
}
