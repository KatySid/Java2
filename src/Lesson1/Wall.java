package Lesson1;

public class Wall implements Overcomable{
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Trafficable trafficable) {
       return trafficable.jump(height);
    }
}
