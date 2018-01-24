package com.prykhodko;

import java.util.ArrayList;
import java.util.Optional;

public class MobilePhone {

    private ArrayList<Contacts> contact = new ArrayList<Contacts>();


    public void Quit(){

    }

    public void printContacts(){
        for(int i=0; i<contact.size(); i++){
            System.out.println("The contact # " + (i + 1) + " is: " + contact.get(i).getName() + contact.get(i).getPhoneNumber());
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

    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int contactPosition = searchContact(oldContact);

        if(contactPosition <=0){
            System.out.println(oldContact.getName() + " is not in the Phone book");
            return false;
        }

        contact.set(contactPosition, newContact);
        System.out.println(oldContact.getName() + " was modified to " + newContact.getName() );
        return true;
    }

    public void removeContact(String name, String phone) {
        int positionName = searchContact(name);
        int positionPhone = searchContact(phone);

        if (positionName >= 0 || positionPhone >= 0) {
            removeContact(positionName);
            removeContact(positionPhone);
        }
    }

    public void removeContact(int position){
            contact.remove(position);
        }

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
//        String contactName = contact.getName();
        Optional<String> person = Optional.of(contact.getName());
        if(searchContact(contact) >=0){
            return person.get();
        }
        return Optional.empty().toString();
    }


}
