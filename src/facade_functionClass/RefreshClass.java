package facade_functionClass;

import generatorClass.FlightGenerator;

public class RefreshClass {
    public void refresh() {
        new FlightGenerator().updateTurn();
        // 获取新机票
        FlightGenerator.initFlight();
        // TODO: 删了旧机票
        // TODO： 更新追踪
    }
}
