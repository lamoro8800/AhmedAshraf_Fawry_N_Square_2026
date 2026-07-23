package org.example;

public class Case {
    private String plateNumber;
    private String date;
    private CarType carType;
    private int speed;
    private boolean seatbeltFastened;

    public String getPlateNumber() { return plateNumber; }
    public CarType getCarType() { return carType; }
    public int getSpeed() { return speed; }
    public boolean isSeatbeltFastened() { return seatbeltFastened; }

    public Case(String plateNumber, String date, CarType carType, int speed, boolean seatbeltFastened) {
        this.plateNumber = plateNumber;
        this.date = date;
        this.carType = carType;
        this.speed = speed;
        this.seatbeltFastened = seatbeltFastened;
    }
}
