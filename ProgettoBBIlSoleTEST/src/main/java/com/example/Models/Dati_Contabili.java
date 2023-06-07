package com.example.Models;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Dati_Contabili {
    public Dati_Contabili(TextField TextCosti, TextField TextRicavi, ChoiceBox ChoiceMese, TextField TextTotale) {
    Costi= Integer.parseInt(TextCosti.getText());
    Ricavi= Integer.parseInt(TextRicavi.getText());
    Mese= String.valueOf(ChoiceMese.getValue());
    Totale= Integer.parseInt(TextTotale.getText());
    }

    public int GetCosti(){
        return Costi;
    }
    public int GetRicavi(){
        return Ricavi;
    }
    public String GetMese(){
        return Mese;
    }
    public int GetTotale(){
        return Totale;
    }
    private int Costi;
    private int Ricavi;
    private String Mese;
    private int Totale;
}
