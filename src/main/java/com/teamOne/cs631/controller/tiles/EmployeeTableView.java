package com.teamOne.cs631.controller.tiles;

import com.teamOne.cs631.models.Employee;
import com.teamOne.cs631.service.EmployeeService;
import com.teamOne.cs631.util.ModelTableViewBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView
public class EmployeeTableView {
    @FXML
    private VBox employeeContainer;

    EmployeeService employeeService;

    @Autowired
    public EmployeeTableView(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @FXML
    public void initialize() {
        TableView tableView = ModelTableViewBuilder.buildUpon(Employee.class);
        ObservableList<Employee> data = FXCollections.observableArrayList(employeeService.findAll());
        tableView.setItems(data);
        employeeContainer.getChildren().add(tableView);
    }
}
