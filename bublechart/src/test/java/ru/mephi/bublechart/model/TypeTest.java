package ru.mephi.bublechart.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TypeTest {


    @Test
    public void gettypeName() {
        Type type1 = new Type ("typeName");
        assertEquals("typeName", type1.gettypeName());
    }

    @Test
    public void settypeName() {
        Type type1 = new Type ("typeName");
        type1.settypeName("typeName_2");
        assertEquals("typeName_2", type1.gettypeName());
    }

    @Test
    public void addFactor() {
        List<Factor> factors = new ArrayList<Factor>();
        Type type1 = new Type ("typeName");
        Factor f1 = new Factor("factorname_1", type1);
        factors.add(f1);
        type1.settypeName("typeName_2");
        type1.addFactor("factorname_1", type1);
        assertEquals(f1.getFactorName(), type1.getFactor("factorname_1").getFactorName());
        assertEquals(f1.getFactorType(), type1.getFactor("factorname_1").getFactorType());
        //assertEquals(f1.getFactorValue(), type1.getFactor("factorname_1").getFactorValue());
    }

    @Test
    public void addFactor1() {
        List<Factor> factors = new ArrayList<Factor>();
        Type type1 = new Type ("typeName");
        Factor f1 = new Factor("factorname_1", type1,11);
        type1.settypeName("typeName_2");
        type1.addFactor("factorname_1", type1, 11);
        assertEquals(f1.getFactorName(), type1.getFactor("factorname_1").getFactorName());
        assertEquals(f1.getFactorType(), type1.getFactor("factorname_1").getFactorType());
        assertEquals(f1.getFactorValue(), type1.getFactor("factorname_1").getFactorValue());
    }

    @Test
    public void getFactor() {
        List<Factor> factors = new ArrayList<Factor>();
        Type type1 = new Type ("typeName");
        Factor f1 = new Factor("factorname_1", type1, 10);
        factors.add(f1);
        type1.settypeName("typeName_2");
        // Проверка нуля
        assertNull(type1.getFactor("ewfewfreg"));
        type1.addFactor("factorname_1", type1, 10);
        assertEquals(f1.getFactorName(), type1.getFactor("factorname_1").getFactorName());
        assertEquals(f1.getFactorType(), type1.getFactor("factorname_1").getFactorType());
        assertEquals(f1.getFactorValue(), type1.getFactor("factorname_1").getFactorValue());
        // assertEquals(f1, type1.getFactor("factorname_1"));
    }
}
