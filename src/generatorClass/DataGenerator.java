package generatorClass;

import myClass.*;

import java.util.ArrayList;

import static generatorClass.AirlineGenerator.initAirport;
import static generatorClass.AirportGenerator.initAirline;
import static generatorClass.CityGenerator.initCity;
import static generatorClass.FlightGenerator.initFlight;
import static generatorClass.PlaneGenerator.initPlane;

public class DataGenerator {
    public static ArrayList<City> cities = initCity();
    public static ArrayList<Airport> airports = initAirport(cities);
    public static ArrayList<Airline> airlines = initAirline();
    public static ArrayList<Flight> flights = initFlight(airports, airlines);
    public static ArrayList<Plane> planes = initPlane();
//        initTicket(flights, planes);
}
