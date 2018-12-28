package ru.mephi.bublechart.model;

public class Factor {
    private String factorName;
    @Deprecated
    private Type factorType;
    private float factorValue;

    public Factor(String factorName, Type factorType) {
        this.factorName = factorName;
        this.factorType = factorType;
    }

    public Factor(String factorName, Type factorType, float factorValue) {
        this.factorName = factorName;
        this.factorType = factorType;
        this.factorValue = factorValue;
    }

    public Factor() {

    }

    public Factor(float value) {
        this.factorValue = value;
    }

    public Factor(String name, float value) {
        this.factorValue = value;
        this.factorName = name;
    }

    public String getFactorName() {
        return factorName;
    }

    public void setFactorName(String factorName) {
        this.factorName = factorName;
    }

    public Type getFactorType() {
        return factorType;
    }

    public void setFactorType(Type factorType) {
        this.factorType = factorType;
    }

    public float getFactorValue() {
        return factorValue;
    }

    public void setFactorValue(float factorValue) {
        this.factorValue = factorValue;
    }
}
