package Lesson1;

public class Main {
    public static void main(String[] args) {
        Trafficable [] trafficables = {
                new Person("Stive", 500, 15),
                new Cat("Barsik", 200, 2),
                new Robot("X-Robot", 5000, 20)
        };
        Overcomable [] overcomables = {
                new Treadmill(100),
                new Wall(2),
                new Treadmill(600),
                new Wall(16)
        };

        for (Trafficable t: trafficables ){
            for (Overcomable overcomable : overcomables) {
               if(!overcomable.overcome(t)){
                   break;
               }
            }
        }
    }
}
