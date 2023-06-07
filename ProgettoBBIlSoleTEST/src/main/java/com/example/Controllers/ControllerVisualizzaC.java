package com.example.Controllers;

import DataBase.DatabaseConnection;
import com.example.Models.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerVisualizzaC implements Initializable{
    @FXML
    private TableView<Cliente> tableView;

    @FXML
    private TableColumn<Cliente, String> NomeColumn;
    @FXML
    private TableColumn<Cliente, String> CognomeColumn;
    @FXML
    private TableColumn<Cliente, String> CFColumn;
    @FXML
    private TableColumn<Cliente, String> NDColumn;

    ObservableList<Cliente> clienti = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            ResultSet pr= connectDB.createStatement().executeQuery("select * from clienti");
            while (pr.next()) {
                clienti.add(new Cliente(pr.getString("nome"),pr.getString("cognome"),pr.getString("codice_fiscale"),
                        pr.getString("numero_documento")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        NomeColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        CognomeColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cognome"));
        CFColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("codice_fiscale"));
        NDColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("numero_documento"));
        tableView.setItems(clienti);
    }

    public void BackHome(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("index Proprietario.fxml");
    }
}
