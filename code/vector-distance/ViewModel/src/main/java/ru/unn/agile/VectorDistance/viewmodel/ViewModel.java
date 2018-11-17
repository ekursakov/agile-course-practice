package ru.unn.agile.VectorDistance.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import ru.unn.agile.VectorDistance.model.FloatVector;
import ru.unn.agile.VectorDistance.model.VectorDistance;
import ru.unn.agile.VectorDistance.model.VectorDistance.Distance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewModel {
    private static final String DEFAULT_DELIMITER = " ";
    private static final String VALID_VECTOR_PATTERN = "^(-?[0-9]\\s?)+$";
    private final StringProperty vectorX = new SimpleStringProperty();
    private final StringProperty vectorY = new SimpleStringProperty();
    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private final ObjectProperty<ObservableList<Distance>> distances =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(Distance.values()));
    private final BooleanProperty calculationDisabled = new SimpleBooleanProperty();

    public final ObservableList<Distance> getDistances() {
        return distances.get();
    }

    private final ObjectProperty<Distance> distance = new SimpleObjectProperty<>();

    private final List<ValueChangeListener> valueChangedListeners = new ArrayList<>();

    public ViewModel() {
        vectorX.set("");
        vectorY.set("");
        result.set("");
        status.set(Status.WAITING.toString());
        distance.set(Distance.L1);
        BooleanBinding couldCalculate = new BooleanBinding() {
            {
                super.bind(vectorX, vectorY);
            }
            @Override
            protected boolean computeValue() {
                return getInputStatus() == Status.READY;
            }
        };
        calculationDisabled.bind(couldCalculate.not());
        // Add listeners to the input text fields
        final List<StringProperty> fields = new ArrayList<StringProperty>() { {
            add(vectorX);
            add(vectorY);
        } };

        for (StringProperty field : fields) {
            final ValueChangeListener listener = new ValueChangeListener();
            field.addListener(listener);
            valueChangedListeners.add(listener);
        }
    }

    public void calculate() {

        FloatVector a = getVectorFromInputString(vectorX.get());
        FloatVector b = getVectorFromInputString(vectorY.get());
        result.set(String.valueOf(distance.get().apply(a, b)));
        status.set(Status.SUCCESS.toString());
    }

    public ObjectProperty<Distance> distanceProperty() {
        return distance;
    }

    public StringProperty vectorXProperty() {
        return vectorX;
    }
    public StringProperty vectorYProperty() {
        return vectorY;
    }

    public StringProperty resultProperty() {
        return result;
    }
    public final String getResult() {
        return result.get();
    }
    public StringProperty statusProperty() {
        return status;
    }
    public final String getStatus() {
        return status.get();
    }
    public BooleanProperty calculationDisabledProperty() {
        return calculationDisabled;
    }
    public final boolean isCalculationDisabled() {
        return calculationDisabled.get();
    }


    private static List<String> getNumbersArrayFromString(final String numbersString) {
        return Arrays.asList(numbersString.split(DEFAULT_DELIMITER));
    }

    private float[] getFloatArrayFromStringList(final List<String> stringList) {
        float[] floatArray = new float[stringList.size()];

        int i = 0;

        for (String number : stringList) {
            floatArray[i++] = Float.parseFloat(number);
        }
        return floatArray;
    }

    private FloatVector getVectorFromInputString(final String inputString) {
        List<String> singleNumbers = getNumbersArrayFromString(inputString);
        return new FloatVector(getFloatArrayFromStringList(singleNumbers));
    }

    private boolean checkInputIsValid(final String vectorInput) {
        return vectorInput.matches(VALID_VECTOR_PATTERN);
    }

    private Status getInputStatus() {
        Status inputStatus = Status.READY;
        if (vectorX.get().isEmpty() || vectorY.get().isEmpty()) {
            inputStatus = Status.WAITING;
        }
        if (!checkInputIsValid(vectorX.get()) || !checkInputIsValid(vectorY.get())) {
            inputStatus = Status.BAD_FORMAT;
        }

        return inputStatus;
    }

    private class ValueChangeListener implements ChangeListener<String> {
        @Override
        public void changed(final ObservableValue<? extends String> observable,
                            final String oldValue, final String newValue) {
            status.set(getInputStatus().toString());
        }
    }
}

enum Status {
    WAITING("Please provide input data"),
    READY("Press 'Calculate' or Enter"),
    BAD_FORMAT("Bad format"),
    SUCCESS("Success");

    private final String name;
    Status(final String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}
