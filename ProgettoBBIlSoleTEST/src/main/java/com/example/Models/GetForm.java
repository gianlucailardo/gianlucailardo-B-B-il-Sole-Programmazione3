package com.example.Models;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class GetForm {
    public Forms create_form_questura(TextField Nome , TextField Cognome, DatePicker Data,
                             TextField Documento, TextField Indirizzo, TextField Citt, TextField Cod){
        return new Form_questura(Nome, Cognome, Data, Documento, Indirizzo, Citt, Cod);
    }
    public Forms create_form_turismo(TextField Nome , TextField Cognome,TextField Documento, TextField Importo,
                                     TextField Numero_giorni){
        return new Form_turismo(Nome,Cognome,Documento,Importo,Numero_giorni);
    }
}
