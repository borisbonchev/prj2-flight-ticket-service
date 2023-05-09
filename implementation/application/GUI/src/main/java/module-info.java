module GUI_module {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.base;
    requires BusinessLogic_module;
    requires DataRecords_module;
    requires java.sql;
            
    opens com.mycompany.gui to javafx.fxml;
    exports com.mycompany.gui;
}
