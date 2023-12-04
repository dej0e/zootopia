package com.teamOne.cs631.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import lombok.extern.log4j.Log4j2;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@FxmlView
@Component
@Log4j2
public class MainController {
    private final FxWeaver fxWeaver;
    private final FxControllerAndView<DialogController, VBox> dialog;
    @FXML
    public Button openDialogButton;
    @FXML
    public Button openTiledDialogButton;

    public MainController(FxWeaver fxWeaver, FxControllerAndView<DialogController, VBox> dialog) {
        this.dialog = dialog;
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
                    FxControllerAndView<TiledDialogController, VBox> tiledDialog =
                            fxWeaver.load(TiledDialogController.class);
                    tiledDialog.getView().ifPresent(
                            v -> {
                                Label label = new Label();
                                label.setText("Dynamically added Label");
                                v.getChildren().add(label);
                            }
                    );
                    tiledDialog.getController().show();
                }
        );
    }

}
