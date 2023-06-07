package com.example.Controllers;
import com.example.Controllers.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AfterLoginControllerP {

    @FXML
    private Button logout;


    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Login.fxml");
    }

    public void VisualizzaStrutture(ActionEvent event) throws IOException {
        Main p = new Main();
        p.changeScene("Visualizza Strutture.fxml");
    }


    public void VisualizzaGraficoB(ActionEvent event) throws IOException {
        Main p = new Main();
        p.changeScene("Grafico Dati Contabili.fxml");
    }
    public void VisualizzaGraficoS(ActionEvent event) throws IOException {
        Main p = new Main();
        p.changeScene("Grafico Stacked Dati Contabili.fxml");
    }
    public void VisualizzaGraficoA(ActionEvent event) throws IOException {
        Main p = new Main();
        p.changeScene("Grafico AreaChart.fxml");
    }

    public void VisualizzaClienti(ActionEvent event) throws IOException {
        Main p = new Main();
        p.changeScene("Visualizza Clienti.fxml");
    }

    public void VisualizzaPrenotazioni(ActionEvent event) throws IOException {
        Main p = new Main();
        p.changeScene("Visualizza Prenotazioni.fxml");
    }

    public void InviaDatiAn(ActionEvent event) throws IOException {
        Main p = new Main();
        p.changeScene("Dati Questura.fxml");
    }

}
