package lab8;

public class GearFourState implements State{

    Car car;
    public GearFourState(Car car){
        this.car = car;
    }


    @Override
    public int getGearNumber() {
        return 4;
    }

    @Override
    public Car changeSpeed(int speed) {
        System.out.println("Shifting Gear to Four");
        car.setState(car.getGearFour());
        return car;
    }
}
