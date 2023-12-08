package com.teamOne.cs631.controller;



import com.teamOne.cs631.models.Animal;
import com.teamOne.cs631.models.AnimalJoinSpecies;
import com.teamOne.cs631.models.Reports;
import com.teamOne.cs631.models.RevenueEvents;
import com.teamOne.cs631.models.RevenueJoin;
import com.teamOne.cs631.service.ReportService;


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

import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("ReportsDialog.fxml")
public class ReportsDialogController {
    
    private Stage stage;
    @FXML
    private VBox Dialog;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    public ToggleGroup group;
    public TableView<RevenueEvents> tableView1;
    public TableView<RevenueJoin> tableView2;
    public TableView<AnimalJoinSpecies> tableView3;
    public TableView<RevenueJoin> tableView4;
    public TableView<RevenueEvents> tableView5;
    public TableView<RevenueEvents> tableView6;
    private RevenueEvents selectedRevenueEvents;
    private Animal selectedAnimal;
    private RevenueJoin selectedRevenueJoin;
    private AnimalJoinSpecies selectedAnimalJoinSpecies;
    
    @FXML
    public DatePicker startDateDatePicker;
    @FXML
    public Button resetBtn;
    @FXML
    public Button submitBtn;
    @FXML
    public Button closeBtn;
  
    ReportService reportService;
    private Reports selectedReport;
    

    private final FxWeaver fxWeaver;

    @Autowired
    public ReportsDialogController(FxWeaver fxWeaver, ReportService reportService) {
        this.fxWeaver = fxWeaver;
        this.reportService=reportService;
    }
     public void reset() {
            tableView1.getItems().clear();
            tableView2.getItems().clear();
            tableView3.getItems().clear();
            tableView4.getItems().clear();
            tableView5.getItems().clear();
            tableView6.getItems().clear();
            for (Node node : anchorPane.getChildren()) { 
                if (node instanceof DatePicker) {
                    ((DatePicker) node).setValue(null);
                }
            }
        }
    @FXML
    public void initialize() {
        
        double width = Screen.getPrimary().getBounds().getWidth()*0.8 ;
        double height = Screen.getPrimary().getBounds().getHeight()*0.8 ;
        this.stage = new Stage();
        stage.setScene(new Scene(Dialog, width, height));

        tableView1 = ModelTableViewBuilder.buildUpon(RevenueEvents.class);
        tableView2 = ModelTableViewBuilder.buildUpon(RevenueJoin.class);
        tableView3 = ModelTableViewBuilder.buildUpon(AnimalJoinSpecies.class);
        tableView4 = ModelTableViewBuilder.buildUpon(RevenueJoin.class);
        tableView5 = ModelTableViewBuilder.buildUpon(RevenueEvents.class);
        tableView6 = ModelTableViewBuilder.buildUpon(RevenueEvents.class);
        Dialog.getChildren().add(0, tableView1);
        Dialog.getChildren().add(1, tableView2);
        Dialog.getChildren().add(2, tableView3);
        Dialog.getChildren().add(3, tableView4);
        Dialog.getChildren().add(4, tableView5);
        Dialog.getChildren().add(5, tableView6);

        
        tableView1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedRevenueEvents = newSelection;

        });
        tableView2.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedRevenueJoin = newSelection;

        });
        tableView3.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedAnimalJoinSpecies = newSelection;

        });
        tableView4.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedRevenueJoin = newSelection;

        });
        tableView5.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedRevenueEvents = newSelection;

        });
        tableView6.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedRevenueEvents = newSelection;

        });
        resetBtn.setOnAction(
                a -> {
                    reset();
                    tableView1.getSelectionModel().clearSelection();
                    tableView2.getSelectionModel().clearSelection();
                    tableView3.getSelectionModel().clearSelection();
                    tableView4.getSelectionModel().clearSelection();
                    tableView5.getSelectionModel().clearSelection();
                    tableView6.getSelectionModel().clearSelection();
                    submitBtn.setDisable(true);
                    
                }
        );
        
        startDateDatePicker.setOnAction(
                a->submitBtn.setDisable(false)
        );
        submitBtn.setDisable(true);
        submitBtn.setOnAction(a -> {
            loadDataIntoTable();
        });
        
    }
    private void loadDataIntoTable() {
        
        ObservableList<RevenueEvents> data = FXCollections.observableArrayList(reportService.findAll(startDateDatePicker.getValue(),1));
        tableView1.setItems(data);
        data=FXCollections.observableArrayList(reportService.findAll(startDateDatePicker.getValue(),5));
        tableView5.setItems(data);
        data=FXCollections.observableArrayList(reportService.findAll(startDateDatePicker.getValue(),6));
        tableView6.setItems(data);

        ObservableList<RevenueJoin> data2 = FXCollections.observableArrayList(reportService.findAll2(startDateDatePicker.getValue(),2));
        tableView2.setItems(data2);
        data2 = FXCollections.observableArrayList(reportService.findAll2(startDateDatePicker.getValue(),4));
        tableView4.setItems(data2);

        //Will work after species table is added
        // ObservableList<AnimalJoinSpecies> data3 = FXCollections.observableArrayList(reportService.findAll3());
        // tableView3.setItems(data3);
    }
    public void show() {
        stage.show();
        closeBtn.setOnAction(
                a -> stage.close()
        );

    }
   
}
