package com.example.Controllers;

import DataBase.DatabaseConnection;
import com.example.Models.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControllerInsersciStruttura {
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
    private RadioButton si;
    @FXML
    private RadioButton no;
    @FXML
    private Label wronglabel;
    @FXML
    private Label oklabel;


    @FXML
    private void conferma(ActionEvent event) throws IOException {
        if (citta.getText().isBlank() == false && indirizzo.getText().isBlank() == false && cap.getText().isBlank() == false
                && capienza.getText().isBlank() == false && numcamere.getText().isBlank() == false && distanzaattr.getText().isBlank() == false
                && vicinanzatrasp.getText().isBlank() == false
                && (si.isSelected() == true || no.isSelected() == true))
        {
            InsStrutt();
            wronglabel.setText(" ");
            oklabel.setText("Struttura inserita!");
        }
            else{
                wronglabel.setText("Controlla i campi");
                oklabel.setText(" ");
            }
    }

    private void InsStrutt() throws IOException {
        Main m = new Main();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        BuilderStruttura strutt = new OldBuilderStruttura();
        Proprietario prop = Proprietario.getistance();
        prop.setbuilderstruttura(strutt);
        prop.makeStruttura(citta, indirizzo, cap, capienza, numcamere, distanzaattr, vicinanzatrasp, si );
        Struttura PrimaStrutt = Proprietario.getistance().getStruttura();

        String cittaD= PrimaStrutt.getCitta();
        String indirizzoD=PrimaStrutt.getIndirizzo();
        String capD= PrimaStrutt.getCap();
        int capienzaD= PrimaStrutt.getCapienza();
        String numcamereD= PrimaStrutt.getNumeroCamere();
        String distanzaattrD = PrimaStrutt.getDistanzaAttr();
        String vicinanzatraspD = PrimaStrutt.getVicinanzaTra();
        int DispParkD = PrimaStrutt.getDispPark();
        String insertFields="INSERT INTO struttura(Citta,Indirizzo,Cap,Capienza,NumCamere,DistanzaStrutt,VicinanzaTra,Parcheggio,user_account_id_user) VALUES ('";
        String insertValues= cittaD+ "','" +indirizzoD+ "','" +capD+ "','" +capienzaD+ "','" +numcamereD+ "','" +distanzaattrD+ "','" +vicinanzatraspD+ "','" +DispParkD+ "','" + 1 + "')";
        String insertToStruttura= insertFields+insertValues;

        try{
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertToStruttura);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
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

}
