package myClass;

public class Payment {
    public void makePayment(int cashTendered){
        InnerBank bank=new InnerBank();
        bank.makePayment(cashTendered);
    }
}
