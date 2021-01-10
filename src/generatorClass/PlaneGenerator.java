package generatorClass;

import myClass.Plane;
import util.RandomNumber;

import java.util.ArrayList;

public class PlaneGenerator {
    public static int planeCnt = 15;

    public static ArrayList<Plane> initPlane() {
        ArrayList<Plane> planes = new ArrayList<Plane>();
        String pre = "P00";
        for (int i = 0; i < planeCnt; i++) {
            String ppre = i < 10 ? pre + "0" : pre;
            planes.add(new Plane(ppre + i, RandomNumber.randomNumber(5, 9) * 10));
        }
//        planes.add(new Plane("P0001", 50));
//        planes.add(new Plane("P0002", 80));
//        planes.add(new Plane("P0003", 80));
//        planes.add(new Plane("P0004", 70));
//        planes.add(new Plane("P0005", 70));

//        for (Plane p:planes) p.getPlane();
        return planes;
    }
}
