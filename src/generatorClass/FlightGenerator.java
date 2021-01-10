package generatorClass;

import myClass.Airline;
import myClass.Airport;
import myClass.Flight;
import myClass.Plane;
import singleton.TicketManagementSingleton;
import util.RandomDDPair;
import util.RandomNumber;

import java.util.ArrayList;
import java.util.Date;

public class FlightGenerator {
    private static int turn = 0;

    public static ArrayList<Flight> initFlight(/*ArrayList<Airport> airports, ArrayList<Airline> airlines*/) {
        int i = 0;
//        Date date = new Date();
//        date.setDate(23);
        ArrayList<Flight> flights = new ArrayList<Flight>();

        ArrayList<Integer> planeIndex = new ArrayList<Integer>(PlaneGenerator.planeCnt);
        for (int p = 0; p < PlaneGenerator.planeCnt; p++) planeIndex.add(0);
        for (Airline airline : DataGenerator.airlines) {
//            for (int j = 0; j < 3; j++) {
            String id = airline.getAirlineID();
            String lb = String.valueOf(id.charAt(id.length() - 1));
            RandomDDPair ddPair = new RandomDDPair();
            int depIndex = ddPair.getDeparture() - 1;
            int desIndex = ddPair.getDestination() - 1;
            int pIndex = RandomNumber.randomNumber(1, PlaneGenerator.planeCnt) - 1;
            while (planeIndex.get(pIndex) != 0) {
                pIndex = RandomNumber.randomNumber(1, PlaneGenerator.planeCnt) - 1;
            }
            planeIndex.set(pIndex, 1);
            Plane plane = DataGenerator.planes.get(pIndex);
            Flight flight = new Flight(DataGenerator.airports.get(depIndex), DataGenerator.airports.get(desIndex),
                    "F" + lb + "00_" + turn + "00" + turn, new Date(),
                    airline, DataGenerator.planes.get(pIndex));
//            Flight flight = new Flight(DataGenerator.airports.get(1), DataGenerator.airports.get(3),
//                    "F" + lb + "00_" + turn + "00" + turn, new Date(),
//                    airline, DataGenerator.planes.get(pIndex));
            flights.add(flight);
            airline.createFlight(flight);
            TicketManagementSingleton.addFlight(flight);
//            }
        }
//        flights.add(new Flight(airports.get(2), airports.get(0), "F000001", date, airlines.get(0)));
//        airlines.get(0).createFlight(flights.get(i++));
//        flights.add(new Flight(airports.get(2), airports.get(1), "F000002", date, airlines.get(0)));
//        airlines.get(0).createFlight(flights.get(i++));
//        flights.add(new Flight(airports.get(3), airports.get(1), "F000003", date, airlines.get(0)));
//        airlines.get(0).createFlight(flights.get(i++));
//        flights.add(new Flight(airports.get(3), airports.get(1), "F100001", date, airlines.get(1)));
//        airlines.get(1).createFlight(flights.get(i++));
//        flights.add(new Flight(airports.get(3), airports.get(0), "F100002", date, airlines.get(1)));
//        airlines.get(1).createFlight(flights.get(i++));
//        flights.add(new Flight(airports.get(0), airports.get(2), "F200001", date, airlines.get(2)));
//        airlines.get(2).createFlight(flights.get(i++));
//        flights.add(new Flight(airports.get(0), airports.get(3), "F200002", date, airlines.get(2)));
//        airlines.get(2).createFlight(flights.get(i++));
//        flights.add(new Flight(airports.get(1), airports.get(3), "F300001", date, airlines.get(3)));
//        airlines.get(3).createFlight(flights.get(i++));
//        flights.add(new Flight(airports.get(1), airports.get(2), "F300002", date, airlines.get(3)));
//        airlines.get(3).createFlight(flights.get(i));

//        for(Airline a : airlines){
//            ArrayList<Flight> f = a.getFlightsList();
//            for (Flight flight: f){
//                flight.printAirline();
//            }
//        }
        return flights;
    }

    public void updateTurn() {
        turn++;
    }
}
