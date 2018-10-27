package ru.unn.agile.stringcalculator.model;

import org.junit.Test;
import ru.unn.agile.stringcalculator.model.errorhandling.StringCalculatorException;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    @Test
    public void canReturnZeroForEmptyString() {
        int sum = StringCalculator.add("");

        assertEquals(0, sum);
    }

    @Test
    public void canAddSingleNumber() {
        int sum = StringCalculator.add("1");

        assertEquals(1, sum);
    }

    @Test
    public void canAddTwoNumbers() {
        int sum = StringCalculator.add("1,2");

        assertEquals(3, sum);
    }

    @Test
    public void canAddThreeNumbers() {
        int sum = StringCalculator.add("1,2,3");

        assertEquals(6, sum);
    }

    @Test
    public void canAddNewLineSeparatedNumbers() {
        int sum = StringCalculator.add("1\n2");

        assertEquals(3, sum);
    }

    @Test
    public void canAddThreeNewLineSeparatedNumbers() {
        int sum = StringCalculator.add("1\n2\n3");

        assertEquals(6, sum);
    }

    @Test
    public void canAddNumbersWithDifferentDelimiters() {
        int sum = StringCalculator.add("1,2\n3");

        assertEquals(6, sum);
    }

    @Test
    public void canAddNumbersWithTrailingDelimiterAtTheEnd() {
        int sum = StringCalculator.add("1,2,");

        assertEquals(3, sum);
    }

    @Test
    public void canAddNumbersWithTrailingNewLineAtTheEnd() {
        int sum = StringCalculator.add("1,2\n");

        assertEquals(3, sum);
    }

    @Test
    public void canAddNumberWithCustomDelimiter() {
        int sum = StringCalculator.add(";\n1");

        assertEquals(1, sum);
    }

    @Test
    public void canAddTwoNumbersWithCustomDelimiter() {
        int sum = StringCalculator.add(";\n1;2");

        assertEquals(3, sum);
    }


    @Test
    public void canAddNumbersWithCustomDelimiterAndNewLines() {
        int sum = StringCalculator.add(";\n1;2\n3");

        assertEquals(6, sum);
    }

    @Test(expected = StringCalculatorException.class)
    public void canRaiseExceptionWhenGonNegativeNumber() {
        StringCalculator.add("-1");
    }
}
