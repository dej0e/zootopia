package com.teamOne.cs631.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import lombok.extern.log4j.Log4j2;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@FxmlView
@Component
@Log4j2
public class MainController {
    private final FxWeaver fxWeaver;
    @FXML
    public Button openDialogButton;
    @FXML
    public Button openTiledDialogButton;

    public MainController(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @FXML
    public void initialize() {
        openDialogButton.setOnAction(
                actionEvent ->  {
                    fxWeaver.loadController(DialogController.class).show();
                }
        );
        openTiledDialogButton.setOnAction(
                actionEvent -> {
                    FxControllerAndView<EmployeeDialogController, VBox> tiledDialog =
                            fxWeaver.load(EmployeeDialogController.class);
                    tiledDialog.getView().ifPresent(
                            v -> {
                                Label label = new Label();
                                label.setId("label");
                                label.setText("Dynamically added Label");
                                v.getChildren().add(label);
                            }
                    );
                    tiledDialog.getController().show();
                }
        );
    }

}
