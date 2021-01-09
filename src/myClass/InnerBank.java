package myClass;

public class InnerBank {
    public void makePayment(int amount) {
        System.out.println("本次订票总计\t" + amount + "\t元。您已完成支付。");
    }

    public void refundPayment(int amount) {
        System.out.println("本次退款总计\t" + amount + "\t元。退款已到账。");
    }
}
