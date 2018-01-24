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
//                    modifyContact();
                    break;
                case 4:
//                    removeContact();
                    break;
                case 5:
//                    searchContact();
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

//    private static void

    public static void addContact(){
        System.out.println("Add new contact: ");
//        phones.addContact(scanner.nextLine());
    }



}
