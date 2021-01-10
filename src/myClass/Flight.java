package myClass;

import singleton.TicketManagementSingleton;

import java.util.Date;

import static util.RandomNumber.randomNumber;

public class Flight {
    private Airport departure;
    private Airport destination;
    private String flightID;
    private Date date;
    private Airline airline;
    private Plane plane;
    private int basePrice; // 航班基础价格

    public Flight(Airport departure, Airport destination, String flightID, Date date, Airline airline) {
        this.departure = departure;
        this.destination = destination;
        this.flightID = flightID;
        this.date = date;
        this.airline = airline;
        this.basePrice = randomNumber(11, 30) * 100;
    }

    public Flight(Airport departure, Airport destination, String flightID, Date date, Airline airline, Plane plane) {
        this.departure = departure;
        this.destination = destination;
        this.flightID = flightID;
        this.date = date;
        this.airline = airline;
        this.plane = plane;
        this.basePrice = randomNumber(11, 30) * 100;
    }

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void printAirline() {
        System.out.println("====================================================");
        System.out.println("当前航班信息：");
        System.out.println("航班号： " + flightID);
        System.out.println("出发地: 【" + departure.getAirportID() + "】" + departure.getName() +
                " (" + departure.getCity().getName() + ", " + departure.getCity().getCountry() + ")");
        System.out.println("目的地: 【" + destination.getAirportID() + "】" + destination.getName() +
                " (" + destination.getCity().getName() + ", " + destination.getCity().getCountry() + ")");
        System.out.println("时  刻: " + date.toString());
        System.out.println("航空公司: 【" + airline.getAirlineID() + "】" + airline.getName());
        System.out.println("基础票价: " + basePrice + " 元 （早买早享受，晚买就涨价）");
        if (plane != null)
            plane.getPlane();
    }


}
