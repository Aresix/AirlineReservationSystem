package singleton;

import myClass.OrderRecord;

import java.util.ArrayList;

public class AllOrderSingleton extends ArrayList<OrderRecord> {
    private static AllOrderSingleton allOrder;

    private AllOrderSingleton() {
    }

    public static void addOrderRecord(OrderRecord orderRecord) {
        if (allOrder == null) allOrder = new AllOrderSingleton();
        allOrder.add(orderRecord);
//        orderRecord.printRecord(orderRecord);
    }

    public static void printRecord() {
        if (allOrder == null || allOrder.isEmpty()) System.out.println("呀，这里空空如也，快去下单试试吧~");
        else {
            System.out.println("序号\t航班号\t\t\t出发地\t\t\t\t目的地\t\t\t\t飞机\t\t\t乘坐人\t\t\t价格\t\t\t实付\t\t\t订单状态");
            for (OrderRecord o : allOrder) {
                o.printRecord(o);
            }
        }
    }


    public static synchronized ArrayList<OrderRecord> getAllOrder() {
        return allOrder;
    }
}
