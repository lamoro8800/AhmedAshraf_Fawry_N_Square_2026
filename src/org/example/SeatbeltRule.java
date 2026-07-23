package org.example;

public class SeatbeltRule implements IRule {
    private static final int FEE = 100;

    @Override
    public Violation check(Case obs) {
        if (!obs.isSeatbeltFastened()) {
            return new Violation("Seatbelt not fastned", FEE);
        }
        return null;
    }
}
