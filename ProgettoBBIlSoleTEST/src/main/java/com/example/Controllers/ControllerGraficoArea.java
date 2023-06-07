package com.example.Controllers;

import DataBase.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ControllerGraficoArea implements Strategy, Initializable {
    @FXML
    private AreaChart<?, ?> areaChart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        grafico();
    }
    public void BackHome(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Index Proprietario.fxml");
    }

    @Override
    public void grafico() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        //String qt = "select costi  from dati_contabili where mese='Gennaio'";
        ArrayList<String> mesi = new ArrayList<String>(Arrays.asList("Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno",
                "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"));
        ArrayList<Integer> costi = new ArrayList<Integer>();
        ArrayList<Integer> ricavi = new ArrayList<Integer>();
        for (int i = 0; i < mesi.size(); i++) {
            String q = "select * from dati_contabili where mese='" + mesi.get(i) + "'";
            try {
                Statement querymese = connectDB.createStatement();
                ResultSet querym = querymese.executeQuery(q);
                while (querym.next()) {
                    costi.add(querym.getInt("costi"));
                    ricavi.add(querym.getInt("ricavi"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        try {
            areaChart.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent;");
            XYChart.Series series1 = new XYChart.Series();
            series1.setName("Costi");
            series1.getData().add(new XYChart.Data("Gennaio", costi.get(0)));
            series1.getData().add(new XYChart.Data("Febbraio", costi.get(1)));
            series1.getData().add(new XYChart.Data("Marzo", costi.get(2)));
            series1.getData().add(new XYChart.Data("Aprile", costi.get(3)));
            series1.getData().add(new XYChart.Data("Maggio", costi.get(4)));
            series1.getData().add(new XYChart.Data("Giugno", costi.get(5)));
            series1.getData().add(new XYChart.Data("Luglio", costi.get(6)));
            series1.getData().add(new XYChart.Data("Agosto", costi.get(7)));
            series1.getData().add(new XYChart.Data("Settembre", costi.get(8)));
            series1.getData().add(new XYChart.Data("Ottobre", costi.get(9)));
            series1.getData().add(new XYChart.Data("Novembre", costi.get(10)));
            series1.getData().add(new XYChart.Data("Dicembre", costi.get(11)));

            XYChart.Series series2 = new XYChart.Series();
            series2.setName("Ricavi");
            series2.getData().add(new XYChart.Data("Gennaio", ricavi.get(0)));
            series2.getData().add(new XYChart.Data("Febbraio", ricavi.get(1)));
            series2.getData().add(new XYChart.Data("Marzo", ricavi.get(2)));
            series2.getData().add(new XYChart.Data("Aprile", ricavi.get(3)));
            series2.getData().add(new XYChart.Data("Maggio", ricavi.get(4)));
            series2.getData().add(new XYChart.Data("Giugno", ricavi.get(5)));
            series2.getData().add(new XYChart.Data("Luglio", ricavi.get(6)));
            series2.getData().add(new XYChart.Data("Agosto", ricavi.get(7)));
            series2.getData().add(new XYChart.Data("Settembre", ricavi.get(8)));
            series2.getData().add(new XYChart.Data("Ottobre", ricavi.get(9)));
            series2.getData().add(new XYChart.Data("Novembre", ricavi.get(10)));
            series2.getData().add(new XYChart.Data("Dicembre", ricavi.get(11)));

            areaChart.getData().addAll(series1, series2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



