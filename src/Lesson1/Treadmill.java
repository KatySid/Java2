package Lesson1;

public class Treadmill implements Overcomable{
    private double distance;

    public Treadmill(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean overcome(Trafficable trafficable) {
       return trafficable.run(distance);
    }
}
