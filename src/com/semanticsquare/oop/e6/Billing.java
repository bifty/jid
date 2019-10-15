package com.semanticsquare.oop.e6;

public class Billing {

    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];
        double insuranceAmount = 0.0;
        double patientAmount = amount - 20.0;

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

        if (patientInsurancePlan != null) {
            insuranceAmount = patientInsurancePlan.getCoverage() * amount;
            patientAmount = amount - insuranceAmount - patientInsurancePlan.getDiscount();
        }

        payments[0] = insuranceAmount;
        payments[1] = patientAmount;

        return payments;
    }

}