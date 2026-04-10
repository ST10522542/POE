/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginandregister5;
import java.util.Scanner;
/**
 *
 * @author ptama
 */
public class Loginandregister5 {

    public static void main(String[] args) {
        
      
    
        Scanner input = new Scanner(System.in);
        String username = "";
        String password = "";
        String cellphone = "";

        System.out.println("\n--Register your account---");
        System.out.print("Enter username :");
        username = input.nextLine();
        // conditions for username
        while (!(username.length() <= 5 && username.contains("_"))) {
            System.out.println("Username is not correctly formatted, please ensure username contains an underscore and is no more than 5 characters in length.");
            System.out.print("Enter username :");
            username = input.nextLine();
        }
        System.out.println("Username successfully captured");

        System.out.print("Enter Password: ");
        password = input.nextLine();
        // Check length, a Capital letter, a number and a special character
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$";
        while (!password.matches(passwordRegex)) {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character");
            System.out.print("Enter Password: ");
            password = input.nextLine();
        }
        System.out.println("Password successfully captured");

        System.out.print("Enter Cellphone number : ");
        cellphone = input.nextLine();
                                                                                             
       
        while (!(cellphone.startsWith("+27") && cellphone.length() == 12 && cellphone.matches("\\+27\\d{9}"))) {
            System.out.println("Cellphone number incorrectly formatted or does not contain international code");
            System.out.print("Enter Cellphone number : ");
            cellphone = input.nextLine();
        }
        System.out.println("Cell number successfully captured");
        System.out.println("This user is registered successfully : " + username);

                
        
        System.out.println("\n--Login to the chat app--");
        String loguser, logpass, logcell;
        int attempts = 0;
        boolean loggedIn = false;
        while (attempts < 3 && !loggedIn) {
            System.out.print("Enter Registered username : ");
            loguser = input.nextLine();
            System.out.print("Enter Registered password : ");
            logpass = input.nextLine();
            System.out.print("Enter Registered cellphone number : ");
            logcell = input.nextLine();

            if (loguser.equals(username) && logpass.equals(password) && logcell.equals(cellphone)) {
                System.out.println("Login successful!");
                loggedIn = true;
            } else {
                attempts++;
                System.out.println("Invalid credentials. Attempts remaining: " + (3 - attempts));
            }
        }
        input.close();
    }
}

    

