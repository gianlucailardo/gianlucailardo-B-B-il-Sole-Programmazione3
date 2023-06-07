package com.example.Controllers;

import DataBase.DatabaseConnection;
import com.example.Models.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.DataInput;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControllerDatiContabili implements Initializable {
    @FXML
    private TextField TextCosti;
    @FXML
    private TextField TextRicavi;
    @FXML
    private TextField TextTotale;
    @FXML
    private Label InvioDati;
    @FXML
    private Label ErroreDati;
    @FXML
    private ChoiceBox<String> ChoiceM;
    private String[] mesi = {"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto",
            "Settembre", "Ottobre", "Novembre", "Dicembre"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ChoiceM.getItems().addAll(mesi);
    }
    public void InserisciCont(ActionEvent event) throws IOException {
        if (TextCosti.getText().isBlank() == false && TextRicavi.getText().isBlank() == false && ChoiceM.getValue() != null) {
            ErroreDati.setText("");
            Totale();
            ValidateDati();
            TextCosti.setText("");
            TextRicavi.setText("");
            ChoiceM.setValue(null);
        } else {
            InvioDati.setText("");
            ErroreDati.setText("Controlla i campi");
        }
    }

    public void Totale() {
        int sum;
        sum = Integer.parseInt(TextRicavi.getText()) - Integer.parseInt(TextCosti.getText());
        TextTotale.setText(String.valueOf(sum));
    }

    public void ValidateDati() {
        Dati_Contabili o = new Dati_Contabili(TextCosti, TextRicavi, ChoiceM, TextTotale);
        Main m = new Main();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
         {
            int Costi = o.GetCosti();
            int Ricavi = o.GetRicavi();
            String Mese = o.GetMese();
            int Totale = o.GetTotale();
            String q = "SELECT COUNT(mese) AS prova FROM dati_contabili WHERE mese='" + Mese + "'";
            try {
                Statement querymese = connectDB.createStatement();
                ResultSet querym = querymese.executeQuery(q);
                while (querym.next()) {
                    if (querym.getInt("prova") == 0) {
                        String insertFields = "INSERT INTO dati_contabili(costi, ricavi, mese, totale) VALUES ('";
                        String insertValues = Costi + "','" + Ricavi + "','" + Mese + "','" + Totale + "')";
                        String insertToContabile = insertFields + insertValues;
                        Statement statement = connectDB.createStatement();
                        statement.executeUpdate(insertToContabile);
                        InvioDati.setText("Dati Inviati!");
                        ErroreDati.setText("");
                    } else {
                        InvioDati.setText("");
                        TextTotale.setText("");
                        ErroreDati.setText("Mese già inserito!");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();

            }
        }

    }

    public void BackHome(ActionEvent event) throws IOException {
        LoginController o = new LoginController();
        Main m = new Main();
        m.changeScene("Index Ragioniere.fxml");
    }

    public void solonumeric(KeyEvent event) {
        TextCosti.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    TextCosti.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }

    public void solonumerir(KeyEvent event) {
        TextRicavi.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    TextRicavi.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }

}



