package com.teamOne.cs631.controller;

import com.teamOne.cs631.models.Reports;
import com.teamOne.cs631.service.ReportService;
import com.teamOne.cs631.models.Query1Model;
import com.teamOne.cs631.models.Query2Model;
import com.teamOne.cs631.models.Query3Model;
import com.teamOne.cs631.models.Query4Model;
import com.teamOne.cs631.models.Query5Model;
import com.teamOne.cs631.models.Query6Model;
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

import javax.swing.text.LabelView;

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
    public TableView<Query1Model> tableView1;
    public TableView<Query2Model> tableView2;
    public TableView<Query3Model> tableView3;
    public TableView<Query4Model> tableView4;
    public TableView<Query5Model> tableView5;
    public TableView<Query6Model> tableView6;

    private Query1Model selectedQuery1Event;
    private Query2Model selectedQuery2Event;
    private Query3Model selectedQuery3Event;
    private Query4Model selectedQuery4Event;
    private Query5Model selectedQuery5Event;
    private Query6Model selectedQuery6Event;
    
    
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
        
        double width = Screen.getPrimary().getBounds().getWidth()*0.9 ;
        double height = Screen.getPrimary().getBounds().getHeight()*0.9 ;
        this.stage = new Stage();
        stage.setScene(new Scene(Dialog, width, height));
        tableView1 = ModelTableViewBuilder.buildUpon(Query1Model.class);
        tableView2 = ModelTableViewBuilder.buildUpon(Query2Model.class);
        tableView3 = ModelTableViewBuilder.buildUpon(Query3Model.class);
        tableView4 = ModelTableViewBuilder.buildUpon(Query4Model.class);
        tableView5 = ModelTableViewBuilder.buildUpon(Query5Model.class);
        tableView6 = ModelTableViewBuilder.buildUpon(Query6Model.class);
        Label label1=new Label();
        label1.setText("Query1");
        Label label2=new Label();
        label2.setText("Query2");
        Label label3=new Label();
        label3.setText("Query3");
        Label label4=new Label();
        label4.setText("Query4");
        Label label5=new Label();
        label5.setText("Query5");
        Label label6=new Label();
        label6.setText("Query6");


        Dialog.getChildren().add(0, label1);
        Dialog.getChildren().add(1, tableView1);
        Dialog.getChildren().add(2, label2);
        Dialog.getChildren().add(3, tableView2);
        Dialog.getChildren().add(4, label3);
        Dialog.getChildren().add(5, tableView3);
        Dialog.getChildren().add(6, label4);
        Dialog.getChildren().add(7, tableView4);
        Dialog.getChildren().add(8, label5);
        Dialog.getChildren().add(9, tableView5);
        Dialog.getChildren().add(10, label6);
        Dialog.getChildren().add(11, tableView6);
        tableView1.setMinSize(0,50);
        tableView2.setMinSize(0,50);
        tableView3.setMinSize(0,50);
        tableView4.setMinSize(0,50);
        tableView5.setMinSize(0,50);
        tableView6.setMinSize(0,50);

        
        tableView1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedQuery1Event=newSelection;

        });
        tableView2.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedQuery2Event=newSelection;

        });
        tableView3.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedQuery3Event=newSelection;


        });
        tableView4.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedQuery4Event=newSelection;

        });
        tableView5.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedQuery5Event=newSelection;

        });
        tableView6.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedQuery6Event=newSelection;

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
        
        ObservableList<Query1Model> data1 = FXCollections.observableArrayList(reportService.query1findAll(startDateDatePicker.getValue()));
        tableView1.setItems(data1);
        ObservableList<Query2Model> data2 = FXCollections.observableArrayList(reportService.query2findAll(startDateDatePicker.getValue()));
        tableView2.setItems(data2);
        ObservableList<Query3Model> data3 = FXCollections.observableArrayList(reportService.query3findAll());
        tableView3.setItems(data3);
        ObservableList<Query4Model> data4 = FXCollections.observableArrayList(reportService.query4findAll(startDateDatePicker.getValue()));
        tableView4.setItems(data4);
        ObservableList<Query5Model> data5 = FXCollections.observableArrayList(reportService.query5findAll(startDateDatePicker.getValue()));
        tableView5.setItems(data5);
        ObservableList<Query6Model> data6 = FXCollections.observableArrayList(reportService.query6findAll(startDateDatePicker.getValue()));
        tableView6.setItems(data6);

    }
    public void show() {
        stage.show();
        closeBtn.setOnAction(
                a -> stage.close()
        );

    }
   
}
