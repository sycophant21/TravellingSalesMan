import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        CityDatabase cityDatabase = new CityDatabase(new HashSet<>());
        Scanner scanner = new Scanner(System.in);
        CityInitializer cityInitializer = new CityInitializer(scanner, cityDatabase);
        Set<City> citySet = cityInitializer.initialiseCities(new HashSet<>());
        Set<City> cities = new HashSet<>(cityDatabase.getCityDatabaseSet());
        CityTraveler cityTraveler = new CityTraveler(cities);
        for (City city : citySet) {
            SalesMan salesMan = new SalesMan(0, city, new HashSet<>());
            if (cityTraveler.startJourney(salesMan) == 1) {
                System.out.print("Starting Point = ");
                Set<CityTravelEntry> cityTravelEntries = salesMan.getCitiesCovered();
                for (int i = 1 ; i <= cityTravelEntries.size() ; i++) {
                    for (CityTravelEntry cityTravelEntry : cityTravelEntries) {
                        if (cityTravelEntry.getIndex() == i) {
                            System.out.print(cityTravelEntry.getCity().getCityName() + "\n");
                        }
                    }
                }
                //System.out.println();
            }
            //System.out.println("Distance Covered = " + salesMan.getDistanceCovered());
            System.out.println();
            cityTraveler.setCounter(citySet.size());
        }
    }
}
