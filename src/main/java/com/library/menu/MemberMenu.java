package com.library.menu;

import com.library.controller.MemberController;
import com.library.enums.MemberType;
import com.library.model.Member;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MemberMenu implements Menu{
    @Override
    public void displayMenu() {
        Scanner in = new Scanner(System.in);

        MemberController memberController = new MemberController();

        System.out.println("-------------------Member Menu-------------------");
        while (true){
            System.out.println("1. Add a new Member");
            System.out.println("2. Find member by Id");
            System.out.println("3. Fetch all members");
            System.out.println("4. Update a member");
            System.out.println("5. Delete a member");
            System.out.println("0. Go Back");
            System.out.println("----------------------------------------------");

            System.out.println("Enter your choice: ");
            int choice = in.nextInt();

            if(choice == 0){
                System.out.println("Exiting...");
                return;
            }

            switch (choice){
                case 1 -> {
                    System.out.println("----------------Enter member details----------------");
                    in.nextLine();
                    System.out.println("Enter name: ");
                    String name = in.nextLine();
                    System.out.println("Enter email: ");
                    String email = in.nextLine();
                    System.out.println("Enter Membership Type:");
                    Arrays.stream(MemberType.values()).forEach(System.out::println);
                    String memberType = in.nextLine();

                    Member member = new Member();
                    member.setName(name);
                    member.setEmail(email);
                    member.setMemberType(MemberType.valueOf(memberType));

                    try {
                        member = memberController.addMember(member);
                        System.out.println("Member added successfully: " + member);
                    } catch (Exception e) {
                        System.out.println("Failed to add Member: " + e.getMessage());
                    }
                }
            }

        }
    }
}
