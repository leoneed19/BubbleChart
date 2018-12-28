package ru.mephi.bublechart.model;

import java.util.ArrayList;
import java.util.List;

public class Bubble {

    private List<BubbleAttribute> bubbleAttributes = new ArrayList<BubbleAttribute>();
    private Project project;
    private int bubbleNumber;
    private String BubbleName;

    public Bubble() {
    }

    public Bubble(int bubbleNumber, String bubbleName, Project project) {
        List<BubbleAttribute> bubbleAttributes = new ArrayList<BubbleAttribute>();
        this.bubbleNumber = bubbleNumber;
        this.BubbleName = bubbleName;
        this.project = project;
        for (Factor factor : project.getFactors()) {
            addAttribute(factor.getFactorName(), factor.getFactorType(), factor.getFactorValue(), factor);
        }
    }

    public List<BubbleAttribute> getBubbleAttributes() {
        return bubbleAttributes;
    }

    public void setBubbleAttributes(List<BubbleAttribute> bubbleAttributes) {
        this.bubbleAttributes = bubbleAttributes;
    }

    public int getBubbleNumber() {
        return bubbleNumber;
    }

    public void setBubbleNumber(int bubbleNumber) {
        this.bubbleNumber = bubbleNumber;
    }

    public String getBubbleName() {
        return BubbleName;
    }

    public void setBubbleName(String bubbleName) {
        BubbleName = bubbleName;
    }

    public int changeAttribute(String attributeName, Factor factor) {
        for (BubbleAttribute a : bubbleAttributes) {
            if (a.getAttributeName().equals(attributeName)) {
                a.factor = factor;
                return 0;
            }
        }
        return 1;
    }

    public int addAttribute(String attributeName, Type attributeType, float attributeValue, Factor factor) {
        for (BubbleAttribute a : bubbleAttributes) {
            if (a.factor.equals(factor)) {
                return 1;
            }
        }
        BubbleAttribute a1 = new BubbleAttribute(attributeName, attributeType, attributeValue, factor);
        bubbleAttributes.add(a1);
        return 0;
    }

    public int delAttribute(Factor factor) {
        for (BubbleAttribute a : bubbleAttributes) {
            if (a.factor.equals(factor)) {
                bubbleAttributes.remove(a);
                return 0;
            }
        }
        return 1;
    }

    public int delAttribute(String attributeName) {
        for (BubbleAttribute a : bubbleAttributes) {
            if (a.getAttributeName().equals(attributeName)) {
                bubbleAttributes.remove(a);
                return 0;
            }
        }
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bubble)) {
            return false;
        }
        Bubble bb = (Bubble) obj;
        if (bb.getBubbleName().equals(this.getBubbleName()) && bb.getBubbleNumber() == this.getBubbleNumber())
            return true;
        else
            return false;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
