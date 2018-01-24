/////////////////////////////////////////////////////////////
// The Contacts class is used to create a new contact      //
// or to get Name/Phone from the existing contacts.        //
//                                                         //
/////////////////////////////////////////////////////////////

package com.prykhodko;

public class Contacts {

    private String name;
    private String phoneNumber;

    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /////////Getters/////////////////
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Creates new contact
     * @param name
     * @param phone
     * @return
     */
    public static Contacts newContact(String name, String phone){
        return new Contacts(name, phone);
    }
}
