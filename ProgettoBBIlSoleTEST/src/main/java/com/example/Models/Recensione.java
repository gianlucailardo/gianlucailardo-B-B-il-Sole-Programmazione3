package com.example.Models;


import DataBase.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Recensione  {

    public Recensione(String Recensione, String Risposta, Integer idrece) {
        this.Recensione=Recensione;
        this.Risposta=Risposta;
        this.idrece=idrece;
    }

    private String Risposta;
    private String Recensione;
    private Integer idrece;

    public String getRecensione() {
        return Recensione;
    }

    public String getRisposta() {
        return Risposta;
    }

    public Integer getIdrece() {
        return idrece;
    }
}