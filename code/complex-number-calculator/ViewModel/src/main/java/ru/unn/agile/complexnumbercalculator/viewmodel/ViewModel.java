package ru.unn.agile.complexnumbercalculator.viewmodel;

import ru.unn.agile.complexnumbercalculator.model.ComplexNumber;
import ru.unn.agile.complexnumbercalculator.model.ComplexNumberCalculator;

public class ViewModel {
    private Operations operations;
    private String result;
    private String firstRe;
    private String firstIm;
    private String secondRe;
    private String secondIm;
    private String degree;
    private String errorText;

    private boolean isCalculateButtonEnabled;
    private boolean isDegreeVisible;

    private int ENTER = 10;
    private int ANY = 000000;

    public enum Operations {
        ADD ("Сложить"),
        SUBTRACT ("Вычесть"),
        MULTIPLY ("Умножить"),
        DIVIDE ("Разделить"),
        POW ("Возвести в степень"),
        ROOT ("Извлечь корень"),
        CONJUGATION("Найти сопряженное");
        private final String name;

        Operations(final String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

    public ViewModel(){
        result = "";
        firstRe = "";
        firstIm = "";
        secondRe = "";
        secondIm = "";
        degree = "";
        operations = operations.ADD;
        errorText = "";
        isCalculateButtonEnabled = false;
        isDegreeVisible = false;
    }

    public String getResult(){
        return result;
    }

    public String getFirstRe(){
        return firstRe;
    }

    public String getFirstIm(){
        return firstIm;
    }

    public String getSecondRe(){
        return secondRe;
    }

    public String getSecondIm(){
        return secondIm;
    }

    public String getDegree(){
        return degree;
    }

    public Operations getOperations() {
        return operations;
    }

    public String getError(){
        return errorText;
    }

    public boolean isCalculateButtonEnabled() {
        return isCalculateButtonEnabled;
    }

    public void setFirstRe(String firstRe){
        this.firstRe = firstRe;
    }

    public void setFirstIm(String firstIm){

        this.firstIm = firstIm;
    }

    public void setSecondRe(String secondRe){
        this.secondRe = secondRe;
    }

    public void setSecondIm(String secondIm){
        this.secondIm = secondIm;
    }

    private boolean isAllDataFilled (){
        return (!getFirstRe().isEmpty() && !getFirstIm().isEmpty() && !getSecondRe().isEmpty() && !getSecondIm().isEmpty());
    }

    public void processTextFieldFilling(final int keyCode) {
        if (isAllDataFilled()){
            isCalculateButtonEnabled = true;
        }
        if (keyCode == ENTER) {
            calculate();
        }
    }

    public void calculate(){
        processTextFieldFilling(ANY);
        if (isCalculateButtonEnabled()){
            ComplexNumber z1 = ComplexNumber.createAlgebraicForm(Double.parseDouble(getFirstRe()), Double.parseDouble(getFirstIm()));
            ComplexNumber z2 = ComplexNumber.createAlgebraicForm(Double.parseDouble(getSecondRe()), Double.parseDouble(getSecondIm()));
            result = ComplexNumberCalculator.add(z1,z2).toString();
        }
    }

    public boolean isDegreeVisible() {
        return isDegreeVisible;
    }
}
