package com.example.Controllers;
import DataBase.DatabaseConnection;
import com.example.Models.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerFormQuestura {
    @FXML
    private TextField TextNome;
    @FXML
    private TextField TextCogn;
    @FXML
    private DatePicker Data;
    @FXML
    private TextField TextDoc;
    @FXML
    private TextField TextIndi;
    @FXML
    private TextField TextCitt;
    @FXML
    private TextField TextCod;
    @FXML
    private Label InvioRiuscito;
    @FXML
    private Label InvioNonRiuscito;
    @FXML
    private Label MessageCod;

    public void Invio() throws IOException {
        if(TextNome.getText().isBlank()==false && TextCogn.getText().isBlank()==false && Data.getValue()!=null
                && TextDoc.getText().isBlank()==false && TextIndi.getText().isBlank()==false && TextCitt.getText().isBlank()==false
                && TextCod.getText().isBlank()==false){
            if (TextCod.getText().length()==16){
                MessageCod.setText("");
                InvioNonRiuscito.setText(" ");
                ValidateQuestura();
                InvioRiuscito.setText("Dati inviati");
                TextNome.setText("");
                TextCogn.setText("");
                Data.setValue(null);
                TextDoc.setText("");
                TextIndi.setText("");
                TextCitt.setText("");
                TextCod.setText("");
            }else {
                InvioNonRiuscito.setText(" ");
                InvioRiuscito.setText(" ");
                MessageCod.setText("Controlla il codice fiscale");
            }
        }else{
            MessageCod.setText(" ");
            InvioRiuscito.setText(" ");
            InvioNonRiuscito.setText("Controlla i campi");
        }
    }

    public void ValidateQuestura(){
        GetForm o= new GetForm();
        Form_questura prova = (Form_questura) ((GetForm) o).create_form_questura(TextNome, TextCogn, Data, TextDoc, TextIndi, TextCitt, TextCod);
        Main m = new Main();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String nome= prova.GetNome();
        String cognome= prova.GetCogn();
        String documento= prova.GetDocumento();
        String insertFields="INSERT INTO dati_questura(nome_cliente, cognome_cliente, documento_cliente) VALUES ('";
        String insertValues= nome+ "','" +cognome+ "','" +documento+ "')";
        String insertToAnagrafica= insertFields+insertValues;
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToAnagrafica);
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void BackHome(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Index Proprietario.fxml");
    }
}
