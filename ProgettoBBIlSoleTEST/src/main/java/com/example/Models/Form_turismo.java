package com.example.Models;

import javafx.scene.control.TextField;

public class Form_turismo implements Forms{

    public Form_turismo(TextField TextNome, TextField TextCogn, TextField TextDoc, TextField TextImp, TextField TextGio) {
        Nome=TextNome.getText();
        Cognome=TextCogn.getText();
        Documento=TextDoc.getText();
        Importo=TextImp.getText();
        Numero_giorni=TextGio.getText();
    }

    private String Nome;
    private String Cognome;
    private String Documento;
    private String Importo;
    private String Numero_giorni;

    @Override
    public String GetNome() {
        return Nome;
    }

    @Override
    public String GetCogn() {
        return Cognome;
    }

    @Override
    public String GetDocumento() {
        return Documento;
    }

}
