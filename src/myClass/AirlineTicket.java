package myClass;

import singleton.TicketManagementSingleton;

public class AirlineTicket {
    public enum TicketState {UNSOLD, UNPAID, UNUSED, IN_TRAVEL, USED, CANCELED}

    private static int id = 0;
    private String ticketID;
    private Flight flight;
    private Plane plane;
    private int price;
    private int newPrice;
    private int seatNO = 0;
    private TicketState ticketState;

    public AirlineTicket(Flight flight, Plane plane) {
        String tidRoot = "TID_111512200202_"; // 机票编号Root
        ticketID = tidRoot + id; // 完整的机票编号
        id++;
        this.flight = flight; // 指定航班
        this.plane = plane; // 指定飞机
        int dif = plane.getSeating() - TicketManagementSingleton.getTicketCnt(flight);
        this.price = flight.getBasePrice() + 2 * dif; // 指定价格
        this.newPrice = this.price;
        seatNO = id;
        ticketState = TicketState.UNSOLD;
    }

    public TicketState getTicketState() {
        return ticketState;
    }

    public void setTicketState(TicketState ticketState) {
        this.ticketState = ticketState;
    }

    public String getTicketID() {
        return ticketID;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }

    public String getState(TicketState ticketState) {
        String res = "";
        switch (ticketState) {
            case USED:
                res = "已完成";
                break;
            case UNSOLD:
                res = "待出售";
                break;
            case UNUSED:
                res = "未使用";
                break;
            case IN_TRAVEL:
                res = "旅途中";
                break;
            case UNPAID:
                res = "未支付";
                break;
            case CANCELED:
                res = "已取消";
                break;
        }
        return res;
    }

    public void printTicket(Passenger passenger) {
        System.out.println("============================================================");
        System.out.println("机票编号：【" + ticketID + "】");
        System.out.println("航班编号：【" + flight.getFlightID() + "】");
        plane.getPlane();
        System.out.println(passenger.getName() + "\t的座位号为：" + seatNO);
        flight.printAirline();
        System.out.println("============================================================");
        System.out.println("价   格：" + price + "元");
        System.out.println("实   付：" + newPrice + "元");
        System.out.println("当前机票状态：【" + getState(ticketState) + "】");
        System.out.println();
    }
}
