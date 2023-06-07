package com.example.Controllers;

import DataBase.DatabaseConnection;
import com.example.Models.*;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerVisualizzaStruttura implements Initializable {
    @FXML
    private TableView<StrutturaAppoggio> tableView;
    @FXML
    private TableColumn<StrutturaAppoggio, Integer> IdColumn;
    @FXML
    private TableColumn<StrutturaAppoggio, String> cittaColumn;
    @FXML
    private TableColumn<StrutturaAppoggio, String> indColumn;
    @FXML
    private TableColumn<StrutturaAppoggio, String> capColumn;
    @FXML
    private TableColumn<StrutturaAppoggio, Integer> capienzaColumn;


    ObservableList<StrutturaAppoggio> Strutture = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            ResultSet rt= connectDB.createStatement().executeQuery("select * from struttura");


            while (rt.next()) {
                Strutture.add(new StrutturaAppoggio(rt.getString("Citta"),rt.getString("Indirizzo"),rt.getString("Cap"),
                        rt.getInt("Capienza"), rt.getInt("idstruttura")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        IdColumn.setCellValueFactory(new PropertyValueFactory<StrutturaAppoggio, Integer>("idstruttura"));
        cittaColumn.setCellValueFactory(new PropertyValueFactory<StrutturaAppoggio, String>("Citta"));
        indColumn.setCellValueFactory(new PropertyValueFactory<StrutturaAppoggio, String>("Indirizzo"));
        capColumn.setCellValueFactory(new PropertyValueFactory<StrutturaAppoggio, String>("Cap"));
        capienzaColumn.setCellValueFactory(new PropertyValueFactory<StrutturaAppoggio, Integer>("Capienza"));
        tableView.setItems(Strutture);
    }

    public void InserisciStruttura(ActionEvent event) throws IOException {
        Main p = new Main();
        p.changeScene("Inserisci Struttura.fxml");
    }


    public void remove(ActionEvent event){
        DataBase.DatabaseConnection connectP = new DataBase.DatabaseConnection();
        Connection connect = connectP.getConnection();
        try {
            PreparedStatement ps = connect.prepareStatement("DELETE FROM struttura WHERE idstruttura = ?;");
            ObservableList<StrutturaAppoggio> strutt = tableView.getSelectionModel().getSelectedItems();
            ps.setInt(1, Integer.valueOf(strutt.get(0).getIdstruttura()));
            ps.executeUpdate();
            int selectedID= tableView.getSelectionModel().getSelectedIndex();
            tableView.getItems().remove(selectedID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void ModifyButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Modifica Struttura.fxml");
    }


    public void BackHome(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("index Proprietario.fxml");
    }


}
