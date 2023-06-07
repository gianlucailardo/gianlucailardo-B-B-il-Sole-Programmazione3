package com.example.Models;

public class Prenotazione {
    public Prenotazione(String codice_fiscale, String check_in, String check_out,String citta_struttura,int numero_persone, String tipologia_camera) {
        this.codice_fiscale =codice_fiscale;
        this.check_in = check_in;
        this.check_out = check_out;
        this.citta_struttura = citta_struttura;
        this.numero_persone=numero_persone;
        this.tipologia_camera=tipologia_camera;
    }
    private String codice_fiscale;
    private String check_in;
    private String check_out;
    private String citta_struttura;
    private int numero_persone;
    private String tipologia_camera;

    public String getCodice_fiscale() {
        return codice_fiscale;
    }

    public String getCheck_in() {
        return check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public String getCitta_struttura() {
        return citta_struttura;
    }

    public int getNumero_persone() {
        return numero_persone;
    }

    public String getTipologia_camera() {
        return tipologia_camera;
    }
}

