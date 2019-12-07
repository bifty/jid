package com.semanticsquare.oop.e6;

public class SilverPlan extends HealthInsurancePlan {

    private final double factor = 0.06;

    public SilverPlan() {
        super();
        this.setCoverage(0.7);
        this.setDiscount(30.0);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary * factor ;
    }
}
