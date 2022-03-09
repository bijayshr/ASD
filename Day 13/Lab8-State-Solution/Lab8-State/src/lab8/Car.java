package lab8;

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;

public class Car {

    State gearZero;
    State gearOne;
    State gearTwo;
    State gearThree;
    State gearFour;
    State gearFive;

    State state;
    int speed = 0;

    public Car(){};
    public Car(int speed){
        gearZero = new GearZeroState(this);
        gearOne = new GearOneState(this);
        gearTwo = new GearTwoState(this);
        gearThree = new GearThreeState(this);
        gearFour = new GearFourState(this);
        gearFive = new GearFiveState(this);

        if(speed == 0){
            state = gearZero;
        }
    }

    public int changeSpeed(int speed){
        System.out.println("state :: " + this.state);
        this.speed = speed;
        determineState(speed);
        state.changeSpeed(speed);
        return state.getGearNumber();
    }

    private void determineState(int speed) {
        if(speed == 0){
            state = gearZero;
        }else if(speed > 0 && speed < 5){
            state = gearOne;
        }else if(speed > 5 && speed < 10){
            state = gearTwo;
        } else if(speed > 10 && speed < 30){
            state = gearThree;
        }else if(speed > 30 && speed < 55){
            state = gearFour;
        }else{
            if(speed >= 55){
                state = gearFive;
            }
        }
    }


    void setState(State state){
        this.state = state;
    }

    public State getGearZero() {
        return gearZero;
    }

    public State getGearOne() {
        return gearOne;
    }

    public State getGearTwo() {
        return gearTwo;
    }

    public State getGearThree() {
        return gearThree;
    }

    public State getGearFour() {
        return gearFour;
    }

    public State getGearFive() {
        return gearFive;
    }

    @Override
    public String toString() {
        return "CarStateful{" +
                "speed=" + speed +
                '}';
    }
}
