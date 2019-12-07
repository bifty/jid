package com.semanticsquare.oop.e6;

public class PlatinumPlan extends HealthInsurancePlan {

    public PlatinumPlan() {
        super();
        this.setCoverage(0.9);
        this.setDiscount(50.0);
        this.setFactor(0.08);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary * getFactor() ;
    }
}
