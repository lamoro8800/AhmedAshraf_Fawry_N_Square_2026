package org.example;

public class Main {
    public static void main(String[] args) {
        Radar radar = new Radar();

        radar.addRule(new SeatbeltRule());
        radar.addRule(new SpeedRule(CarType.TRUCK, 60));
        radar.addRule(new SpeedRule(CarType.PRIVATE, 80));


        System.out.println("==== 1. Car with two violations ====");
        radar.observe(new Case("ABC1234", "2026-07-23", CarType.PRIVATE, 94, false));


        System.out.println("\n==== 2. Truck over its own limit ====");
        radar.observe(new Case("TRK5566", "2026-07-23", CarType.TRUCK, 70, true));



        System.out.println("\n==== All fines: plate -> total amount ====");
        for (Fine fine : radar.getAllFines()) {
            System.out.println(fine.getPlateNumber() + " -> " + fine.getTotalAmount() + " EGP");
        }

        System.out.println("\n==== Violation counts ====");
        for (var entry : radar.getViolationCounts().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
