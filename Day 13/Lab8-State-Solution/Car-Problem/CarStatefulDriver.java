package lab8;

public class CarStatefulDriver {
    public static void main(String[] args) {
        Car car = new Car(0);
        System.out.println("-->" +car);

        car.changeSpeed(6);
        System.out.println("-->" + car);

        car.changeSpeed(15);
        System.out.println("-->" + car);

        car.changeSpeed(55);
        System.out.println("-->" + car);

    }
}
