package com.teamOne.cs631.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("EmployeeDialog.fxml")
public class EmployeeDialogController {

    private Stage stage;

    @FXML
    private VBox dialog;

    @FXML
    private TableView tableView;

    @FXML
    public void initialize() {
        this.stage = new Stage();
        stage.setScene(new Scene(dialog));
    }

    public void show() {
        stage.show();
    }
}
