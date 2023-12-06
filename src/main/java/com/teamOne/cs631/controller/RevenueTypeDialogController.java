package com.teamOne.cs631.controller;

import com.teamOne.cs631.models.RevenueTypes;

import com.teamOne.cs631.models.enums.UIMode;
import com.teamOne.cs631.service.RevenueTypeService;

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
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("RevenueTypeDialog.fxml")
public class RevenueTypeDialogController {
    private UIMode uiMode;
    private Stage stage;
    @FXML
    private VBox vBox;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    public Button closeButton;


    
    @FXML
    public TextField revenueTypeIdTextField;
    @FXML
    public TextField nameTextField;
    @FXML
    public TextField typeTextField;
    @FXML
    public TextField buildingIdTextField;
    
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
    RevenueTypeService revenueTypeService;
    private RevenueTypes selectedRevenueTypes;

    @FXML
    public ToggleGroup group;

    public TableView<RevenueTypes> tableView;

    private final FxWeaver fxWeaver;

    @Autowired
    public RevenueTypeDialogController(FxWeaver fxWeaver,RevenueTypeService revenueTypeService) {
        this.revenueTypeService = revenueTypeService;
        this.fxWeaver = fxWeaver;
    }

    @FXML
    public void initialize() {
        uiMode = UIMode.VIEW;
        double width = Screen.getPrimary().getBounds().getWidth() * 0.6;
        double height = Screen.getPrimary().getBounds().getHeight() * 0.6;
        this.stage = new Stage();
        stage.setScene(new Scene(vBox, width, height));

        insertRadioBtn.setUserData(UIMode.INSERT);
        viewRadioBtn.setUserData(UIMode.VIEW);
        updateRadioBtn.setUserData(UIMode.UPDATE);
        viewRadioBtn.setSelected(true);
        editable(false);
        tableView = ModelTableViewBuilder.buildUpon(RevenueTypes.class);
        vBox.getChildren().add(0, tableView);

        loadDataIntoTable();
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedRevenueTypes = newSelection;
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

                            if (selectedRevenueTypes != null)
                                populateTextFieldsWithData(selectedRevenueTypes);
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
                        RevenueTypes e = collectValues();
                        changedCount = revenueTypeService.update(e);
                        break;
                    case INSERT:
                        RevenueTypes e1 = collectValues();
                        changedCount = revenueTypeService.insert(e1);
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
        ObservableList<RevenueTypes> data = FXCollections.observableArrayList(revenueTypeService.findAll());
        tableView.setItems(data);
    }

    private RevenueTypes collectValues() {
        RevenueTypes revenueTypes = new RevenueTypes();
        
        revenueTypes.revenueTypeId=Integer.valueOf(revenueTypeIdTextField.getText());
        revenueTypes.buildingId = Integer.valueOf(buildingIdTextField.getText());
        revenueTypes.name = nameTextField.getText();
        revenueTypes.type = typeTextField.getText();
        
        return revenueTypes;



    }

    public void updateRadioBtnClicked() {
        System.out.println("Update RadioBtn Clicked");
        populateTextFieldsWithData(selectedRevenueTypes);
        editable(true);
        uiMode = UIMode.UPDATE;
        submitBtn.setDisable(false);
    }

    public void resetTextFields() {
        for (Node node : anchorPane.getChildren()) {
            if (node instanceof TextField) {
                ((TextField) node).setText("");
            }
            if (node instanceof DatePicker) {
                ((DatePicker) node).setValue(null);
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
            if (node instanceof DatePicker) {
                ((DatePicker) node).setDisable(!value);

            }
        }
    }
    private void populateTextFieldsWithData(RevenueTypes e) {
        if (e == null) return;
        
        revenueTypeIdTextField.setText(e.getRevenueTypeId().toString());
        buildingIdTextField.setText(e.getBuildingId().toString());
        nameTextField.setText(e.getName());
        typeTextField.setText(e.getType());
        
    }


    public void show() {
        stage.show();
        closeButton.setOnAction(
                a -> stage.close()
        );

    }
}
