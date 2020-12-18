package Lesson1;

public class Cat implements Trafficable{
    private String name;
    private double distance;
    private double height;

    public Cat (String name, double distance, double height){
        this.name = name;
        this.distance = distance;
        this.height = height;
    }

    @Override
    public boolean run (double s) {
        if (s <= distance) {
            System.out.println(name + " ran " + s + " meters");
            return  true;
        } else {
            System.out.println(name + " can not run");
            return false;
        }
    }

    @Override
    public boolean jump(double h) {
        if (h<=height){
            System.out.println(name + " jump " + h + " meters");
            return true;
        } else {
            System.out.println(name + " can not jump");
            return false;
        }
    }
}
