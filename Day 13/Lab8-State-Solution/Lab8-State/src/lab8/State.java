package lab8;

public interface State {
    int getGearNumber();
    Car changeSpeed(int speed);
}
