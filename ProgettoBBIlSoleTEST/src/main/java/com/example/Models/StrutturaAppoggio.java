package com.example.Models;

public class StrutturaAppoggio
{
    public StrutturaAppoggio(String Citta, String Indirizzo, String Cap, Integer Capienza, Integer idstruttura)

    {
        this.idstruttura=idstruttura;
        this.Citta = Citta;
        this.Indirizzo = Indirizzo;
        this.Cap = Cap;
        this.Capienza = Capienza;
        /*this.NumeroCamere = NumeroCamere;
        this.DistanzaAttr = DistanzaAttr;
        this.VicinanzaTra = VicinanzaTra;
        this.DispPark = DispPark;*/
    }
    private String Citta;
    private String Indirizzo;
    private String Cap;
    private Integer Capienza;
    private Integer idstruttura;

    public String getCitta()
    {
    return Citta;
    }

    public Integer getIdstruttura()  {
        return idstruttura;
}

    public String getIndirizzo()
    {
        return Indirizzo;
    }

    public String getCap()
    {
        return Cap;
    }

    public Integer getCapienza()
    {
        return Capienza;
    }

}

