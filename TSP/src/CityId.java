import java.util.Objects;

public class CityId {
    private final String cityId;

    public CityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityId() {
        return cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityId cityId1 = (CityId) o;
        return cityId.equals(cityId1.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId);
    }
}
