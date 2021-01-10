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
//        return ticket.getPrice();
        return ticket.getNewPrice();
    }

    public void printTicket(Passenger passenger) {
        System.out.println("============================================================");
        System.out.println("乘客姓名：\t" + passenger.getName());
        System.out.println("身份证号：\t" + passenger.getIDcard());
        System.out.println("联系方式：\t" + passenger.getTelephone());
        if (ticket.getTicketState() == AirlineTicket.TicketState.UNSOLD)
            ticket.setTicketState(AirlineTicket.TicketState.UNPAID);
        ticket.printTicket(passenger);
    }
}
