package lab8;

public class GearTwoState implements State{

    Car car;
    public GearTwoState(Car car){
        this.car = car;
    }

    @Override
    public int getGearNumber() {
        return 2;
    }

    @Override
    public Car changeSpeed(int speed) {
        System.out.println("Shifting Gear to Two");
        car.setState(car.getGearTwo());
        return car;
    }
}
