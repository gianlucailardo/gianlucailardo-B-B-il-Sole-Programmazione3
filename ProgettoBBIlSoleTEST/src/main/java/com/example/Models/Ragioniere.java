package com.example.Models;

import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Ragioniere extends Account
{
    public Ragioniere(TextField firstname, TextField lastname, TextField username, PasswordField password, TextField email, RadioButton role)
    {
        this.firstname=firstname.getText();
        this.lastname=lastname.getText();
        this.username=username.getText();
        this.password=password.getText();
        this.email=email.getText();
        this.role=role.getText();
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

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String role;
}
