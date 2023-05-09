package com.mycompany.gui;

import java.util.function.Supplier;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

class SecondaryController {
    
    @FXML
    private Button secondaryButton;

    @FXML
    private Label prevLabel;
    
    private final Supplier<SceneManager> sceneManagerSupplier;

    public SecondaryController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }
    
    @FXML
    private void switchToPrimary() {
        sceneManagerSupplier.get().changeScene("primaryView");
    }
    
    public void setPreviousView(String view){
        prevLabel.setText(view);
    }    
}