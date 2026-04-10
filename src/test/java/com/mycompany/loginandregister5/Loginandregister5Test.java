/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.loginandregister5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ptama
 */
public class Loginandregister5Test {
    
    public Loginandregister5Test() {
    }

    @org.junit.jupiter.api.Test
    public void testMain() {
    }
    
    


public class RegistrationAndLoginTest {

    @Test
    void testValidRegistrationAndLogin() {
        String username = "user_"; // valid: <=5 chars and contains "_"
        String password = "Passw0rd!"; // valid: >=8 chars, has capital, number, special char
        String cell = "+27712345678"; // valid: +27 and 12 digits

        boolean validUsername = username.length() <= 5 && username.contains("_");
        boolean validPassword = password.length() >= 8 
                                && password.matches(".*[A-Z].*") 
                                && password.matches(".*\\d.*") 
                                && password.matches(".*[!@$%^&*].*");
        boolean validCell = cell.startsWith("+27") 
                            && cell.length() == 12 
                            && cell.matches("\\+27\\d{9}");

        assertTrue(validUsername && validPassword && validCell, "Account should register successfully");

        // Login with same details
        String loginUsername = "user_";
        String loginPassword = "Passw0rd!";
        String loginCell = "+27712345678";

        assertTrue(loginUsername.equals(username) 
                   && loginPassword.equals(password) 
                   && loginCell.equals(cell), "Login should succeed");
    }

    @Test
    void testInvalidRegistration() {
        String username = "user"; // invalid: no underscore
        String password = "abc"; // invalid: too short
        String cell = "0721234567"; // invalid: missing +27

        boolean validUsername = username.length() <= 5 && username.contains("_");
        boolean validPassword = password.length() >= 8 
                                && password.matches(".*[A-Z].*") 
                                && password.matches(".*\\d.*") 
                                && password.matches(".*[!@$%^&*].*");
        boolean validCell = cell.startsWith("+27") 
                            && cell.length() == 12 
                            && cell.matches("\\+27\\d{9}");

        assertFalse(validUsername && validPassword && validCell, "Account should fail registration");
    }

    @Test
    void testLoginFailsWithWrongDetails() {
        String username = "user_";
        String password = "Passw0rd!";
        String cell = "+27712345678";

        boolean validUsername = username.length() <= 5 && username.contains("_");
        boolean validPassword = password.length() >= 8 
                                && password.matches(".*[A-Z].*") 
                                && password.matches(".*\\d.*") 
                                && password.matches(".*[!@$%^&*].*");
        boolean validCell = cell.startsWith("+27") 
                            && cell.length() == 12 
                            && cell.matches("\\+27\\d{9}");

        assertTrue(validUsername && validPassword && validCell, "Account should register successfully");

        // Wrong login details
        String loginUsername = "wrong_";
        String loginPassword = "WrongPass1!";
        String loginCell = "+27799999999";

        assertFalse(loginUsername.equals(username) 
                    && loginPassword.equals(password) 
                    && loginCell.equals(cell), "Login should fail");
    }
}
}
