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
    public Button openEmployeeDialog;
    @FXML
    public Button openAnimalDialog;

    public MainController(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @FXML
    public void initialize() {
        openDialogButton.setOnAction(
                actionEvent -> {
                    fxWeaver.loadController(DialogController.class).show();
                }
        );
        openEmployeeDialog.setOnAction(
                actionEvent -> {
                    FxControllerAndView<EmployeeDialogController, VBox> tiledDialog =
                            fxWeaver.load(EmployeeDialogController.class);
                    tiledDialog.getController().show();
                }
        );
        openAnimalDialog.setOnAction(
                actionEvent -> {
                    try {
                        FxControllerAndView<AnimalDialogController, VBox> tiledDialog =
                                fxWeaver.load(AnimalDialogController.class);
                        tiledDialog.getController().show();
                    } catch (Exception e) {
                        e.printStackTrace();
                        showAlert(e.getLocalizedMessage());
                    }
                }
        );
    }

    private void showAlert(String message) {
        FxControllerAndView<DialogController, VBox> alertDialog =
                fxWeaver.load(DialogController.class);

        alertDialog.getView().ifPresent(v -> {
            Label label = new Label();
            label.setId("label");
            label.setText(message);
            v.getChildren().add(0, label);
        });
        alertDialog.getController().show();
    }

}
