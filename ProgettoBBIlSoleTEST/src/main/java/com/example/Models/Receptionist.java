package com.example.Models;

import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Receptionist extends Account
{
    public Receptionist(TextField firstnamer, TextField lastnamer, TextField usernamer, PasswordField passwordr, TextField emailr, RadioButton roler)
    {
        firstname=firstnamer.getText();
        lastname=lastnamer.getText();
        username=usernamer.getText();
        password=passwordr.getText();
        email=emailr.getText();
        role=roler.getText();
    }



    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getRole()
    {
        return role;
    }

    private final String firstname;
    private final String lastname;
    private final String username;
    private final String password;
    private final String email;
    private final String role;

}
