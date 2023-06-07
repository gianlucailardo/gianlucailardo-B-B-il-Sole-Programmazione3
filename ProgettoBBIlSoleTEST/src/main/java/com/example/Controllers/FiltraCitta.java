package com.example.Controllers;
import com.example.Models.Prenotazione;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
public class FiltraCitta implements Command{
    @Override
    public void executeoperation(KeyEvent event, TextField text, TableView<Prenotazione> tableView, FilteredList filter) {
        ControllerVisualizzaP o= new ControllerVisualizzaP();
        o.prova(event,text,tableView,filter);
    }
}
