package ru.unn.agile.shape3darea.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import ru.unn.agile.shape3darea.model.ShapeType;
import ru.unn.agile.shape3darea.viewmodel.ViewModel;

public class AreaCalculator {
    @FXML
    private ViewModel viewModel;
    @FXML
    private ComboBox<ShapeType> cbSelectedShape;
    @FXML
    private TableView tvParameters;
    @FXML
    private Button btnCalc;
    @FXML
    private Label lbResult;

    @FXML
    void initialize() {
        cbSelectedShape.valueProperty().bindBidirectional(viewModel.selectedShapeProperty());

        btnCalc.setOnAction(event -> viewModel.calculate());
    }
}
