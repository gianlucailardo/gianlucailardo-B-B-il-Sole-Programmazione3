package com.example.Models;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Proprietario extends Account {
    DataBase.DatabaseConnection connectP = new DataBase.DatabaseConnection();
    Connection connectProprietario = connectP.getConnection();

    private Proprietario()
    {
        String f = "SELECT * FROM user_account WHERE role = 'proprietario'";
        try {
            Statement statement = connectProprietario.createStatement();
            ResultSet queryusername= statement.executeQuery(f);
            while (queryusername.next())
            {
                firstnameP = queryusername.getString("firstname");
                lastnameP = queryusername.getString("lastname");
                usernameP = queryusername.getString("username");
                passwordP = queryusername.getString("password");
                emailP = queryusername.getString("email");
                roleP = queryusername.getString("role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
    //singleton
   private static Proprietario istance=null;
    public static Proprietario getistance(){
        if(istance==null)
        {
            istance = new Proprietario();
        }
        return istance;
    }

    public String getFirstname()
    {
        return firstnameP;
    }

    public String getLastname()
    {
        return lastnameP;
    }

    public String getUsername()
    {
        return usernameP;
    }

    public String getPassword()
    {
        return passwordP;
    }

    public String getEmail()
    {
        return emailP;
    }

    public String getRole()
    {
        return roleP;
    }

    private BuilderStruttura builderstruttura;

    public void setbuilderstruttura(BuilderStruttura builderstruttura)
    {
        this.builderstruttura = builderstruttura;
    }

    public Struttura getStruttura()
    {
        return this.builderstruttura.getStruttura();
    }

    public void makeStruttura(TextField Citta, TextField Indirizzo, TextField Cap, TextField Capienza, TextField NumeroCamere, TextField DistanzaAttr, TextField VicinanzaTra, RadioButton DispPark)
    {
        this.builderstruttura.buildCitta(Citta);
        this.builderstruttura.buildIndirizzo(Indirizzo);
        this.builderstruttura.buildCap(Cap);
        this.builderstruttura.buildCapienza(Capienza);
        this.builderstruttura.buildNumeroCamere(NumeroCamere);
        this.builderstruttura.buildDistanzaAttr(DistanzaAttr);
        this.builderstruttura.buildVicinanzaTra(VicinanzaTra);
        this.builderstruttura.buildDispPark(DispPark);
    }

    private String firstnameP;
    private String lastnameP;
    private String usernameP;
    private String passwordP;
    private String emailP;
    private String roleP;

}

