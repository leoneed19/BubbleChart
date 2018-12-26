package ru.mephi.bublechart.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleAttributeTest {

    @BeforeEach
    void initAll() {
        Type type1 = new Type ("typeName");
        Factor factor = new Factor("factorName", type1, 11);
        BubbleAttribute bubbleAttribute1 = new BubbleAttribute("attribute_name", type1, 10.0, factor);
    }

    @Test
    public void getAttributeName() {
        Type type1 = new Type ("typeName");
        Factor factor = new Factor("factorName", type1, 11);
        BubbleAttribute bubbleAttribute1 = new BubbleAttribute("attribute_name", type1, 10.0, factor);
        assertEquals("attribute_name", bubbleAttribute1.getAttributeName());
    }

    @Test
    public void setAttributeName() {
        Type type1 = new Type ("typeName");
        Factor factor = new Factor("factorName", type1, 11);
        BubbleAttribute bubbleAttribute1 = new BubbleAttribute("attribute_name", type1, 10.0, factor);
        bubbleAttribute1.setAttributeName("attribute_name_1");
        assertEquals("attribute_name_1", bubbleAttribute1.getAttributeName());
    }

    @Test
    public void getAttributeType() {
        Type type1 = new Type ("typeName");
        Factor factor = new Factor("factorName", type1, 11);
        BubbleAttribute bubbleAttribute1 = new BubbleAttribute("attribute_name", type1, 10.0,  factor);
        assertEquals(type1, bubbleAttribute1.getAttributeType());
    }

    @Test
    public void setAttributeType() {
        Type type1 = new Type ("typeName");
        Type type2 = new Type ("typeName2");
        Factor factor = new Factor("factorName", type1, 11);
        BubbleAttribute bubbleAttribute1 = new BubbleAttribute("attribute_name", type1, 10.0,  factor);
        bubbleAttribute1.setAttributeType(type2);
        assertEquals(type2, bubbleAttribute1.getAttributeType());
    }

    @Test
    public void getAttributeValue() {
        Type type1 = new Type ("typeName");
        Factor factor = new Factor("factorName", type1, 11);
        BubbleAttribute bubbleAttribute1 = new BubbleAttribute("attribute_name", type1, 10.0,  factor);
        assertEquals(10.0, bubbleAttribute1.getAttributeValue());
    }

    @Test
    public void setAttributeValue() {
        Type type1 = new Type ("typeName");
        Factor factor = new Factor("factorName", type1, 11);
        BubbleAttribute bubbleAttribute1 = new BubbleAttribute("attribute_name", type1, 10.0, factor);
        bubbleAttribute1.setAttributeValue(11.1);
        assertEquals(11.1, bubbleAttribute1.getAttributeValue());
    }
}
