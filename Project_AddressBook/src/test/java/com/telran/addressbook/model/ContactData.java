package com.telran.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String surName;
    private final String company;
    private final String phoneNumber;
    private final String workPhoneNumber;
    private final String email;

    public ContactData(String firstName, String surName, String company, String phoneNumber, String workPhoneNumber, String email) {
        this.firstName = firstName;
        this.surName = surName;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.workPhoneNumber = workPhoneNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getCompany() {
        return company;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
