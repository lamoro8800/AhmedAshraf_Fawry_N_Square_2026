package org.example;

public class SpeedRule implements IRule {
    private static final int FEE = 300;
    private final CarType carType;
    private final int maxSpeed;

    public SpeedRule(CarType carType, int maxSpeed) {
        this.carType = carType;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public Violation check(Case obs) {
        if (obs.getCarType() == carType && obs.getSpeed() > maxSpeed) {
            String desc = "speed of " + obs.getSpeed() + " exceeded max allowed " + maxSpeed;
            return new Violation(desc, FEE);
        }
        return null;
    }
}
