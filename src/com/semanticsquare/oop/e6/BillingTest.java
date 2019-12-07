package com.semanticsquare.oop.e6;

public class BillingTest {

    public static void main(String[] args) {
        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        Patient patient = new Patient();

        double amount = 1000.0;
        double[] payments = Billing.computePaymentAmount(patient, amount);

        patient.setInsurancePlan(insurancePlan);
        double planCosts = insurancePlan.computeMonthlyPremium(amount);

        System.out.println("Amount: " + amount);
        System.out.println("Insurence: " + payments[0]);
        System.out.println("Patient: " + payments[1]);
        System.out.println("Plan costs: " + planCosts);

    }
}
