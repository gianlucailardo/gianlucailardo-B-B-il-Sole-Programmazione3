package com.example.Controllers;

import DataBase.DatabaseConnection;
import com.example.Models.Recensione;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerRecensioni implements Initializable {
    @FXML
    private Label Labelrec;
    @FXML
    private TableView<Recensione> tableView;
    @FXML
    private TableColumn<Recensione, String> RispColumn;
    @FXML
    private TableColumn<Recensione, String> RecColumn;
    @FXML
    private TableColumn<Recensione, Integer> IDColumn;


    ObservableList<Recensione> rece = FXCollections.observableArrayList();

    public void initialize(URL url, ResourceBundle resourceBundle){

            try {
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                ResultSet pr= connectDB.createStatement().executeQuery("select * from recensione");
                while (pr.next()) {
                    rece.add(new Recensione(pr.getString("recensione"),pr.getString("risposta"),pr.getInt("id_recensione")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        RecColumn.setCellValueFactory(new PropertyValueFactory<Recensione, String>("Recensione"));
        RispColumn.setCellValueFactory(new PropertyValueFactory<Recensione, String>("Risposta"));
        IDColumn.setCellValueFactory(new PropertyValueFactory<Recensione, Integer>("idrece"));
        tableView.setItems(rece);
    }

    public void RispondiRec(ActionEvent event) throws IOException {
        Main p = new Main();
        p.changeScene("Rispondi Recensioni.fxml");
    }

    public void BackHome(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("index Receptionist.fxml");
    }
}



