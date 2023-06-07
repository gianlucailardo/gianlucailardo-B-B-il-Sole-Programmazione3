package com.example.Controllers;

import com.example.Models.Recensione;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;

public class AfterLoginControllerRe {


    public void ButtonRec(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Visualizza Recensioni.fxml");
        ControllerRecensioni o = new ControllerRecensioni();
       // o.NotifyRe();
    }

    public void BackHome(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("index Receptionist.fxml");
    }

    public void BackLogin(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Login.fxml");
    }
}
