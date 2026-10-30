package com.mycompany.bikemaintenancetracker;

public interface Maintainable {

    boolean needsMaintenance();

    void resetMileage();

    void displayStatus();
}
