package generatorClass;

import myClass.Airline;
import myClass.Airport;
import myClass.Flight;

import java.util.ArrayList;
import java.util.Date;

public class FlightGenerator {
    public static ArrayList<Flight> initFlight(ArrayList<Airport> airports, ArrayList<Airline> airlines) {
        int i = 0;
        Date date = new Date();
        date.setDate(23);
        ArrayList<Flight> flights = new ArrayList<Flight>();
        flights.add(new Flight(airports.get(2), airports.get(0), "F000001", date));
        airlines.get(0).createFlight(flights.get(i++));
        flights.add(new Flight(airports.get(2), airports.get(1), "F000002", date));
        airlines.get(0).createFlight(flights.get(i++));
        flights.add(new Flight(airports.get(3), airports.get(1), "F000003", date));
        airlines.get(0).createFlight(flights.get(i++));
        flights.add(new Flight(airports.get(3), airports.get(1), "F100001", date));
        airlines.get(1).createFlight(flights.get(i++));
        flights.add(new Flight(airports.get(3), airports.get(0), "F100002", date));
        airlines.get(1).createFlight(flights.get(i++));
        flights.add(new Flight(airports.get(0), airports.get(2), "F200001", date));
        airlines.get(2).createFlight(flights.get(i++));
        flights.add(new Flight(airports.get(0), airports.get(3), "F200002", date));
        airlines.get(2).createFlight(flights.get(i++));
        flights.add(new Flight(airports.get(1), airports.get(3), "F300001", date));
        airlines.get(3).createFlight(flights.get(i++));
        flights.add(new Flight(airports.get(1), airports.get(2), "F300002", date));
        airlines.get(3).createFlight(flights.get(i));

//        for(Airline a : airlines){
//            ArrayList<Flight> f = a.getFlightsList();
//            for (Flight flight: f){
//                flight.printAirline();
//            }
//        }
        return flights;
    }
}
