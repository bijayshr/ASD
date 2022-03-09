package lab8;

public class GearThreeState implements State {

    Car car;
    public GearThreeState(Car car){
        this.car = car;
    }

    @Override
    public int getGearNumber() {
        return 3;
    }

    @Override
    public Car changeSpeed(int speed) {
        System.out.println("Shifting Gear to Three");
        car.setState(car.getGearThree());
        return car;
    }
}
