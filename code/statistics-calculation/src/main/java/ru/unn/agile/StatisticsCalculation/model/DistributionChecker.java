package ru.unn.agile.StatisticsCalculation.model;

public class DistributionChecker {
    public static void validate(final Number[] values,final Double[] probabilities) {
        checkArraysInitialization(values);
        checkArraysInitialization(probabilities);
        checkArraysSize(values, probabilities);
        checkProbability(probabilities);
        checkProbabilitySum(probabilities);
    }

    private static void checkArraysInitialization(final Number[] array){
        if (array == null) {
            throw new IllegalArgumentException("Array should be initialized!");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array should be initialized!");
        }
        for (int i = 0; i< array.length;i++){
            if (array[i] == null) throw new IllegalArgumentException("Array should be initialized!");
        }
    }

    private static void checkArraysSize(final Number[] values, final Double[] probabilities){
        if (values.length != probabilities.length) {
            throw new IllegalArgumentException("Values and probabilities arrays should have the same dimension!");
        }
    }

    private static void checkProbability(final Double[] probabilities){
        Double min = 0.0;
        Double max = 1.0;
        for (int i=0;i<probabilities.length;i++){
            if (probabilities[i]>max || probabilities[i]<min)
                throw new IllegalArgumentException("Probability should be more than 0.0 and less than 1.0!");
        }
    }

    private static void checkProbabilitySum(final Double[] probabilities){
        double sum = 0.0;
        final double expectedSum = 1.0;
        final double delta = 0.001;

        for (int i=0;i<probabilities.length;i++){
            sum += probabilities[i];
        }
        if (Math.abs(expectedSum - sum) > delta){
            throw new IllegalArgumentException("Probabilities sum should be equal 1.0!");
        }
    }
}
