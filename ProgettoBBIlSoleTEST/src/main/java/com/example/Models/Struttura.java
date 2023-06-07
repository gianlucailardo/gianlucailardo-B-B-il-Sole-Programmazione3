package com.example.Models;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Struttura implements PianoStruttura
{

    @Override
    public void setCitta(TextField Citta)
    {
        StruttCitta = Citta.getText();
    }

    @Override
    public void setIndirizzo(TextField Indirizzo)
    {
        StruttIndirizzo = Indirizzo.getText();
    }

    @Override
    public void setCAP(TextField Cap)
    {
        StruttCap = Cap.getText();
    }

    @Override
    public void setCapienza(TextField Capienza)
    {
        StruttCapienza = Integer.parseInt(Capienza.getText());
    }

    @Override
    public void setNumeroCamere(TextField NumeroCamere)
    {
        StruttNumCam = NumeroCamere.getText();
    }

    @Override
    public void setDistanzaAttr(TextField DistanzaAttr)
    {
        StruttDistAttr = DistanzaAttr.getText();
    }

    @Override
    public void setVicinanzaTra(TextField VicinanzaTra)
    {
        StruttVicTra = VicinanzaTra.getText();
    }

    @Override
    public void setDispPark(RadioButton DispPark)
    {
        if(DispPark.isSelected())
            StruttDispPark=1;
        else
            StruttDispPark=0;
    }

    public String getCitta()
    {
        return StruttCitta;
    }

    public String getIndirizzo()
    {
        return StruttIndirizzo;
    }

    public String getCap()
    {
        return StruttCap;
    }

    public int getCapienza()
    {
        return StruttCapienza;
    }

    public String getNumeroCamere()
    {
        return StruttNumCam;
    }

    public String getDistanzaAttr()
    {
        return StruttDistAttr;
    }

    public String getVicinanzaTra()
    {
        return StruttVicTra;
    }

    public int getDispPark()
    {
        return StruttDispPark;
    }

    private String StruttCitta;

    private String StruttIndirizzo;

    private String StruttCap;

    private int StruttCapienza;

    private String StruttNumCam;

    private String StruttDistAttr;

    private String StruttVicTra;

    private int StruttDispPark;

}
