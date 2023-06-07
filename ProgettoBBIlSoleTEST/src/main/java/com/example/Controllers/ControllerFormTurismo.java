package com.example.Controllers;
import DataBase.DatabaseConnection;
import com.example.Models.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class ControllerFormTurismo {
    @FXML
    private TextField TextNome;
    @FXML
    private TextField TextCogn;
    @FXML
    private TextField TextDoc;
    @FXML
    private TextField TextGio;
    @FXML
    private TextField TextImp;
    @FXML
    private Label InvioRiuscito;
    @FXML
    private Label InvioNonRiuscito;

    public void Invio() throws IOException {
        if(TextNome.getText().isBlank()==false && TextCogn.getText().isBlank()==false && TextDoc.getText().isBlank()==false
                && TextGio.getText().isBlank()==false && TextImp.getText().isBlank()==false){
                InvioNonRiuscito.setText(" ");
                ValidateUfficioTurismo();
                InvioRiuscito.setText("Tasse inviate");
                TextNome.setText("");
                TextCogn.setText("");
                TextDoc.setText("");
                TextGio.setText("");
                TextImp.setText("");
            }else{
            InvioRiuscito.setText(" ");
            InvioNonRiuscito.setText("Controlla i campi");
        }
    }

    public void ValidateUfficioTurismo(){
        GetForm o= new GetForm();
        Form_turismo prova = (Form_turismo) ((GetForm) o).create_form_turismo(TextNome, TextCogn, TextDoc, TextGio, TextImp);
        Main m = new Main();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String nome= prova.GetNome();
        String cognome= prova.GetCogn();
        String documento= prova.GetDocumento();
        String insertFields="INSERT INTO dati_ufficioturismo(nome_cliente, cognome_cliente, documento_cliente) VALUES ('";
        String insertValues= nome+ "','" +cognome+ "','" +documento+ "')";
        String insertToTasse= insertFields+insertValues;
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToTasse);
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void BackHome(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Index Ragioniere.fxml");
    }

    public void solonumeriimp(KeyEvent event) {
        TextImp.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    TextImp.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }

    public void solonumerigiorni(KeyEvent event) {
        TextGio.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    TextGio.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }
}


