package com.example.Controllers;

import DataBase.DatabaseConnection;
import com.example.Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrazioneController {
    public RegistrazioneController() {

    }

    @FXML
    private Label registrationMessagegetLabel;
    @FXML
    private Label correctregistrationMessagegetLabel;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Label confirmPasswordLabel;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameRegister;
    @FXML
    private TextField emailTextField;
    @FXML
    private RadioButton role1RadioButton;
    @FXML
    private RadioButton role2RadioButton;
    @FXML
    private Label emailLabel;
    @FXML
    private Label DuplicateError;

    public void userRegistrazione(ActionEvent event) throws IOException {

        if (firstnameTextField.getText().isBlank() == false && lastnameTextField.getText().isBlank() == false && usernameRegister.getText().isBlank() == false
                && setPasswordField.getText().isBlank() == false && confirmPasswordField.getText().isBlank() == false && emailTextField.getText().isBlank() == false
                && (role1RadioButton.isSelected() == true || role2RadioButton.isSelected() == true)) {
            registration();
        } else {
            correctregistrationMessagegetLabel.setText("");
            confirmPasswordLabel.setText("");
            emailLabel.setText("");
            registrationMessagegetLabel.setText("Controlla i campi");
        }
    }

    public void registration() throws IOException {
        Main m = new Main();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();


        if (role1RadioButton.isSelected() == true) {
            AbstractFactory fac = new ConcreteFactory();
            Account r = (Ragioniere) ((ConcreteFactory) fac).CreateAccount(firstnameTextField, lastnameTextField, usernameRegister, setPasswordField, emailTextField, role1RadioButton);
            String firstname = r.getFirstname();
            String lastname = r.getLastname();
            String username = r.getUsername();
            String password = r.getPassword();
            String email = r.getEmail();
            String role = r.getRole();
            String insertFields = "INSERT INTO user_account(firstname,lastname,username,password,email,role) VALUES ('";
            String insertValues = firstname + "','" + lastname + "','" + username + "','" + password + "','" + email + "','" + role + "')";
            String insertToRegister = insertFields + insertValues;

            try {
                String espressione = "^[0-9a-z]([-_.]?[0-9a-z])*@[0-9a-z]([-.]?[0-9a-z])*.[a-z]{2,4}$";
                if (emailTextField.getText().matches(espressione)) {
                    emailLabel.setText("");
                    if ((setPasswordField.getText().equals(confirmPasswordField.getText()))) {
                        Statement statement = connectDB.createStatement();
                        statement.executeUpdate(insertToRegister);
                        confirmPasswordLabel.setText(" ");
                        DuplicateError.setText("");
                        registrationMessagegetLabel.setText("");
                        correctregistrationMessagegetLabel.setText("Utente registrato!");
                    } else {
                        DuplicateError.setText("");
                        registrationMessagegetLabel.setText("");
                        correctregistrationMessagegetLabel.setText("");
                        confirmPasswordLabel.setText("Password non corrispondenti");
                    }
                } else {
                    emailLabel.setText("Email non valida");
                    registrationMessagegetLabel.setText("");
                }

            } catch (Exception e) {
                registrationMessagegetLabel.setText("");
                confirmPasswordLabel.setText("");
                registrationMessagegetLabel.setText("");
                DuplicateError.setText("Email o Username già in uso");
                e.printStackTrace();
                e.getCause();
            }

        } else {
            AbstractFactory fac = new ConcreteFactory();
            Account r = (Receptionist) ((ConcreteFactory) fac).CreateAccount(firstnameTextField, lastnameTextField, usernameRegister, setPasswordField, emailTextField, role2RadioButton);
            String firstname = r.getFirstname();
            String lastname = r.getLastname();
            String username = r.getUsername();
            String password = r.getPassword();
            String email = r.getEmail();
            String role = r.getRole();
            String insertFields = "INSERT INTO user_account(firstname,lastname,username,password,email,role) VALUES ('";
            String insertValues = firstname + "','" + lastname + "','" + username + "','" + password + "','" + email + "','" + role + "')";
            String insertToRegister = insertFields + insertValues;

            try {
                String espressione = "^[0-9a-z]([-_.]?[0-9a-z])*@[0-9a-z]([-.]?[0-9a-z])*.[a-z]{2,4}$";
                if (emailTextField.getText().matches(espressione)) {
                    emailLabel.setText("");
                    if ((setPasswordField.getText().equals(confirmPasswordField.getText()))) {
                        Statement statement = connectDB.createStatement();
                        statement.executeUpdate(insertToRegister);
                        confirmPasswordLabel.setText(" ");
                        registrationMessagegetLabel.setText("");
                        correctregistrationMessagegetLabel.setText("Utente registrato!");
                    } else {
                        DuplicateError.setText("");
                        registrationMessagegetLabel.setText("");
                        correctregistrationMessagegetLabel.setText("");
                        confirmPasswordLabel.setText("Password non corrispondenti");
                    }
                } else {
                    emailLabel.setText("Email non valida");
                    registrationMessagegetLabel.setText("");
                }

            } catch (Exception e) {
                registrationMessagegetLabel.setText("");
                confirmPasswordLabel.setText("");
                registrationMessagegetLabel.setText("");
                DuplicateError.setText("Email o Username già in uso");
                e.printStackTrace();
                e.getCause();
            }
        }
    }
        public void userLogOut(ActionEvent event) throws IOException {
            Main m = new Main();
            m.changeScene("Login.fxml");
        }
}




