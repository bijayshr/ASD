package lab8;

public class GearZeroState implements State{
    Car car;

    public GearZeroState(Car car){
        this.car = car;
    }

    @Override
    public int getGearNumber() {
        return 0;
    }

    @Override
    public Car changeSpeed(int speed) {
        System.out.println("Shifting Gear to Zero");
        car.setState(car.getGearZero());
        return car;
    }
}
