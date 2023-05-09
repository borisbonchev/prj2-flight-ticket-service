package com.mycompany.gui;

import com.mycompany.businesslogic.FlightManager;
import javafx.fxml.FXML;
import com.mycompany.datarecords.FlightData;
import com.mycompany.dbservice.Main;
import com.mycompany.persistence.DBProvider;
import javax.sql.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

class RegisterFlightController implements Initializable {

    private final Supplier<SceneManager> sceneManagerSupplier;
    private final FlightManager flightManager;
    ObservableList<String> routeList = FXCollections.observableArrayList();
    ObservableList<String> aircraftList = FXCollections.observableArrayList();

    public RegisterFlightController(Supplier<SceneManager> sceneManagerSupplier, FlightManager flightManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.flightManager = flightManager;
    }

    @FXML
    private ChoiceBox route;

    @FXML
    private ChoiceBox aircraft;

    @FXML
    private TextField ticketprice;

    @FXML
    private DatePicker flightDatePicker;
    
    @FXML
    private TextField timeOfFlight;

    @FXML
    private Button saveFlight;

    @FXML
    private Label result;

    @FXML
    private DatePicker dateOfArrival;

    @FXML
    private TextField timeOfArrival;

    @FXML
    private void toHome() {
        sceneManagerSupplier.get().changeScene("homeView");
    }

    @FXML
    private void storeFlight() {

        try {
            FlightData flightData = new FlightData(route.getSelectionModel().getSelectedItem().toString(),
                    aircraft.getSelectionModel().getSelectedItem().toString(),
                    ticketprice.getText() + "€", flightDatePicker.getValue().toString(), timeOfFlight.getText(),
                    dateOfArrival.getValue().toString(), timeOfArrival.getText());
            FlightData addedFlight = flightManager.add(flightData);
            
            if (addedFlight.getRoute().contains("ALREADY EXISTS")) {
                throw new SQLException("The chosen flight already exists in the database.");
            } else {
                result.setText("Flight added = " + addedFlight.toString());
                result.setTextFill(Color.BLACK);
            }
            
        } catch (IllegalArgumentException e) {
            result.setText(e.getMessage());
            result.setTextFill(Color.RED);
        } catch (RuntimeException | SQLException e) {
            result.setText(e.getMessage());
            result.setTextFill(Color.RED);
        }       
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DataSource db = DBProvider.getDataSource("postgres");

        // Route ChoiceBox
        String routeQuery = "select origin, destination from route";

        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(routeQuery)) {
            ResultSet dbResult = pstm.executeQuery();

            while (dbResult.next()) {
                String origin = dbResult.getString("origin");
                String destination = dbResult.getString("destination");

                routeList.add(origin + "-" + destination);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        route.setItems(routeList);

        // Aircraft ChoiceBox
        String aircraftQuery = "select id from aircraft";

        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(aircraftQuery)) {
            ResultSet dbResult = pstm.executeQuery();

            while (dbResult.next()) {
                aircraftList.add(dbResult.getString("id"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        aircraft.setItems(aircraftList);
    }
}
