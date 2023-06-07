package com.example.Models;

public class Cliente {
        public Cliente(String nome, String cognome, String codice_fiscale,String numero_documento) {
            this.nome = nome;
            this.cognome = cognome;
            this.codice_fiscale = codice_fiscale;
            this.numero_documento = numero_documento;
        }
        private String nome;
        private String cognome;
        private String codice_fiscale;
        private String numero_documento;

    public String getNome()
    {
        return nome;
    }

    public String getCognome()
    {
        return cognome;
    }

    public String getCodice_fiscale()
    {
        return codice_fiscale;
    }

    public String getNumero_documento()
    {
        return numero_documento;
    }
    }


