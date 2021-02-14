import java.util.Objects;

public class CityTravelEntry {
    private final City city;
    private final int index;

    public CityTravelEntry(City city, int index) {
        this.city = city;
        this.index = index;
    }

    public City getCity() {
        return city;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityTravelEntry that = (CityTravelEntry) o;
        return city.equals(that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }
}
