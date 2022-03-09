package lab8;

public class GearFiveState implements State{

    Car car;
    public GearFiveState(Car car){
        this.car = car;
    }

    @Override
    public int getGearNumber() {
        return 5;
    }

    @Override
    public Car changeSpeed(int speed) {
        System.out.println("Shifting Gear to Five");
        car.setState(car.getGearFive());
        return car;
    }
}
