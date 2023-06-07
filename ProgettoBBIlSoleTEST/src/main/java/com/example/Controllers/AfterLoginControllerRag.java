package com.example.Controllers;

import javafx.event.ActionEvent;

import java.io.IOException;

public class AfterLoginControllerRag {
    public void FormDati(ActionEvent event) throws IOException {
        Main p = new Main();
        p.changeScene("Dati Contabili.fxml");
    }

    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Login.fxml");
    }

    public void InviaTasseSog(ActionEvent event) throws IOException {
        Main p = new Main();
        p.changeScene("Tasse Di Soggiorno.fxml");
    }
}
