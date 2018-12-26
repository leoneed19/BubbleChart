package ru.mephi.bublechart.model;

public class BubbleAttribute {
    private String attributeName;
    private Type attributeType;
    private double attributeValue;
    Factor factor;

    public BubbleAttribute() {}

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public Type getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(Type attributeType) {
        this.attributeType = attributeType;
    }

    public double getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(double attributeValue) {
        this.attributeValue = attributeValue;
    }

    public BubbleAttribute(String attributeName, Type attributeType, double attributeValue, Factor factor) {
        this.attributeName = attributeName;
        this.attributeType = attributeType;
        this.attributeValue = attributeValue;
        this.factor = factor;
    }
}