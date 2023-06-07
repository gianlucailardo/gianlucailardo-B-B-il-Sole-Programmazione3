package com.example.Controllers;

import DataBase.DatabaseConnection;
import com.example.Models.Recensione;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerRisposta {
    @FXML
    private TextArea Risp;
    @FXML
    private TextArea Rec;
    @FXML
    private TextField Id;
    @FXML
    private Label wronglabel;
    @FXML
    private Label oklabel;

    public ControllerRisposta() throws IOException {
    }

    public void update()  {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String RispD = Risp.getText();
        String q = "UPDATE recensione SET risposta='" + RispD + "'where id_recensione='" + Id.getText() + "'";
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(q);
            oklabel.setText("Risposta inviata");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void search(int idp) {
        int id = idp;
        if (id == 0) {
            wronglabel.setText("Inserisci un ID valido!");
            Risp.setText("");
            Rec.setText("");
            oklabel.setText("");
        } else {
            DatabaseConnection connectP = new DatabaseConnection();
            Connection connect = connectP.getConnection();
            String q = "SELECT * FROM recensione WHERE id_recensione = '" + id + "'";
            try {
                Statement querystruttura = connect.createStatement();
                ResultSet querys = querystruttura.executeQuery(q);
                if (!querys.isBeforeFirst()) {
                    wronglabel.setText("Inserisci un ID valido!");
                    Risp.setText("");
                    Rec.setText("");
                    oklabel.setText("");
                } else {
                    wronglabel.setText("");
                    while (querys.next()) {
                        Rec.setText(querys.getString("recensione"));
                        Risp.setText("");
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void ButtonRisp(ActionEvent event) throws IOException {
        update();
    }

    public void ButtonSearch(ActionEvent event) {
         if (Id.getText().isEmpty()) {
             wronglabel.setText("Inserisci un ID valido!");
             Risp.setText("");
             Rec.setText("");
             oklabel.setText("");
         }
        else
        search(Integer.parseInt(Id.getText()));
        oklabel.setText("");
    }

    public void TornaRec(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Visualizza Recensioni.fxml");
    }

    public void solonumeriid(KeyEvent event) {
        Id.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    Id.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}
