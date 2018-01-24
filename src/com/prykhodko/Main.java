/////////////////////////////////////////////////////////////
// Main class is used to test the work of the MobilePhone  //
// class.                                                  //
/////////////////////////////////////////////////////////////



package com.prykhodko;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone phones = new MobilePhone();


    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit){
            System.out.println("Enter the number corresponding to your choice: ");
            choice =scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    phones.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }

    }

    public static void printInstructions(){
        System.out.println("\n Make a choice by pressing the button with corresponding #");
        System.out.println("\t 0 - Print all available options;");
        System.out.println("\t 1 - Print the list of all the contacts");
        System.out.println("\t 2 - Add new contact");
        System.out.println("\t 3 - Modify the contact in the list ");
        System.out.println("\t 4 - Remove the contact from the list");
        System.out.println("\t 5 - Query if a contact exists");
        System.out.println("\t 6 - To quit the Contact book");
        System.out.println("Choose the number to start: ");
    }


    public static void addContact(){
        System.out.println("Add new contact's name: ");
        String contactName = scanner.nextLine();
        System.out.println("Add new phone number: ");
        String contactPhone = scanner.nextLine();
        Contacts newContact = Contacts.newContact(contactName, contactPhone);
        phones.addContact(newContact);


    }

    private static void updateContact(){
        System.out.println("Enter the name of the contact that should be updated: ");
        String existingContactName = scanner.nextLine();
        Contacts existingContact = phones.queryContact(existingContactName);
        if(existingContact != null){
            System.out.println("Enter new name for the contact");
            String newContactName = scanner.nextLine();
            System.out.println("Enter new phone number for the contact");
            String newContactPhone = scanner.nextLine();
            Contacts newContact = Contacts.newContact(newContactName, newContactPhone);
            phones.updateContact(existingContact, newContact);
        }else {
            System.out.println("There is now contact with the name " + existingContactName + " in the Phone Book.");

        }
    }

    private static void removeContact() {
        System.out.println("Enter the name of the contact that should be removed: ");
        String existingContactName = scanner.nextLine();
        Contacts existingContact = phones.queryContact(existingContactName);
        if(existingContact == null){
            System.out.println("There is now contact with the name " + existingContactName + " in the Phone Book.");
        }
        phones.removeContact(existingContact);
    }

    private static void queryContact(){
        System.out.println("Enter the name of the existing contact");
        String existingContactName = scanner.nextLine();
        Contacts existingContact = phones.queryContact(existingContactName);
        if(existingContact == null){
            System.out.println("There is now contact with the name " + existingContactName + " in the Phone Book.");
        }else{
            System.out.println("The name is: " + existingContact.getName() + " Phone number is: " + existingContact.getPhoneNumber());
        }
    }
}
