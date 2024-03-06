package com.example.api;

public class ErrorData {
    private String inputRestriction;
    private int maxGrade;

    public ErrorData(String inputRestriction, int maxGrade) {
        this.inputRestriction = inputRestriction;
        this.maxGrade = maxGrade;
    }

    public String getInputRestriction() {
        return inputRestriction;
    }

    public int getMaxGrade() {
        return maxGrade;
    }
}