package com.semanticsquare.oop.e6;

public class GoldPlan extends HealthInsurancePlan {

    private final double factor = 0.07;

    public GoldPlan() {
        super();
        this.setCoverage(0.8);
        this.setDiscount(40.0);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary * factor;
    }
}
