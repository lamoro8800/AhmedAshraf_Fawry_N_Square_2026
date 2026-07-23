package org.example;

import java.util.ArrayList;
import java.util.List;

public class Fine {
    private final String plateNumber;
    private final List<Violation> violations = new ArrayList<>();

    public Fine(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() { return plateNumber; }

    public void addViolation(Violation v) { violations.add(v); }

    public boolean hasViolations() { return !violations.isEmpty(); }

    public int getTotalAmount() {
        int total = 0;
        for (Violation v : violations) total += v.fee;
        return total;
    }

    public void print() {
        System.out.println("Traffic fine for car " + plateNumber);
        System.out.println("Total amount: " + getTotalAmount() + " EGP");
        System.out.println("Violations:");
        for (Violation v : violations) {
            System.out.println("- " + v.description + " : " + v.fee + " EGP");
        }
    }
}
