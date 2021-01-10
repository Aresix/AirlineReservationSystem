package singleton;

import myClass.Flight;

import java.util.HashMap;

public class TicketManagementSingleton extends HashMap<Flight, Integer> {
    private static TicketManagementSingleton ticketManagement;

    private TicketManagementSingleton() {
    }

    public static void addFlight(Flight flight) {
        if (ticketManagement == null) ticketManagement = new TicketManagementSingleton();
        ticketManagement.put(flight, flight.getPlane().getSeating());
    }

    public static boolean bookTicket(Flight flight) {
        int tp = ticketManagement.get(flight);
        if (tp == 0) return false;
        else {
            ticketManagement.replace(flight, tp - 1);
            return true;
        }
    }

    public static void refundTicket(Flight flight) {
        int tp = ticketManagement.get(flight);
        ticketManagement.replace(flight, tp + 1);
    }

    public static int getTicketCnt(Flight flight) {
        return ticketManagement.get(flight);
    }
}
