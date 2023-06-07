package com.example.Controllers;
import DataBase.DatabaseConnection;
import com.example.Models.Prenotazione;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Predicate;
public class ControllerVisualizzaP implements Initializable{
    @FXML
    private TableView<Prenotazione> tableView;
    @FXML
    private TableColumn<Prenotazione, String> CFColumn;
    @FXML
    private TableColumn<Prenotazione, String> CinColumn;
    @FXML
    private TableColumn<Prenotazione, String> CoutColumn;
    @FXML
    private TableColumn<Prenotazione, String> CittaColumn;
    @FXML
    private TableColumn<Prenotazione, Integer> NPColumn;
    @FXML
    private TableColumn<Prenotazione, String> TCColumn;
    @FXML
    private TextField TextCod;
    @FXML
    private TextField TextCity;
    CercaCod o= new CercaCod();
    FiltraCitta p= new FiltraCitta();
    ObservableList<Prenotazione> prenotazioni = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            ResultSet rt= connectDB.createStatement().executeQuery("select * from prenotazioni");
            while (rt.next()) {
                prenotazioni.add(new Prenotazione(rt.getString("codice_fiscale"),rt.getString("check_in"),rt.getString("check_out"),
                        rt.getString("citta_struttura"),rt.getInt("numero_persone"),rt.getString("tipologia_camera")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CFColumn.setCellValueFactory(new PropertyValueFactory<Prenotazione, String>("codice_fiscale"));
        CinColumn.setCellValueFactory(new PropertyValueFactory<Prenotazione, String>("check_in"));
        CoutColumn.setCellValueFactory(new PropertyValueFactory<Prenotazione, String>("check_out"));
        CittaColumn.setCellValueFactory(new PropertyValueFactory<Prenotazione, String>("citta_struttura"));
        NPColumn.setCellValueFactory(new PropertyValueFactory<Prenotazione, Integer>("numero_persone"));
        TCColumn.setCellValueFactory(new PropertyValueFactory<Prenotazione, String>("tipologia_camera"));
        tableView.setItems(prenotazioni);
    }
    public void cerca (KeyEvent event, TextField text, TableView<Prenotazione> tableView, FilteredList filter)
    {
        text.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate((Predicate<? super Prenotazione>) (Prenotazione prenotazione)-> {
                if (newValue.isEmpty() || newValue == null){
                    return true;
                }else if(prenotazione.getCodice_fiscale().contains(newValue)){
                    return true;
                }
                return false;
            });
        });
        SortedList sort=new SortedList(filter);
        sort.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sort);
    }
    FilteredList filter=new FilteredList(prenotazioni,e->true);
    @FXML
    public void prova(KeyEvent event, TextField textCity, TableView<Prenotazione> tableView, FilteredList filter){
        textCity.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate((Predicate<? super Prenotazione>) (Prenotazione prenotazione)-> {
                if (newValue.isEmpty() || newValue == null){
                    return true;
                }else if(prenotazione.getCitta_struttura().contains(newValue)){
                    return true;
                }
                return false;
            });
        });
        SortedList sort=new SortedList(filter);
        sort.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sort);
    }
    public void ButtonCod (KeyEvent event){
        o.executeoperation(event,TextCod, tableView,filter );
    }
    public void ButtonCity (KeyEvent event){
        p.executeoperation(event,TextCity,tableView,filter);
    }
    public void BackHome(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("index Proprietario.fxml");
    }
}
