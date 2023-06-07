package com.example.Models;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class ConcreteFactory extends AbstractFactory
{



    public Account CreateAccount(TextField firstname, TextField lastname, TextField username, PasswordField password, TextField email, RadioButton role)
    {
        if(role.getText().equals("Ragioniere"))
            return new Ragioniere(firstname, lastname, username, password, email, role);
        else
            return new Receptionist(firstname, lastname, username, password, email, role);
    }
}
