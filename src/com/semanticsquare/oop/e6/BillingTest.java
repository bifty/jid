package com.semanticsquare.oop.e6;

public class BillingTest {

    public static void main(String[] args) {
        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        Patient patient = new Patient();
//        patient.setInsurancePlan(insurancePlan);

        double amount = 1000.0;
        double[] payments = Billing.computePaymentAmount(patient, amount);

        System.out.println("Amount: " + amount);
        System.out.println("Insurence: " + payments[0]);
        System.out.println("Patient: " + payments[1]);
    }
}
