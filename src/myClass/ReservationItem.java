package myClass;

public class ReservationItem {
    private AirlineTicket ticket;
    private Passenger passenger;

    public ReservationItem(AirlineTicket ticket, Passenger passenger) {
        this.ticket = ticket;
        this.passenger = passenger;
    }

    public AirlineTicket getTicket() {
        return ticket;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public int getSubtotal(){
        return ticket.getPrice();
    }

    public void printTicket(String passengerName){
        System.out.println("============================================================");
        System.out.println("乘客姓名：\t"+passenger.getName());
        System.out.println("身份证号：\t"+passenger.getIDcard());
        System.out.println("联系方式：\t"+passenger.getTelephone());
        ticket.printTicket(passengerName);
    }
}
