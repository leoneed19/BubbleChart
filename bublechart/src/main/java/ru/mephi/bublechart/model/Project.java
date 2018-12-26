package ru.mephi.bublechart.model;

import java.util.ArrayList;
import java.util.List;

public class Project {
    int Projectid;
    private String projectName;
    List<Factor> factors = new ArrayList<Factor>();

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Factor> getFactors() {
        return factors;
    }

    public int addFactor(Factor factor){
        for (Factor f: factors) {
            if (f.equals(factor)){
                return 1;
            }
        }
        factors.add(factor);
        return 0;
    }

    public int editFactor(Factor factor) {
        for (Factor f : factors) {
            if (f.getFactorName().equals(factor.getFactorName())) {
                //f.setFactorName(factor.getFactorName());
                f.setFactorType(factor.getFactorType());
                f.setFactorValue(factor.getFactorValue());
                return 0;
            }
        }
        return 1;
    }

    public Project(String projectName){
        this.projectName = projectName;
    }

    public int deleteFactor(String factorName) {
        for (Factor f: factors) {
            if (f.getFactorName().equals(factorName)) {
                factors.remove(f);
                return 0;
            }
        }
        return 1;
    }

}
