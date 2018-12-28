package ru.mephi.bublechart.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project {
    int Projectid;
    List<Factor> factors = new ArrayList<Factor>();
    private String projectName;

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public Project() {

    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Factor> getFactors() {
        return factors;
    }

    public void setFactors(List<Factor> factors) {
        this.factors = factors;
    }

    public int addFactor(Factor factor) {
        for (Factor f : factors) {
            if (f.equals(factor)) {
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

    public int deleteFactor(String factorName) {
        for (Factor f : factors) {
            if (f.getFactorName().equals(factorName)) {
                factors.remove(f);
                return 0;
            }
        }
        return 1;
    }

    public int getProjectid() {
        return Projectid;
    }

    public void setProjectid(int projectid) {
        Projectid = projectid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Projectid == project.Projectid &&
                Objects.equals(factors, project.factors) &&
                Objects.equals(projectName, project.projectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Projectid, factors, projectName);
    }
}
