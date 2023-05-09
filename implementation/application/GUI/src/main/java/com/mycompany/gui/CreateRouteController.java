/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.businesslogic.RouteManager;
import java.util.function.Supplier;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.mycompany.datarecords.RouteData;
import java.sql.SQLException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 *
 * @author boris
 */
class CreateRouteController {

    private final Supplier<SceneManager> sceneManagerSupplier;
    private final RouteManager routeManager;

    public CreateRouteController(Supplier<SceneManager> sceneManagerSupplier, RouteManager routeManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.routeManager = routeManager;
    }

    @FXML
    private TextField originText;

    @FXML
    private TextField destinationText;

    @FXML
    private Label result;

    @FXML
    private Button storeRouteButton;

    @FXML
    private void storeRoute() {
        try {
            RouteData routeData = new RouteData(originText.getText(), destinationText.getText());
            RouteData addedRoute = routeManager.add(routeData);
            
            if (addedRoute.getOrigin().contains("ALREADY EXISTS")) {
                throw new SQLException("The chosen route already exists in the database.");
            } else {
                result.setText(addedRoute.toString());
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

    @FXML
    private void toHome() {
        sceneManagerSupplier.get().changeScene("homeView");
    }
}
