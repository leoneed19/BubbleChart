package ru.mephi.bublechart.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorTest {


    @Test
    public void getFactorName() {
        Factor factor1 = new Factor();
        Factor factor2 = new Factor(111);
        Factor factor3 = new Factor("name", 111);
        Type type1 = new Type ("typeName");
        Factor f1 = new Factor("factorname_1", type1);
        assertEquals("factorname_1", f1.getFactorName());
    }

    @Test
    public void setFactorName() {
        Type type1 = new Type ("typeName");
        Factor f1 = new Factor("factorname_1", type1);
        f1.setFactorName("factorname_2");
        assertEquals("factorname_2", f1.getFactorName());

    }

    @Test
    public void getFactorType() {
        Type type1 = new Type ("typeName");
        Factor f1 = new Factor("factorname_1", type1);
        assertEquals(type1, f1.getFactorType());

    }

    @Test
    public void setFactorType() {
        Type type1 = new Type ("typeName");
        Factor f1 = new Factor("factorname_1", type1);
        f1.setFactorType(type1);
        assertEquals(type1, f1.getFactorType());

    }

    @Test
    public void getFactorValue() {
        Type type1 = new Type ("typeName");
        Factor f1 = new Factor("factorname_1", type1, 11);
        assertEquals(11, f1.getFactorValue());

    }

    @Test
    public void setFactorValue() {
        Type type1 = new Type ("typeName");
        Factor f1 = new Factor("factorname_1", type1, 10);
        f1.setFactorValue(12);
        assertEquals(12, f1.getFactorValue());

    }
}
