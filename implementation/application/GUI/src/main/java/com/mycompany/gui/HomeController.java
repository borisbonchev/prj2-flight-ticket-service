/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui;

import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author boris
 */
class HomeController implements Initializable {
    
    @FXML
    private Button registerFlightButton;
    
    private final Supplier<SceneManager> sceneManagerSupplier;

    public HomeController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }
    
    @FXML
    private void switchToRegisterFlight() throws IOException {
        sceneManagerSupplier.get().changeScene("registerFlightView");
    }
    
    @FXML
    private void switchToCreateRoute() throws IOException {
        sceneManagerSupplier.get().changeScene("createRouteView");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
