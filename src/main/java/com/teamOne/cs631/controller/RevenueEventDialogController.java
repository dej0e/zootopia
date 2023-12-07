package com.teamOne.cs631.controller;

import com.teamOne.cs631.models.RevenueEvents;

import com.teamOne.cs631.models.enums.UIMode;
import com.teamOne.cs631.service.RevenueTypeService;

import com.teamOne.cs631.util.DateUtils;
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

import java.sql.Date;

@Component
@FxmlView("RevenueEventsDialog.fxml")
public class RevenueEventDialogController {
    private UIMode uiMode;
    private Stage stage;
    @FXML
    private VBox vBox;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    public DatePicker dateTimeTextField;

    @FXML
    public TextField ticketsSoldTextField;
    @FXML
    public TextField revenueTextField;

    @FXML
    public Button closeButton;

    @FXML
    public TextField revenueTypeIdTextField;


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

    private RevenueEvents selectedRow;

    @FXML
    public ToggleGroup group;

    public TableView<RevenueEvents> tableView;

    private final FxWeaver fxWeaver;

    @Autowired
    public RevenueEventDialogController(FxWeaver fxWeaver, RevenueTypeService revenueTypeService) {
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
        tableView = ModelTableViewBuilder.buildUpon(RevenueEvents.class);
        vBox.getChildren().add(0, tableView);

        loadDataIntoTable();
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedRow = newSelection;
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

        group.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {

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
                        loadDataIntoTable();
                        if (selectedRow != null)
                            populateTextFieldsWithData(selectedRow);
                        break;

                    case INSERT:
                        resetTextFields();
                        editable(true);
                        submitBtn.setDisable(false);
                        uiMode = UIMode.INSERT;
                        break;
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
                        RevenueEvents u1 = collectRevenueEventsValues();
                        changedCount = revenueTypeService.updateRevenueEvents(u1);

                        break;
                    case INSERT:
                        RevenueEvents i1 = collectRevenueEventsValues();
                        changedCount = revenueTypeService.insertRevenueEvents(i1);

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
        ObservableList<RevenueEvents> data = FXCollections.observableArrayList(revenueTypeService.findAllRevenueEvents());
        tableView.setItems(data);
    }


    private RevenueEvents collectRevenueEventsValues() {
        RevenueEvents revenueEvents = new RevenueEvents();
        //datetime
        revenueEvents.setDateTime(Date.valueOf(dateTimeTextField.getValue()));
        revenueEvents.setRevenueId(Integer.valueOf(revenueTypeIdTextField.getText()));
        revenueEvents.setTicketsSold(Double.valueOf(ticketsSoldTextField.getText()));
        revenueEvents.setRevenue(Double.valueOf(revenueTextField.getText()));

        return revenueEvents;


    }

    public void updateRadioBtnClicked() {
        System.out.println("Update RadioBtn Clicked");
        populateTextFieldsWithData(selectedRow);
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

    private void populateTextFieldsWithData(RevenueEvents e) {
        if (e == null) return;

        revenueTypeIdTextField.setText(e.getRevenueId().toString());
        dateTimeTextField.setValue(DateUtils.getLocalDate(e.getDateTime()));
        ticketsSoldTextField.setText(e.getTicketsSold().toString());
        revenueTextField.setText(e.getRevenue().toString());

    }


    public void show() {
        stage.show();
        closeButton.setOnAction(
                a -> stage.close()
        );

    }
}
