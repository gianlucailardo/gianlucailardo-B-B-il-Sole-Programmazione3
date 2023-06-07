package com.example.Models;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class Form_questura implements Forms{


    public Form_questura(TextField TextNome, TextField TextCogn, DatePicker Data, TextField TextDoc, TextField TextIndi, TextField TextCitt, TextField TextCod) {
        Nome=TextNome.getText();
        Cognome=TextCogn.getText();
        Data_n=Data.getValue();
        Documento=TextDoc.getText();
        Indirizzo=TextIndi.getText();
        City=TextCitt.getText();
        Codice_fisc=TextCod.getText();
    }
    private String Nome;
    private String Cognome;
    private LocalDate Data_n;
    private String Indirizzo;
    private String Documento;
    private String City;
    private String Codice_fisc;

    @Override
    public String GetNome(){
        return Nome;
    }

    @Override
    public String GetCogn(){
        return Cognome;
    }

    @Override
    public String GetDocumento(){
        return Documento;
    }

}
