package com.teamOne.cs631.controller;

import com.teamOne.cs631.models.Employee;
import com.teamOne.cs631.service.EmployeeService;
import com.teamOne.cs631.util.ModelTableViewBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
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
    private AnchorPane anchorPane;
    @FXML
    public Button closeButton;

    @FXML
    public TextField idTextField;
    @FXML
    public TextField startDateTextField;
    @FXML
    public TextField jobTypeTextField;
    @FXML
    public TextField firstNameTextField;
    @FXML
    public TextField minitTextField;
    @FXML
    public TextField lastNameTextField;
    @FXML
    public TextField streetTextField;
    @FXML
    public TextField cityTextField;
    @FXML
    public TextField stateTextField;
    @FXML
    public TextField zipTextField;
    @FXML
    public TextField hourlyRateIdTextField;
    @FXML
    public TextField supervisorIdTextField;

    @FXML
    public Button resetBtn;

    @FXML
    public RadioButton updateRadioBtn;
    @FXML
    public RadioButton viewRadioBtn;
    @FXML
    public RadioButton insertRadioBtn;
    EmployeeService employeeService;
    private Employee selectedEmployee;

    @Autowired
    public EmployeeDialogController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @FXML
    public void initialize() {

        double width = Screen.getPrimary().getBounds().getWidth() * 0.6;
        double height = Screen.getPrimary().getBounds().getHeight() * 0.6;
        this.stage = new Stage();
        stage.setScene(new Scene(employeeDialog, width, height));

        TableView<Employee> tableView = ModelTableViewBuilder.buildUpon(Employee.class);
        ObservableList<Employee> data = FXCollections.observableArrayList(employeeService.findAll());
        tableView.setItems(data);
        employeeDialog.getChildren().add(0, tableView);
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedEmployee = newSelection;
            populateTextFieldsWithData(newSelection);

        });
        resetBtn.setOnAction(
                a -> {
                    resetTextFields();
                    tableView.getSelectionModel().clearSelection();
                }
        );
        updateRadioBtn.setOnAction(a -> updateRadioBtnClicked());
        viewRadioBtn.setOnAction(a -> {
            resetTextFields();
            editable(false);
            if (selectedEmployee != null)
                populateTextFieldsWithData(selectedEmployee);
        });
        insertRadioBtn.setOnAction(a -> {
            resetTextFields();
            editable(true);
        });

    }

    public void updateRadioBtnClicked() {
        System.out.println("Update RadioBtn Clicked");
        populateTextFieldsWithData(selectedEmployee);
        editable(true);
    }

    public void resetTextFields() {

        for (Node node : anchorPane.getChildren()) {
            if (node instanceof TextField) {
                ((TextField) node).setText("");
            } else if (node instanceof RadioButton) {
                ((RadioButton) node).setSelected(false);
            }
        }
        editable(false);
    }

    public void editable(boolean value) {
        // submitBtn.setDisable(false);
        for (Node node : anchorPane.getChildren()) {
            if (node instanceof TextField) {
                ((TextField) node).setEditable(value);
            }
        }
    }

    private void populateTextFieldsWithData(Employee e) {
        if (e == null) return;
        idTextField.setText(e.getID().toString());
        startDateTextField.setText(e.getStartDate());
        jobTypeTextField.setText(e.getJobType());
        firstNameTextField.setText(e.getFirst());
        minitTextField.setText(e.getMinit());
        lastNameTextField.setText(e.getLast());
        streetTextField.setText(e.getStreet());
        cityTextField.setText(e.getCity());
        stateTextField.setText(e.getState());
        zipTextField.setText(e.getZip());
        hourlyRateIdTextField.setText(e.getHourlyRateId());
        supervisorIdTextField.setText(e.getSupervisorId().toString());
    }

    private void clearValuesFromTextFields() {
        idTextField.setText("");
        startDateTextField.setText("");
        jobTypeTextField.setText("");
        firstNameTextField.setText("");
        minitTextField.setText("");
        lastNameTextField.setText("");
        streetTextField.setText("");
        cityTextField.setText("");
        stateTextField.setText("");
        zipTextField.setText("");
        hourlyRateIdTextField.setText("");
        supervisorIdTextField.setText("");
    }

    public void show() {
        stage.show();
        closeButton.setOnAction(
                a -> stage.close()
        );

    }
}
