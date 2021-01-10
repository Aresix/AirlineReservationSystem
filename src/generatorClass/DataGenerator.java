package generatorClass;

import myClass.*;

import java.util.ArrayList;

import static generatorClass.AirportGenerator.initAirport;
import static generatorClass.AirlineFactory.initAirline;
import static generatorClass.CityGenerator.initCity;
import static generatorClass.FlightGenerator.initFlight;
import static generatorClass.PlaneGenerator.initPlane;

public class DataGenerator {
    public static ArrayList<City> cities = initCity();
    public static ArrayList<Airport> airports = initAirport(cities);
    public static ArrayList<Airline> airlines = initAirline();
    public static ArrayList<Plane> planes = initPlane();
    public static ArrayList<Flight> flights = initFlight();
//        initTicket(flights, planes);
}
