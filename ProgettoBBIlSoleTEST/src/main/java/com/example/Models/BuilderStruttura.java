package com.example.Models;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public interface BuilderStruttura
{

    void buildCitta(TextField Citta);

    void buildIndirizzo(TextField Indirizzo);

    void buildCap(TextField Cap);

    void buildCapienza(TextField Capienza);

    void buildNumeroCamere(TextField NumeroCamere);

    void buildDistanzaAttr(TextField DistanzaAttr);

    void buildVicinanzaTra(TextField VicinanzaTra);

    void buildDispPark(RadioButton DispPark);

    Struttura getStruttura();
}
