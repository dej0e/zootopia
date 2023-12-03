package com.teamOne.cs631.controller;

import com.teamOne.cs631.models.Employee;
import com.teamOne.cs631.service.EmployeeService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@FxmlView
@Component
@Log4j2
public class MainWindow {

    private final FxControllerAndView<SomeDialog, VBox> someDialog;

    protected static final Logger logger = LogManager.getLogger();
    @FXML
    public Button openDialogButton;


    EmployeeService employeeService;

    @Autowired
    public MainWindow(FxControllerAndView<SomeDialog, VBox> someDialog, EmployeeService employeeService) {
        this.someDialog = someDialog;
        List<Employee> employeeList = employeeService.findAll();
        logger.info("asome");
    }

    @FXML
    public void initialize() {
        openDialogButton.setOnAction(
                actionEvent -> someDialog.getController().show()
        );
    }

}
