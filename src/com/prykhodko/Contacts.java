package com.prykhodko;

public class Contacts {

    private String name;
    private String phoneNumber;

    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public static Contacts newContact(String name, String phone){
        return new Contacts(name, phone);
    }
}
