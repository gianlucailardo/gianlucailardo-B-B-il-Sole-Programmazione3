package com.example.Models;
import DataBase.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class Account
{
    public abstract String getFirstname();
    public abstract String getLastname();
    public abstract String getUsername();
    public abstract String getPassword();
    public abstract String getEmail();
    public abstract String getRole();

}

