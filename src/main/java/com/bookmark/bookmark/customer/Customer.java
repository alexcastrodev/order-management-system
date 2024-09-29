package com.bookmark.bookmark.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String phoneNumber;

    public Customer(String firstName, String lastName, String phoneNumberCountryCode, String phoneNumber) {
        this.fullName = String.format("%s %s", firstName, lastName);
        this.phoneNumber = String.format("%s%s", phoneNumberCountryCode, phoneNumber);
    }

    public Customer() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
