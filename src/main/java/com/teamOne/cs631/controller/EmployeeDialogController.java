package com.teamOne.cs631.controller;

import com.teamOne.cs631.models.Employee;
import com.teamOne.cs631.models.enums.UIMode;
import com.teamOne.cs631.service.EmployeeService;
import com.teamOne.cs631.util.ModelTableViewBuilder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private UIMode uiMode;
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
    public Button submitBtn;

    @FXML
    public RadioButton updateRadioBtn;
    @FXML
    public RadioButton viewRadioBtn;
    @FXML
    public RadioButton insertRadioBtn;
    EmployeeService employeeService;
    private Employee selectedEmployee;

    @FXML
    public ToggleGroup group;

    public TableView<Employee> tableView;

    @Autowired
    public EmployeeDialogController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @FXML
    public void initialize() {
        uiMode = UIMode.VIEW;
        double width = Screen.getPrimary().getBounds().getWidth() * 0.6;
        double height = Screen.getPrimary().getBounds().getHeight() * 0.6;
        this.stage = new Stage();
        stage.setScene(new Scene(employeeDialog, width, height));

        insertRadioBtn.setUserData(UIMode.INSERT);
        viewRadioBtn.setUserData(UIMode.VIEW);
        updateRadioBtn.setUserData(UIMode.UPDATE);
        viewRadioBtn.setSelected(true);

        tableView = ModelTableViewBuilder.buildUpon(Employee.class);
        employeeDialog.getChildren().add(0, tableView);

        loadDataIntoTable();
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedEmployee = newSelection;
            populateTextFieldsWithData(newSelection);

        });
        resetBtn.setOnAction(
                a -> {
                    resetTextFields();
                    tableView.getSelectionModel().clearSelection();
                    submitBtn.setDisable(true);
                    viewRadioBtn.setSelected(true);
                    uiMode = UIMode.VIEW;
                }
        );

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {

                if (group.getSelectedToggle() != null) {
                    UIMode mode = (UIMode) group.getSelectedToggle().getUserData();
                    switch (mode) {
                        case UPDATE:
                            updateRadioBtnClicked();
                            uiMode = UIMode.UPDATE;
                            break;
                        case VIEW:
                            resetTextFields();
                            editable(false);
                            submitBtn.setDisable(true);
                            uiMode = UIMode.VIEW;

                            if (selectedEmployee != null)
                                populateTextFieldsWithData(selectedEmployee);
                            break;

                        case INSERT:
                            resetTextFields();
                            editable(true);
                            submitBtn.setDisable(false);
                            uiMode = UIMode.INSERT;
                            break;
                    }


                }
            }
        });
        submitBtn.setOnAction(a -> {
            Integer changedCount = 0;
            try {
                switch (uiMode) {
                    case VIEW:
                        return;
                    case UPDATE:
                        Employee e = collectValues();
                        changedCount = employeeService.update(e);
                        break;
                    case INSERT:
                        Employee e1 = collectValues();
                        changedCount = employeeService.insert(e1);
                        break;
                }
                if (changedCount > 0) {
                    loadDataIntoTable();
                    viewRadioBtn.setSelected(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void loadDataIntoTable() {
        ObservableList<Employee> data = FXCollections.observableArrayList(employeeService.findAll());
        tableView.setItems(data);
    }

    private Employee collectValues() {
        Employee employee = new Employee();
        employee.ID = Integer.valueOf(idTextField.getText());
        employee.jobType = jobTypeTextField.getText();
        employee.first = firstNameTextField.getText();
        employee.minit = minitTextField.getText();
        employee.last = lastNameTextField.getText();
        employee.street = streetTextField.getText();
        employee.state = stateTextField.getText();
        employee.city = cityTextField.getText();
        employee.zip = zipTextField.getText();
        employee.hourlyRateId = hourlyRateIdTextField.getText();
        employee.supervisorId = Integer.valueOf(supervisorIdTextField.getText());
        return employee;
//        employee.startDate = startDateTextField.getText();
//        employee.startDate = startDateTextField.getText();
//        employee.startDate = startDateTextField.getText();


    }

    public void updateRadioBtnClicked() {
        System.out.println("Update RadioBtn Clicked");
        populateTextFieldsWithData(selectedEmployee);
        editable(true);
        uiMode = UIMode.UPDATE;
        submitBtn.setDisable(false);
    }

    public void resetTextFields() {
        for (Node node : anchorPane.getChildren()) {
            if (node instanceof TextField) {
                ((TextField) node).setText("");
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
