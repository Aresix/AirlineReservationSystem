package generatorClass;

import myClass.Plane;

import java.util.ArrayList;

public class PlaneGenerator {
    public static ArrayList<Plane> initPlane() {
        ArrayList<Plane> planes = new ArrayList<Plane>();
        planes.add(new Plane("P0001", 50));
        planes.add(new Plane("P0002", 80));
        planes.add(new Plane("P0003", 80));
        planes.add(new Plane("P0004", 70));
        planes.add(new Plane("P0005", 70));

//        for (Plane p:planes) p.getPlane();
        return planes;
    }
}
