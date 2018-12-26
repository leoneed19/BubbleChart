package ru.mephi.bublechart.model;

import java.util.ArrayList;
import java.util.List;

public class Type {
    private String typeName;
    List<Factor> factors = new ArrayList<Factor>();

    public String gettypeName() {
        return typeName;
    }

    public void settypeName(String typeName) {
        this.typeName = typeName;
    }

    public Type(String typeName) {
        this.typeName = typeName;
    }

    public void addFactor(String factorName, Type type){
        Factor f1 = new Factor(factorName, type);
        this.factors.add(f1);
    }

    public void addFactor(String factorName, Type type, float value){
        Factor f1 = new Factor(factorName, type, value);
        this.factors.add(f1);
    }
    public Factor getFactor(String factorName) {
        for (Factor f : factors) {
            if (f.getFactorName().equals(factorName))
                return f;
        }
        return null;
    }

}
