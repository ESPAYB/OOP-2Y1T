package com.mycompany.hospitalinpatientbillingandinsurancesystem;

public class InPatient extends Patient {
    private int daysStayed;
    private double dailyRate;
    private double medicationCost;
    private boolean hasInsurance;

    public InPatient(String patientId, String name, int age, int daysStayed, double dailyRate, double medicationCost, boolean hasInsurance) {
        super(patientId, name, age);
        this.daysStayed = daysStayed;
        this.dailyRate = dailyRate;
        this.medicationCost = medicationCost;
        this.hasInsurance = hasInsurance;
    }

    public int getDaysStayed() {
        return daysStayed;
    }

    public void setDaysStayed(int daysStayed) {
        if (daysStayed >= 0) {
            this.daysStayed = daysStayed;
        }
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        if (dailyRate >= 0) {
            this.dailyRate = dailyRate;
        }
    }

    public double getMedicationCost() {
        return medicationCost;
    }

    public void setMedicationCost(double medicationCost) {
        if (medicationCost >= 0) {
            this.medicationCost = medicationCost;
        }
    }

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    // Business Logic Calculations
    public double getAdjustedMedicationCost() {
        if (getAge() >= 60) {
            return medicationCost * 0.85; // 15% discount for seniors
        }
        return medicationCost;
    }

    public double getGrossTotal() {
        return (daysStayed * dailyRate) + getAdjustedMedicationCost();
    }

    public double getFinalBill() {
        double gross = getGrossTotal();
        if (hasInsurance) {
            return gross * 0.60; // 40% reduction for insured patients
        }
        return gross;
    }
}