package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        int currentBalance = 0;

        for( int i = 0; i <charges.size(); i++){
            currentBalance += charges.get(i).getCharge();
        }
        return currentBalance;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        String customerData = ("Customer ID: " + getId()+ " | "+" Customer Name: " + getName() + " | " + "Customer Balance: " + getBalance() + " . ");
        return customerData;
    }
}
