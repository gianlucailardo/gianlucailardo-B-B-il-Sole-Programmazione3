package com.example.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import com.example.Models.*;
import DataBase.DatabaseConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController  {
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;


    public void userLogIn(ActionEvent event){

        if(username.getText().isBlank()==false && password.getText().isBlank()==false){
            validateLogin();
        }else{
            wrongLogIn.setText("Inserisci il tuo username e la tua password");
        }

    }
    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + username.getText() + "' AND password = '" + password.getText() + "'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult= statement.executeQuery(verifyLogin);
            while (queryResult.next()) {
                if (queryResult.getInt(1)==1)
                {
                    String role1 = "SELECT role FROM user_account WHERE username = '" + username.getText() + "' AND password = '" + password.getText() + "'";
                    Statement statement1 = connectDB.createStatement();
                    ResultSet queryResult1= statement1.executeQuery(role1);
                    while (queryResult1.next())
                    {
                        if (queryResult1.getString("role").equals("proprietario"))
                            ScenaP();
                        else if(queryResult1.getString("role").equals("Ragioniere"))
                            ScenaRa();
                        else
                        ScenaRe();
                    }
                }else{
                    wrongLogIn.setText("Utente non riconosciuto, riprovare");
                }

            }
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
    public void userRegister(ActionEvent event) throws IOException
    {
        Main m = new Main();
        m.changeScene("Registrazione.fxml");
    }

    public void ScenaP() throws IOException
    {
        Main n = new Main();
        n.changeScene("index Proprietario.fxml");
    }

    public void ScenaRa() throws IOException
    {

        Main n = new Main();
        n.changeScene("index Ragioniere.fxml");
    }

    public void ScenaRe() throws IOException {
        Main n = new Main();
        n.changeScene("index Receptionist.fxml");
    }

}