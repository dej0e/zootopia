package com.teamOne.cs631.controller;

import com.teamOne.cs631.models.Animal;
import com.teamOne.cs631.models.enums.UIMode;
import com.teamOne.cs631.service.AnimalService;
import com.teamOne.cs631.util.DateUtils;
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
@FxmlView("AnimalDialog.fxml")
public class AnimalDialogController {
    private UIMode uiMode;
    private Stage stage;
    @FXML
    private VBox vBox;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    public Button closeButton;

    @FXML
    public TextField idTextField;
    @FXML
    public TextField buildingIdTextField;
    @FXML
    public TextField speciesIdTextField;
    @FXML
    public TextField statusTextField;
    @FXML
    public TextField birthYearTextField;
    @FXML
    public DatePicker birthYearDatePicker;
    @FXML
    public TextField enclosureIdTextField;

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
    AnimalService service;
    private Animal selectedAnimal;

    @FXML
    public ToggleGroup group;

    public TableView<Animal> tableView;

    @Autowired
    public AnimalDialogController(AnimalService service) {
        this.service = service;
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

        tableView = ModelTableViewBuilder.buildUpon(Animal.class);
        vBox.getChildren().add(0, tableView);

        loadDataIntoTable();
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedAnimal = newSelection;
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

                            if (selectedAnimal != null)
                                populateTextFieldsWithData(selectedAnimal);
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
                        Animal e = collectValues();
                        changedCount = service.update(e);
                        break;
                    case INSERT:
                        Animal e1 = collectValues();
                        changedCount = service.insert(e1);
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
        ObservableList<Animal> data = FXCollections.observableArrayList(service.findAll());
        tableView.setItems(data);
    }

    private Animal collectValues() {
        Animal a = new Animal();
        a.id = Integer.valueOf(idTextField.getText());
        a.buildingId = Integer.valueOf(buildingIdTextField.getText());
        a.speciesId = Integer.valueOf(speciesIdTextField.getText());
        a.status = statusTextField.getText();

        a.birthYear = DateUtils.getDate(birthYearDatePicker.getValue());
        a.enclosureId = Integer.valueOf(enclosureIdTextField.getText());
        return a;
    }

    public void updateRadioBtnClicked() {
        System.out.println("Update RadioBtn Clicked");
        populateTextFieldsWithData(selectedAnimal);
        editable(true);
        uiMode = UIMode.UPDATE;
        submitBtn.setDisable(false);
    }

    public void resetTextFields() {
        for (Node node : anchorPane.getChildren()) {
            if (node instanceof TextField) {
                ((TextField) node).setText("");
            }
            if(node instanceof DatePicker) {
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
            if(node instanceof DatePicker) {
                ((DatePicker) node).setEditable(value);
            }
        }
    }

    private void populateTextFieldsWithData(Animal e) {
        if (e == null) return;
        if (e.getId() != null)
            idTextField.setText(e.getId().toString());
        if (e.getBuildingId() != null)
            buildingIdTextField.setText(String.valueOf(e.getBuildingId()));
        if (e.getSpeciesId() != null)
            speciesIdTextField.setText(String.valueOf(e.getSpeciesId()));
        if (e.getStatus() != null)
            statusTextField.setText(e.getStatus());
        if (e.getBirthYear() != null)
            birthYearDatePicker.setValue(DateUtils.getLocalDate(e.getBirthYear()));

//        birthYearDatePicker.set
//        birthYearTextField.setText(String.valueOf(e.getBirthYear()));
        if (e.getEnclosureId() != null)
            enclosureIdTextField.setText(String.valueOf(e.getEnclosureId()));
    }

    private void clearValuesFromTextFields() {
        idTextField.setText("");
        buildingIdTextField.setText("");
        speciesIdTextField.setText("");
        statusTextField.setText("");
        birthYearTextField.setText("");
        birthYearDatePicker.setValue(null);
        enclosureIdTextField.setText("");
    }

    public void show() {
        stage.show();
        closeButton.setOnAction(
                a -> stage.close()
        );

    }
}
