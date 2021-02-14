import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CityInitializer {
    private final Scanner scanner;
    private final CityDatabase cityDatabase;

    public CityInitializer(Scanner scanner, CityDatabase cityDatabase) {
        this.scanner = scanner;
        this.cityDatabase = cityDatabase;
    }

    public Set<City> initialiseCities(Set<City> citySet) {
        char addAnotherCity;
        String cityName;
        System.out.print("City Name = ");
        cityName = scanner.nextLine();
        City city = new City(cityName, CityIdGenerator.cityIdGenerator(cityName), new HashSet<>(), new HashMap<>());
        cityDatabase.addCity(city);
        addNeighbours(city);
        citySet.add(city);
        //scanner.nextLine();
        while (true) {
            System.out.println("Add another city?");
            System.out.println("\"Y\" for yes and \"N\" for no");
            addAnotherCity = scanner.next().charAt(0);
            if (addAnotherCity == 'Y' || addAnotherCity == 'y') {
                System.out.print("City Name = ");
                scanner.nextLine();
                cityName = scanner.nextLine();
                city = new City(cityName, CityIdGenerator.cityIdGenerator(cityName), new HashSet<>(), new HashMap<>());
                cityDatabase.addCity(city);
                addNeighbours(city);
                citySet.add(city);
            }
            else {
                break;
            }
        }
        return citySet;

    }

    private void addNeighbours(City city) {
        Set<City> cities = cityDatabase.getCityDatabaseSet();
        for (City c : cities) {
            if (c.getCityId() != city.getCityId()) {
                System.out.print("Distance from " + c.getCityName() + "(cityId = " + c.getCityId().getCityId() + ")");
                System.out.println("Enter -1 if not connected");
                int distance = scanner.nextInt();
                while (distance != -1 && distance <= 0) {
                    System.out.println("Invalid Distance, Try Again");
                    distance = scanner.nextInt();
                }
                if (distance > 0) {
                    city.addDistanceFromNeighbourCity(c, distance);
                    c.addDistanceFromNeighbourCity(city, distance);
                } else {
                    System.out.println("Not Connected");
                }
            }
        }
    }

}
