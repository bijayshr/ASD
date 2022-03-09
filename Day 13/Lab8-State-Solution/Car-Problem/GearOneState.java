package lab8;

public class GearOneState implements State{


    Car car;
    public GearOneState(Car car){
        this.car = car;
    }

    @Override
    public int getGearNumber() {
        return 1;
    }

    @Override
    public Car changeSpeed(int speed) {
        System.out.println("Shifting Gear to One");
        car.setState(car.getGearOne());
        return car;
    }
}
