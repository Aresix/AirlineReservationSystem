package facade_functionClass;

import generatorClass.DataGenerator;
import generatorClass.FlightGenerator;
import myClass.AirlineTicket;
import myClass.Flight;
import myClass.OrderRecord;
import singleton.AllOrderSingleton;
import singleton.TicketManagementSingleton;

import java.util.ArrayList;

public class RefreshClass {

    private ArrayList<OrderRecord> records = new ArrayList<OrderRecord>();
    private int indexR = 0;

    public void refresh() {
        new FlightGenerator().updateTurn();
        // 处理旧机票
        ArrayList<Flight> flights = FlightGenerator.getFlights();
        // 上一轮票不再出售
        TicketManagementSingleton.clearFlight();
        // 更新票的状态
        records = AllOrderSingleton.getAllOrder();
        if (records != null) {
            for (int i = indexR; i < records.size(); i++) {
                indexR++;
                String status = records.get(i).getTicketState();
                if (status.equals("未使用"))
                    AllOrderSingleton.updateStatus(records.get(i), AirlineTicket.getState(AirlineTicket.TicketState.IN_TRAVEL));
                else if (status.equals("旅途中"))
                    AllOrderSingleton.updateStatus(records.get(i), AirlineTicket.getState(AirlineTicket.TicketState.USED));
            }
        }

        // 获取新机票 並更新到票务系统
        DataGenerator.flights = FlightGenerator.initFlight();
        //没有装填？***
        for (Flight f : DataGenerator.flights) {
            TicketManagementSingleton.addFlight(f);
        }

        // TODO: 删了旧机票
        // TODO： 更新追踪
    }
}
