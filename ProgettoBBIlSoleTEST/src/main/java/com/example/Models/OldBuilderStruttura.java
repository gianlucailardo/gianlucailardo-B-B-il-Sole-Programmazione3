package com.example.Models;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.util.stream.IntStream;

public class OldBuilderStruttura implements BuilderStruttura
{
    private Struttura struttura;

    public OldBuilderStruttura()
    {
        this.struttura = new Struttura();
    }

    @Override
    public void buildCitta(TextField Citta)
    {
        struttura.setCitta(Citta);
    }

    @Override
    public void buildIndirizzo(TextField Indirizzo)
    {
        struttura.setIndirizzo(Indirizzo);
    }

    @Override
    public void buildCap(TextField Cap)
    {
        struttura.setCAP(Cap);
    }

    @Override
    public void buildCapienza(TextField Capienza) {
        struttura.setCapienza(Capienza);
    }

    @Override
    public void buildNumeroCamere(TextField NumeroCamere) {
        struttura.setNumeroCamere(NumeroCamere);
    }

    @Override
    public void buildDistanzaAttr(TextField DistanzaAttr) {
        struttura.setDistanzaAttr(DistanzaAttr);
    }

    @Override
    public void buildVicinanzaTra(TextField VicinanzaTra) {
        struttura.setVicinanzaTra(VicinanzaTra);
    }

    @Override
    public void buildDispPark(RadioButton DispPark) {
        struttura.setDispPark(DispPark);
    }

    @Override
    public Struttura getStruttura()
    {
        return this.struttura;
    }
}
