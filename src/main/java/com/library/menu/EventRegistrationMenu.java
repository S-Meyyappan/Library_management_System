package com.library.menu;

import com.library.controller.AuthorController;
import com.library.controller.EventRegistrationController;
import com.library.model.Author;
import com.library.model.EventRegistration;
import com.library.model.Member;

import java.util.List;
import java.util.Scanner;

public class EventRegistrationMenu {

    EventRegistrationController eventRegistrationController = new EventRegistrationController();

    public void displayMenu() {
        Scanner in = new Scanner(System.in);

        System.out.println("-------------------Event Registration Menu-------------------");
        while (true){
            System.out.println("1. Find EventRegistration by Id");
            System.out.println("2. Find No Shows for the Event ");
            System.out.println("0. Go Back");
            System.out.println("----------------------------------------------");

            System.out.println("Enter your choice: ");
            int choice = in.nextInt();

            if(choice == 0){
                System.out.println("Going to main menu...");
                return;
            }

            switch (choice){
                case 1 -> {
                    System.out.println("----------------Find EventRegistration by Id----------------");
                    System.out.println("Enter EventRegistration Id: ");
                    long eventId = in.nextLong();
                    EventRegistration eventRegistration = eventRegistrationController.findEventById(eventId);
                    if(eventRegistration == null){
                        System.out.println("Event not found");
                    } else {
                        System.out.println(eventRegistration);
                    }
                    System.out.println("----------------------------------------------");
                }
                case 2 -> {
                    System.out.println("----------------Find No Show Members----------------");
                    in.nextLine();
                    System.out.println("Enter Event Id: ");
                    long eventId = in.nextLong();
                    List<Member> members = eventRegistrationController.findNoShowMembers(eventId);
                    if(members.isEmpty()){
                        System.out.println("No members found. All attended the event");
                    } else {
                        members.forEach(System.out::println);
                    }
                    System.out.println("----------------------------------------------");
                }
            }

        }
    }
}
