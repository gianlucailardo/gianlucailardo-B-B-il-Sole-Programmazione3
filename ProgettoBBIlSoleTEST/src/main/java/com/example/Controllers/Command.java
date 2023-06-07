package com.example.Controllers;
import com.example.Models.Prenotazione;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
public interface Command {
    void executeoperation(KeyEvent event, TextField text, TableView<Prenotazione> tableView, FilteredList filter);
}
