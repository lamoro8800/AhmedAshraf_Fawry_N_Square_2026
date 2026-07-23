package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Radar {
    private final List<IRule> rules = new ArrayList<>();
    private final List<Fine> fines = new ArrayList<>();
    private final Map<String, Integer> violationCounts = new HashMap<>();

    public void addRule(IRule rule) {
        rules.add(rule);
    }

    public void observe(Case obs) {
        Fine fine = new Fine(obs.getPlateNumber());

        for (IRule rule : rules) {
            Violation v = rule.check(obs);
            if (v != null) {
                fine.addViolation(v);
                violationCounts.merge(v.description, 1, Integer::sum);
            }
        }

        if (fine.hasViolations()) {
            fines.add(fine);
            fine.print();
        }
    }

    public List<Fine> getAllFines() {
        return fines;
    }

    public Map<String, Integer> getViolationCounts() {
        return violationCounts;
    }
}
