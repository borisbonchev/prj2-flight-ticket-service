package com.mycompany.gui;

import com.mycompany.businesslogic.BusinessLogicAPI;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.util.Callback;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private BusinessLogicAPI businessLogicAPI;
    private SceneManager sceneManager;
    private static final String INITIAL_VIEW = "homeView";

    private final Callback<Class<?>, Object> controllerFactory = (Class<?> c)
            -> {

        switch (c.getName()) {
            case "com.mycompany.gui.RegisterFlightController":
                return new RegisterFlightController(this::getSceneManager, businessLogicAPI.getFlightManager());
            case "com.mycompany.gui.HomeController":
                return new HomeController(this::getSceneManager);
            case "com.mycompany.gui.CreateRouteController":
                return new CreateRouteController(this::getSceneManager, businessLogicAPI.getRouteManager());
            default:
                return null;
        }
    };

    public App(BusinessLogicAPI businessLogicAPI) {
        this.businessLogicAPI = businessLogicAPI;
    }

    public App show() {
        return init(true);
    }

    App init(boolean startJavaFXToolkit) {

        if (startJavaFXToolkit) {

            Platform.startup(() -> {
            });

            initializeSceneManager();

            Platform.runLater(() -> {
                Stage stage = new Stage();
                try {
                    start(stage);
                } catch (IOException ex) {
                    throw new IllegalStateException(ex);
                }
            });

        } else {
            initializeSceneManager();
        }

        return this;
    }

    private void initializeSceneManager() {
        sceneManager = new SceneManager(controllerFactory, INITIAL_VIEW);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Airline Application");
        sceneManager.displayOn(stage, 640, 480);
    }

    public SceneManager getSceneManager() {
        return sceneManager;
    }
}