package myClass;

public class OrderRecord {
    private static int id = 0;
    private int oid;
    private Flight flight;
    private AirlineTicket ticket;
    private Passenger passenger;


    private String FlightID;
    private String departure;
    private String destination;
    private String PlaneID;
    private String PassengerName;
    private int TotalPrice;
    private String TicketState;

    public OrderRecord(ReservationItem r) {
        this.oid = ++id;
        this.flight = r.getTicket().getFlight();
        this.ticket = r.getTicket();
        this.passenger = r.getPassenger();

        this.FlightID = this.flight.getFlightID();
        this.departure = this.flight.getDeparture().getName();
        this.destination = this.flight.getDestination().getName();
        this.PlaneID = this.ticket.getPlane().getPlaneID();
        this.PassengerName = this.passenger.getName();
        this.TotalPrice = this.ticket.getPrice();
        this.TicketState = this.ticket.getState(this.ticket.getTicketState());
    }

//    public void getOrderRecord(){
//
//    }

    public void printRecord(OrderRecord orderRecord) {
        Flight f = orderRecord.flight;
        AirlineTicket t = orderRecord.ticket;
        Passenger p = orderRecord.passenger;
        System.out.println(orderRecord.oid + ".\t\t" + f.getFlightID() + "\t\t\t" + f.getDeparture().getName() + "\t\t\t"
                + f.getDestination().getName() + "\t\t\t" + orderRecord.getPlaneID() + "\t\t\t" + p.getName()
                + "\t\t\t" + t.getPrice() + "\t\t\t" + orderRecord.getTicketState());
    }

    public String getFlightID() {
        return FlightID;
    }

    public void setFlightID(String flightID) {
        FlightID = flightID;
    }

    public String getPlaneID() {
        return PlaneID;
    }

    public void setPlaneID(String planeID) {
        PlaneID = planeID;
    }

    public String getTicketState() {
        return TicketState;
    }
}
