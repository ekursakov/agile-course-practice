package ru.unn.agile.shape3darea.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import ru.unn.agile.shape3darea.model.ShapeType;
import ru.unn.agile.shape3darea.viewmodel.ViewModel;

public class AreaCalculator {
    @FXML
    private ViewModel viewModel;
    @FXML
    private ComboBox<ShapeType> cbSelectedShape;
    @FXML
    private Button btnCalc;

    @FXML
    void initialize() {
        cbSelectedShape.valueProperty().bindBidirectional(viewModel.selectedShapeProperty());

        btnCalc.setOnAction(event -> viewModel.calculate());
    }
}
