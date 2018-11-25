package ru.unn.agile.LcdDigits.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import ru.unn.agile.LcdDigits.model.LcdDigit;

import java.util.ArrayList;
import java.util.List;


public class ViewModel {
    private final StringProperty digits = new SimpleStringProperty();

    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();

    private final BooleanProperty transferringDisabled = new SimpleBooleanProperty();
    private final List<ValueChangeListener> valueChangedListeners = new ArrayList<>();

    public ViewModel() {
        digits.set("");

        result.set("");
        status.set(Status.WAITING.toString());

        bindingTransfer();
    }

    private void bindingTransfer() {
        BooleanBinding couldTransfer = new BooleanBinding() {
            {
                super.bind(digits);
            }

            @Override
            protected boolean computeValue() {
                return getInputStatus() == Status.READY;
            }
        };
        transferringDisabled.bind(couldTransfer.not());

        final List<StringProperty> fields = new ArrayList<StringProperty>() {
            {
                add(digits);
            }
        };
        additionListener(fields);
    }

    private void additionListener(final List<StringProperty> fields) {
        for (StringProperty field : fields) {
            final ValueChangeListener listener = new ValueChangeListener();
            field.addListener(listener);
            valueChangedListeners.add(listener);
        }
    }

    private Status getInputStatus() {
        Status inputStatus = Status.READY;
        if (digits.get().isEmpty()) {
            inputStatus = Status.WAITING;
        }
        try {
            if (!digits.get().isEmpty()) {
                Integer.parseInt(digits.get());
            }
        } catch (NumberFormatException nfe) {
            inputStatus = Status.BAD_FORMAT;
        }
        return inputStatus;
    }

    public void transformLcdDigits() {
        if (transferringDisabled.get()) {
            return;
        }
        int input = Integer.parseInt(digits.get());
        LcdDigit incomingNumber = new LcdDigit(input);

        result.set(incomingNumber.getLcd());
        status.set(Status.SUCCESS.toString());
    }

    public StringProperty digitsProperty() {
        return digits;
    }

    public StringProperty resultProperty() {
        return result;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public BooleanProperty transferringDisabledProperty() {
        return transferringDisabled;
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
    WAITING("Please enter a number"),
    READY("Press 'Transform'"),
    BAD_FORMAT("Wrong format"),
    SUCCESS("Success");

    private final String name;

    Status(final String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
