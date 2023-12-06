package Admin_Task_Management_System;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputHandler {
	
	private static List<User> UserList = new ArrayList<>();
    public static User addIndividualUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter User Name: ");
        String userName = sc.next();
        System.out.println("Enter User Address: ");
        String userAddress = sc.next();
        System.out.println("Enter User EmailID: ");
        String userEmailID = sc.next();
        System.out.println("Enter User Password: ");
        String userPassword = sc.next();
        System.out.println("Enter User PhoneNumber: ");
        long userPhoneNumber = sc.nextLong();

        return new User(userName, userAddress, userEmailID, userPassword, userPhoneNumber, "", "");
    }

    public static List<User> addTeamUsers(int teamSize) {
        List<User> teamUsers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= teamSize; i++) {
            System.out.println("Enter User Name for team member " + i + ": ");
            String userName = sc.next();
            System.out.println("Enter User Address for team member " + i + ": ");
            String userAddress = sc.next();
            System.out.println("Enter User EmailID for team member " + i + ": ");
            String userEmailID = sc.next();
            System.out.println("Enter User Password for team member " + i + ": ");
            String userPassword = sc.next();
            System.out.println("Enter User PhoneNumber for team member " + i + ": ");
            long userPhoneNumber = sc.nextLong();

            
            teamUsers.add(new User(userName, userAddress, userEmailID, userPassword, userPhoneNumber, "", ""));
            System.out.println("                                                                                                                                       ");
        }

        return teamUsers;
    }

    public static List<User> addOrganizationUsers(int organizationSize) {
        List<User> organizationUsers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= organizationSize; i++) {
            System.out.println("Enter User Name for organization member " + i + ": ");
            String userName = sc.next();
            System.out.println("Enter User Address for organization member " + i + ": ");
            String userAddress = sc.next();
            System.out.println("Enter User EmailID for organization member " + i + ": ");
            String userEmailID = sc.next();
            System.out.println("Enter User Password for organization member " + i + ": ");
            String userPassword = sc.next();
            System.out.println("Enter User PhoneNumber for organization member " + i + ": ");
            long userPhoneNumber = sc.nextLong();


            organizationUsers.add(new User(userName, userAddress, userEmailID, userPassword, userPhoneNumber, "", ""));
            System.out.println("                                                                                                                                       ");
        }

        return organizationUsers;
    }

	public static void handleUserRegistration(TaskService taskService, Scanner sc) {
		 String userRole;
	        String choice;

	        do {
	            System.out.println("Are you joining as an individual (I), a team (T), or an organization (O)?");
	            userRole = sc.next().toUpperCase();

	            switch (userRole) {
	                case "I":
	                System.out.println("Welcome, INDIVIDUAL ! Explore your tasks and boost your productivity!");
	    			System.out.println("                                                                                                                                       ");
	    			User individualUser = UserInputHandler.addIndividualUser();
	    			UserList.add(individualUser);
	    			System.out.println("Individual user information added successfully.");
	    			System.out.println("                                                                                                                                       ");
	    			break;
	                case "T":
	                	System.out.println("Welcome, Team Member!  Collaborate effectively and achieve great results!");
	        			System.out.println("                                                                                                                                       ");
	        			System.out.println("Enter the number of team members: ");
	        			int teamSize = sc.nextInt();
	        			List<User> teamUsers = UserInputHandler.addTeamUsers(teamSize);
	        			UserList.addAll(teamUsers);
	        			System.out.println("Team users information added successfully.");
	        			System.out.println("                                                                                                                                       ");
	        			break;
	                	
	                case "O":
	                	System.out.println("Welcome, Organization Representative! Streamline your workflow and conquer your goals!");
	        			System.out.println("                                                                                                                                       ");
	        			System.out.println("Enter the number of organization members: ");
	        			int organizationSize = sc.nextInt();
	        			List<User> organizationUsers = UserInputHandler.addOrganizationUsers(organizationSize);
	        			UserList.addAll(organizationUsers);
	        			System.out.println("Organization users information added successfully.");
	        			System.out.println("                                                                                                                                       ");
	        			break;
	                default:
	                    System.out.println("Invalid role! Please enter the correct role.");
	                    System.out.println();
	            }

	            System.out.println("Registration successful!");
	            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");                                                                                             
	            System.out.println("Do you want to continue registration? (Y-Yes / N-No)");
	            choice = sc.next();
	            System.out.println("====================================================================================================================================");

	        } while(choice.equals("YES")||choice.equals("yes"));
	    }
		
	}

 

