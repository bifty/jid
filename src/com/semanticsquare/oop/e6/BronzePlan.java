package com.semanticsquare.oop.e6;

public class BronzePlan extends HealthInsurancePlan {

    private final double factor = 0.05;

    public BronzePlan() {
        super();
        this.setCoverage(0.6);
        this.setDiscount(25.0);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary * factor ;
    }
}
