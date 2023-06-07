package com.example.Controllers;

import DataBase.DatabaseConnection;
import com.example.Models.Recensione;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.sql.*;

public class ControllerModificaStruttura {
    @FXML
    private TextField citta;
    @FXML
    private TextField indirizzo;
    @FXML
    private TextField cap;
    @FXML
    private TextField capienza;
    @FXML
    private TextField numcamere;
    @FXML
    private TextField distanzaattr;
    @FXML
    private TextField vicinanzatrasp;
    @FXML
    private TextField Id;
    @FXML
    private RadioButton si;
    @FXML
    private RadioButton no;
    @FXML
    private Label wronglabel;
    @FXML
    private Label oklabel;

    public void modify(int idp) {
        int id = idp;
        if (id == 0){
            wronglabel.setText("Inserisci un ID valido!");
            citta.setText("");
            citta.setText("");
            indirizzo.setText("");
            cap.setText("");
            capienza.setText("");
            numcamere.setText("");
            distanzaattr.setText("");
            vicinanzatrasp.setText("");
            no.setSelected(false);
            si.setSelected(false);
        }
        else {
            wronglabel.setText("");
            DatabaseConnection connectP = new DatabaseConnection();
            Connection connect = connectP.getConnection();
            String q = "SELECT * FROM struttura WHERE idstruttura = '" + id + "'";
            try {
                Statement querystruttura = connect.createStatement();
                ResultSet querys = querystruttura.executeQuery(q);
                if (!querys.isBeforeFirst()) {
                    wronglabel.setText("Inserisci un ID valido!");
                    citta.setText("");
                    citta.setText("");
                    indirizzo.setText("");
                    cap.setText("");
                    capienza.setText("");
                    numcamere.setText("");
                    distanzaattr.setText("");
                    vicinanzatrasp.setText("");
                    no.setSelected(false);
                    si.setSelected(false);
                } else {
                    while (querys.next()) {
                        wronglabel.setText("");
                        citta.setText(querys.getString("Citta"));
                        indirizzo.setText(querys.getString("Indirizzo"));
                        cap.setText(querys.getString("Cap"));
                        capienza.setText(String.valueOf(querys.getInt("Capienza")));
                        numcamere.setText(querys.getString("NumCamere"));
                        distanzaattr.setText(querys.getString("DistanzaStrutt"));
                        vicinanzatrasp.setText(querys.getString("VicinanzaTra"));
                        if (String.valueOf((querys.getInt("Parcheggio"))).equals("0"))
                            no.setSelected(true);
                        else
                            si.setSelected(true);
                    }
                }
            }
                catch(SQLException throwables){
                    throwables.printStackTrace();
                }
        }
    }

    public void update() throws IOException {
        String cittaD= citta.getText();
        String indirizzoD= indirizzo.getText();
        String capD=cap.getText();
        Integer capienzaD= Integer.valueOf(capienza.getText());
        String numcamereD=numcamere.getText();
        String distanzaattrD=distanzaattr.getText();
        String vicinanzatraspD=vicinanzatrasp.getText();
        Integer DispParkD;
        if (si.isSelected()) {
             DispParkD = 1;
        }
        else {
             DispParkD = 0;
        }
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String updateToStruttura= "UPDATE struttura SET Citta='"+cittaD+"', Indirizzo='"+indirizzoD+"', Cap='"+capD+"', Capienza='"+capienzaD+"', NumCamere='"+numcamereD+"', DistanzaStrutt='"+distanzaattrD+"', VicinanzaTra='"+vicinanzatraspD+"',Parcheggio='"+DispParkD+"' where idstruttura='"+Id.getText()+"'";
        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(updateToStruttura);
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void insertId(ActionEvent event) throws IOException
    {
        if (Id.getText().isEmpty()) {
            wronglabel.setText("Inserisci un ID!");
            wronglabel.setText("Inserisci un ID valido!");
            citta.setText("");
            citta.setText("");
            indirizzo.setText("");
            cap.setText("");
            capienza.setText("");
            numcamere.setText("");
            distanzaattr.setText("");
            vicinanzatrasp.setText("");
            no.setSelected(false);
            si.setSelected(false);
        }
        else
        modify(Integer.parseInt(Id.getText()));
    }


    public void BackHome(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Visualizza Strutture.fxml");
    }

    public void solonumericap(KeyEvent event) {
        cap.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    cap.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }

    public void solonumericapienza(KeyEvent event) {
        capienza.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    capienza.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }

    public void solonumeriid(KeyEvent event) {
        Id.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    Id.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }
}
