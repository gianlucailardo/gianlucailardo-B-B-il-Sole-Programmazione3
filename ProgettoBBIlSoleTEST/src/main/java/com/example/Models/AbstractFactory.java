package com.example.Models;

import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public abstract class AbstractFactory
{
    abstract Account CreateAccount(TextField firstname, TextField lastname, TextField username, PasswordField password, TextField email, RadioButton role);
}
