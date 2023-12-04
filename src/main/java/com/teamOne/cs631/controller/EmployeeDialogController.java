package com.teamOne.cs631.controller;

import com.teamOne.cs631.models.Employee;
import com.teamOne.cs631.service.EmployeeService;
import com.teamOne.cs631.util.ModelTableViewBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("EmployeeDialog.fxml")
public class EmployeeDialogController {
    private Stage stage;
    @FXML
    private VBox employeeDialog;
    @FXML
    public Button closeButton;
    @FXML
    public Label ssnLabel;
    @FXML
    private TextField ssnTextField;

    EmployeeService employeeService;

    @Autowired
    public EmployeeDialogController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @FXML
    public void initialize() {

        double width = Screen.getPrimary().getBounds().getWidth()*0.6;
        double height = Screen.getPrimary().getBounds().getHeight()*0.6;
        this.stage = new Stage();
        stage.setScene(new Scene(employeeDialog, width, height));

        TableView<Employee> tableView = ModelTableViewBuilder.buildUpon(Employee.class);
        ObservableList<Employee> data = FXCollections.observableArrayList(employeeService.findAll());
        tableView.setItems(data);
        employeeDialog.getChildren().add(0, tableView);
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            ssnTextField.setText(newSelection.getSSN());
            ssnTextField.setEditable(false);

        });
    }

    public void show() {
        stage.show();
        closeButton.setOnAction(
                a -> stage.close()
        );

    }
}
