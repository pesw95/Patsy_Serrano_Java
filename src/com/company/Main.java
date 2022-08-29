package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"},
            new String[]{"2", "Daily Planet", "-7500", "01-10-2022"},
            new String[]{"1", "Wayne Enterprises", "18000", "12-22-2021"},
            new String[]{"3", "Ace Chemical", "-48000", "01-10-2022"},
            new String[]{"3", "Ace Chemical", "-95000", "12-15-2021"},
            new String[]{"1", "Wayne Enterprises", "175000", "01-01-2022"},
            new String[]{"1", "Wayne Enterprises", "-35000", "12-09-2021"},
            new String[]{"1", "Wayne Enterprises", "-64000", "01-17-2022"},
            new String[]{"3", "Ace Chemical", "70000", "12-29-2022"},
            new String[]{"2", "Daily Planet", "56000", "12-13-2022"},
            new String[]{"2", "Daily Planet", "-33000", "01-07-2022"},
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"},
            new String[]{"2", "Daily Planet", "33000", "01-17-2022"},
            new String[]{"3", "Ace Chemical", "140000", "01-25-2022"},
            new String[]{"2", "Daily Planet", "5000", "12-12-2022"},
            new String[]{"3", "Ace Chemical", "-82000", "01-03-2022"},
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"}

    );


    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();
        List<Integer> id = new ArrayList<>();

        for (String[] data : customerData) {

            int currentID = Integer.parseInt(data[0]);
            if (id.contains(currentID)) {

                for (Customer customer : customers) {

                    if (customer.getId() == currentID) {

//                       Update existing customer data
                        Customer prevCustomer = customers.get(customers.indexOf(customer));
                        AccountRecord accountRecord = new AccountRecord();
                        accountRecord.setCharge(Integer.parseInt(data[2]));
                        accountRecord.setChargeDate(data[3]);
                        prevCustomer.getCharges().add(accountRecord);

                    }
                }

            } else {
                id.add(currentID);

//          Create new Customer

                Customer customer = new Customer();
                customer.setId(Integer.parseInt(data[0]));
                customer.setName(data[1]);

//          Create new Account Record

                AccountRecord accountRecord = new AccountRecord();
                accountRecord.setCharge(Integer.parseInt(data[2]));
                accountRecord.setChargeDate(data[3]);

                customer.getCharges().add(accountRecord);

//          Add New Customer to List

                customers.add(customer);
            }
        }

//        Negative Accounts
        List<Customer> negativeAccts = customers.stream()
                .filter(customer -> (customer.getBalance())<0 )
                .collect(Collectors.toList());
        System.out.println("Negative Accounts");
        negativeAccts.stream().forEach(System.out::println);


//   Space holder
        System.out.println("");

//        Positive Accounts
        List<Customer> positiveAccts = customers.stream()
                .filter(customer -> (customer.getBalance()) >0)
                .collect(Collectors.toList());
            System.out.println("Positive accounts:");
            positiveAccts.stream().forEach(System.out::println);



        }


}

