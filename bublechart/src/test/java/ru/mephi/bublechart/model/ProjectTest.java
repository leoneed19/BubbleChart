package ru.mephi.bublechart.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectTest {

    @Test
    public void getProjectName() {
        Project project1 = new Project ("projectName");
        assertEquals("projectName", project1.getProjectName());
    }

    @Test
    public void setProjectName() {
        Project project1 = new Project ("projectName");
        project1.setProjectName("projectName_2");
        assertEquals("projectName_2", project1.getProjectName());
    }

    @Test
    public void getFactors() {
        Type type1 = new Type ("typeName");
        Type type2 = new Type ("typeName2");
        Factor f1 = new Factor("name", type1);
        Factor f2 = new Factor("name", type2);
        List<Factor> factors = new ArrayList<Factor>();
        factors.add(f1);
        factors.add(f2);
        Project project1 = new Project ("projectName");
        project1.addFactor(f1);
        project1.addFactor(f2);
        assertEquals(factors, project1.getFactors());
    }

    @Test
    public void addFactor() {
        Type type1 = new Type ("typeName");
        Type type2 = new Type ("typeName2");
        Factor f1 = new Factor("name", type1);
        Factor f2 = new Factor("name", type2);
        List<Factor> factors = new ArrayList<Factor>();
        factors.add(f1);
        factors.add(f2);
        Project project1 = new Project ("projectName");
        assertEquals(0,project1.addFactor(f1));
        assertEquals(0,project1.addFactor(f2));
        assertEquals(1,project1.addFactor(f2));
        assertEquals(factors, project1.getFactors());
    }

    @Test
    public void editFactor() {
        Type type1 = new Type ("typeName");
        Type type2 = new Type ("typeName2");
        Factor f1 = new Factor("name", type1, 100);
        Factor f2 = new Factor("name", type2, 111);
        Factor f3 = new Factor("new_name", type2, 222);
        Project project1 = new Project ("projectName");
        project1.addFactor(f1);
        assertEquals(0, project1.editFactor(f2));
        assertEquals(1, project1.editFactor(f3));
    }

    @Test
    public void deleteFactor() {
        Type type1 = new Type ("typeName1");
        //Type type2 = new Type ("typeName2");
        Factor f1 = new Factor("name1", type1, 100);
        //Factor f2 = new Factor("name2", type2, 111);
        Project project1 = new Project ("projectName");
        project1.addFactor(f1);
        assertEquals(0, project1.deleteFactor("name1"));
        project1.addFactor(f1);
        assertEquals(1, project1.deleteFactor("name2"));
    }
}
