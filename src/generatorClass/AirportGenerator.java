package generatorClass;

import myClass.Airport;
import myClass.City;

import java.util.ArrayList;

public class AirportGenerator {
    public static ArrayList<Airport> initAirport(ArrayList<City> cities) {
        ArrayList<Airport> airports = new ArrayList<Airport>();
        airports.add(new Airport("0001", "浦东国际机场", cities.get(0)));
        airports.add(new Airport("0002", "虹桥国际机场", cities.get(0)));
        airports.add(new Airport("0003", "大兴国际机场", cities.get(1)));
        airports.add(new Airport("0004", "广州白云机场", cities.get(2)));
//        for (Airport a : airports) a.getAirport();
        return airports;
    }
}
