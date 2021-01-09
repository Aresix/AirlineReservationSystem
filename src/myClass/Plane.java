package myClass;

public class Plane {
    private String planeID;
    private int seating;

    public Plane(String planeID, int seating) {
        this.planeID = planeID;
        this.seating = seating;
    }

    public String getPlaneID() {
        return planeID;
    }

    public void setPlaneID(String planeID) {
        this.planeID = planeID;
    }

    public int getSeating() {
        return seating;
    }

    public void setSeating(int seating) {
        this.seating = seating;
    }

    public void getPlane(){
        System.out.println("====================================================");
        System.out.println("本架飞机编号为：【"+planeID+"】\t座位数为："+seating);
    }
}
