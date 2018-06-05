package com.telran.addressbook.model;

import java.io.File;

public class ContactData {
    private String firstName;
    private String surName;
    private String company;
    private String phoneNumber;
    private String workPhoneNumber;
    private String email;
    private File photo;

    public ContactData(){}

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
    public ContactData withFName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public File getPhoto() {
        return photo;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getSurName() {
        return surName;

    }

    public ContactData withSurName(String surName) {
        this.surName = surName;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public ContactData wihtCompany(String company) {
        this.company = company;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ContactData phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public ContactData withWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }
}
