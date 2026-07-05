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
                System.out.println("Going to main menu...");
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
                case 2 -> {
                    System.out.println("----------------Find Member by Id----------------");
                    System.out.println("Enter member Id :");
                    long id = in.nextLong();
                    Member member = memberController.findMemberById(id);
                    if (member != null) {
                        System.out.println("Member found: " + member);
                    } else {
                        System.out.println("Member not found");
                    }
                }
                case 3 -> {
                    System.out.println("----------------Fetch all members----------------");
                    List<Member> members = memberController.fetchAllBooks();
                    if (members != null && !members.isEmpty()) {
                        members.forEach(System.out::println);
                    } else {
                        System.out.println("No members found");
                    }
                }
                case 4 -> {
                    System.out.println("----------------Update existing book----------------");
                    System.out.println("Enter id of the book to update :");
                    long memberId = in.nextLong();
                    Member updateMember = memberController.findMemberById(memberId);
                    if (updateMember == null) {
                        System.out.println("Member not found");
                        continue;
                    }
                    System.out.println("Member details:");
                    System.out.println(updateMember);
                    System.out.println("----------------Enter new member details----------------");
                    in.nextLine();
                    System.out.println("Enter name to update: ");
                    String name = in.nextLine();
                    System.out.println("Enter email to update: ");
                    String email = in.nextLine();
                    System.out.println("Enter Membership Type to update:");
                    Arrays.stream(MemberType.values()).forEach(System.out::println);
                    String memberType = in.nextLine();

                    updateMember.setName(name);
                    updateMember.setMemberType(MemberType.valueOf(memberType));
                    updateMember.setEmail(email);

                    updateMember = memberController.updateBook(updateMember);
                    System.out.println("Book updated successfully: " + updateMember);
                }
                case 5 -> {
                    System.out.println("----------------Delete member----------------");
                    System.out.println("Enter member id to delete:");
                    long id = in.nextLong();
                    try {
                        memberController.deleteMember(id);
                        System.out.println("Member deleted successfully");
                    } catch (Exception e) {
                        System.out.println("Failed to delete member: " + e.getMessage());
                    }
                }
            }

        }
    }
}
