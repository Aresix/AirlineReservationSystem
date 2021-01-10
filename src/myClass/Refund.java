package myClass;

public class Refund {
    public void refund(AirlineTicket ticket){
        System.out.println("机票编号为【"+ticket.getTicketID()+"】已退票。");
        System.out.println(">>>发起退款<<<");
        InnerBank bank=new InnerBank();
        bank.refundPayment(ticket.getNewPrice());
    }
}
