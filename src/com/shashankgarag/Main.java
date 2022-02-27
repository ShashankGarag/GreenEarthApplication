package com.shashankgarag;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.List;

public class Main {

    static ShopCurrency earthPoints = new ShopCurrency();
    static List<Object> logbookList = new ArrayList<>();
    static UserInfo user = new UserInfo();


    //The main LogBook Page
    public static void LogBook(){
        boolean yes_no = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your logbook.");
        System.out.println("Here are your travels: " + logbookList);
        System.out.println("Would you like to log a travel?");
        String decide = scanner.next();
        while (Objects.equals(yes_no, false)){
            if(Objects.equals(decide, "yes")){
                Logbook logbook = new Logbook();
                System.out.println("Where did you start?");
                logbook.origin = scanner.next();
                System.out.println("Where did you end?");
                logbook.destination = scanner.next();
                System.out.println("How did you travel?");
                logbook.transport = scanner.next();
                if (Objects.equals(logbook.transport, "bike") | Objects.equals(logbook.transport, "carpool") | Objects.equals(logbook.transport, "electric_car")){
                    earthPoints.EarthPoints += 1;
                }
                System.out.println("Logging your travel... ");
                logbookList.add("Traveled from " + logbook.origin + " to " + logbook.destination + " by " + logbook.transport);
                System.out.println("Logged!");
                System.out.println("Here are your travels: " + logbookList);
                System.out.println("Would you like to log another travel or exit?");
                String choose = scanner.next();
                if(Objects.equals(choose, "log_another_travel")){
                    yes_no = false;
                }
                else if (Objects.equals(choose, "exit")){
                    yes_no = true;
                    MainMenu();
                }

            }
        }
        if (Objects.equals(decide, "no")){
            MainMenu();
        }
    }

    // The main shop page
    public static void Shop(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the store, you can purchase cool items here, all for 10 earth points!");
        System.out.println("1. $5 Microsoft Gift Card");
        System.out.println("2. $5 Apple Gift Card");
        System.out.println("3. $5 Target Gift Card");
        System.out.println("4. Exit");
        System.out.println("Which item would you like to purchase?");
        int choice = scanner.nextInt();
        if (earthPoints.EarthPoints >= 10 && Objects.equals(choice, 1)){
            System.out.println("You have purchased a $5 Microsoft Gift Card!");
            earthPoints.EarthPoints -= 10;
            System.out.println("Would you like to buy something else or exit?");
            String decision = scanner.next();
            if(Objects.equals(decision, "buy_something_else")){
                Shop();
            }
            else if (Objects.equals(decision, "exit")){
                MainMenu();
            }


        }
        else if (earthPoints.EarthPoints >= 10 && Objects.equals(choice, 2)){
            System.out.println("You have purchased a $5 Apple Gift Card!");
            earthPoints.EarthPoints -= 10;
            System.out.println("Would you like to buy something else or exit?");
            String decision = scanner.next();
            if(Objects.equals(decision, "buy_something_else")){
                Shop();
            }
            else if (Objects.equals(decision, "exit")){
                MainMenu();
            }
        }
        else if (earthPoints.EarthPoints >= 10 && Objects.equals(choice, 3)){
            System.out.println("You have purchased a $5 Target Gift Card!");
            earthPoints.EarthPoints -= 10;
            System.out.println("Would you like to buy something else or exit?");
            String decision = scanner.next();
            if(Objects.equals(decision, "buy_something_else")){
                Shop();
            }
            else if (Objects.equals(decision, "exit")){
                MainMenu();
            }
        }
        else if (earthPoints.EarthPoints >= 10 && Objects.equals(choice, 4)){
            MainMenu();
        }
        else if (earthPoints.EarthPoints < 10){
            System.out.println("Sorry, you do not have enough earth points.");
            System.out.println("You need " + (10 - earthPoints.EarthPoints) + " more earth points.");
            MainMenu();
        }
    }

    // Logout method
    public static void LogOut(){
        System.out.println("Thank you for using Green Earth!");
    }

    //The main menu page
    public static void MainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Green Earth!");
        System.out.println("Log your daily travels.");
        System.out.println("All ways of transportation that reduce carbon emissions gain you Earth points.");
        System.out.println("To log trips type: 1");
        System.out.println("To spend Earth points type: 2");
        System.out.println("To logout type: 3");
        System.out.println("To view your profile info type: 4");

        String choice = scanner.next();
        if(Objects.equals(choice, "1")){
            LogBook();
        }
        else if(Objects.equals(choice, "2")){
            Shop();
        }
        else if(Objects.equals(choice, "3")){
            LogOut();
        }
        else if(Objects.equals(choice, "4")){
            System.out.println("Name: " + user.name);
            System.out.println("Age: " + user.age);
            System.out.println("Email: " + user.email);
            System.out.println("Type 1 to return to main menu");
            int one = scanner.nextInt();
            if(Objects.equals(one, 1)){
                MainMenu();
            }
        }
        else{
            System.out.println("Please enter a valid option");
        }

    }

    //The login process and introduction page
    public static void main(String[] args) {

        boolean infoValid = false;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Green Earth!");
        System.out.println("Would you like to login or sign up? (Please replace all spaces with underscores)");
        String input = scanner.next();


        if(Objects.equals(input, "sign_up")) {
            System.out.println("Please enter your name: ");
            user.name = scanner.next();
            System.out.println("Please enter your age: ");
            user.age = scanner.nextInt();
            if (user.age < 13) {
                System.out.println("Sorry, you must be 13 years or older to register.");
            } else {
                System.out.println("What is your email: ");
                user.email = scanner.next();
                System.out.println("Create a password: ");
                user.password = scanner.next();
                System.out.println("Thank you for registering with Green Earth!" +
                        " Would you like to login?");
                String loginYes = scanner.next();
                if (Objects.equals(loginYes, "yes")) {
                    while (!infoValid) {
                        System.out.println("Please enter your email: ");
                        String emailVerify = scanner.next();
                        System.out.println("Please enter your password: ");
                        String passwordVerify = scanner.next();
                        if (!Objects.equals(emailVerify, user.email) | !Objects.equals(passwordVerify, user.password)) {
                            System.out.println("Please enter the correct email and password.");
                        } else {
                            infoValid = true;
                            MainMenu();
                        }
                    }

                }
                else if(Objects.equals(loginYes, "no")){
                    System.out.println("Thank you for registering with Green Earth!");
                }

            }
        }
        else if(Objects.equals(input, "login")){
            while (!infoValid){
                System.out.println("Please enter your email: ");
                String emailVerify = scanner.next();
                System.out.println("Please enter your password: ");
                String passwordVerify = scanner.next();
                if (!Objects.equals(emailVerify, user.email) | !Objects.equals(passwordVerify, user.password)){
                    System.out.println("Please enter the correct email and password.");
                }
                else{
                    infoValid = true;

                }
            }

        }

    }
}
