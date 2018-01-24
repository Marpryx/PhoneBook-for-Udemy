/////////////////////////////////////////////////////////////////////
// The MobilePhone class is used to do some manipulations on the   //
// Contacts object, such as add a new contact, update it or remove.//
//                                                                 //
////////////////////////////////////////////////////////////////////


package com.prykhodko;

import java.util.ArrayList;
import java.util.Optional;

public class MobilePhone {

    private ArrayList<Contacts> contact = new ArrayList<Contacts>();


    public void Quit(){

    }

    public void printContacts() {
        if (contact.size() == 0) {
            System.out.println("The Phone Book is empty");
        } else{
            System.out.println("The Phone Book contacts: ");
        for (int i = 0; i < contact.size(); i++) {
            System.out.println("The contact # " + (i + 1) + " is: " + contact.get(i).getName() + " "+ contact.get(i).getPhoneNumber());
        }
    }
    }

    /**
     * Add new contact to the Phone book
     * @param newContact
     * @return
     */
    public boolean addContact(Contacts newContact){
        if(searchContact(newContact.getName()) >=0){
            System.out.println("The contact already exits in the Phone Book");
            return false;
        }

        contact.add(newContact);
        return true;
    }

    /**
     * Updates an existing contact with the new fields' values
     * @param oldContact
     * @param newContact
     * @return
     */
    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int contactPosition = searchContact(oldContact);

        if(contactPosition <0){
            System.out.println(oldContact.getName() + " is not on the Phone book");
            return false;
        }

        contact.set(contactPosition, newContact);
        System.out.println(oldContact.getName() + " was modified to " + newContact.getName() );
        return true;
    }

    /**
     * Removes the existing contact
     * @param contact
     */
    public void removeContact(Contacts contact) {
        int position = searchContact(contact);

        if (position >= 0) {
            this.contact.remove(position);
            System.out.println(contact.getName() + " was removed from the phone Book");
        }
    }

    /**
     * Searches an existing contact
     * @param contact
     * @return
     */

    public int searchContact(Contacts contact){
        return this.contact.indexOf(contact);
        }

    public int searchContact(String searchContact){
        for(int i=0; i < contact.size(); i++){
            Contacts contact = this.contact.get(i);

            if(contact.getName().equalsIgnoreCase(searchContact)){
                return i;
            }
        }
        return -1;

    }

    public String queryContact(Contacts contact){
        Optional<String> person = Optional.of(contact.getName());
        if(searchContact(contact) >=0){
            return person.get();
        }
        return Optional.empty().toString();

    }

    public Contacts queryContact(String name){
        int position = searchContact(name);
        if(position >=0){
            return this.contact.get(position);
        }
        return null;
    }


}
