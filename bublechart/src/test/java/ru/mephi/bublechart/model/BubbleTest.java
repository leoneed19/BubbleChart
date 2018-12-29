package ru.mephi.bublechart.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleTest {


    @Test
    public void getBubbleNumber() {
        Project project = new Project ("projectName");
        Bubble bubble1 = new Bubble();
        Bubble bubble = new Bubble(1, "bubbleName", project);
        assertEquals(1, bubble.getBubbleNumber());
    }

    @Test
    public void setBubbleNumber() {
        Project project = new Project ("projectName");
        Bubble bubble = new Bubble(1, "bubbleName", project);
        bubble.setBubbleNumber(2);
        assertEquals(2, bubble.getBubbleNumber());
    }

    @Test
    public void getBubbleName() {
        Project project = new Project ("projectName");
        Bubble bubble = new Bubble(1, "bubbleName", project);
        assertEquals("bubbleName", bubble.getBubbleName());
    }

    @Test
    public void setBubbleName() {
        Project project = new Project ("projectName");
        Bubble bubble = new Bubble(1, "bubbleName", project);
        bubble.setBubbleName("bubbleName_2");
        assertEquals("bubbleName_2", bubble.getBubbleName());
    }

    @Test
    public void changeAttribute() {
        Type type1 = new Type ("typeName");
        Type type2 = new Type ("typeName2");
        Factor factor = new Factor("factorName", type1);
        Factor factor2 = new Factor("factorName", type2);
        Project project = new Project ("projectName");
        Bubble bubble = new Bubble(1, "bubbleName", project);
        bubble.addAttribute("attributeName", type1, 111, factor);
        assertEquals(0, bubble.changeAttribute("attributeName", factor2));
        assertEquals(1, bubble.changeAttribute("bad_name", factor2));
    }

    @Test
    public void addAttribute() {
        Type type1 = new Type ("typeName");
        Type type2 = new Type ("typeName2");
        Factor factor = new Factor("factorName", type1);
        Factor factor2 = new Factor("factorName", type2);
        Project project = new Project ("projectName");
        Bubble bubble = new Bubble(1, "bubbleName", project);
        bubble.addAttribute("attributeName", type1, 111,  factor);
        assertEquals(1,bubble.addAttribute("attributeName", type1, 111,  factor));
        assertEquals(0,bubble.addAttribute("attributeName2", type1, 111, factor2));
    }

    @Test
    public void delAttribute() {
        Type type1 = new Type ("typeName");
        Type type2 = new Type ("typeName2");
        Factor factor = new Factor("factorName", type1);
        Factor factor2 = new Factor("factorName", type2);
        Project project = new Project ("projectName");
        Bubble bubble = new Bubble(1, "bubbleName", project);
        bubble.addAttribute("attributeName", type1, 111, factor);
        assertEquals(0, bubble.delAttribute(factor));
        assertEquals(1, bubble.delAttribute(factor2));
    }

    @Test
    public void delAttribute1() {
        Type type1 = new Type ("typeName");
        Type type2 = new Type ("typeName2");
        Factor factor = new Factor("factorName", type1);
        Factor factor2 = new Factor("factorName", type2);
        Project project = new Project ("projectName");
        Bubble bubble = new Bubble(1, "bubbleName", project);
        Bubble bubble2 = new Bubble(1, "bubbleName", project);
        bubble.addAttribute("attributeName", type1, 111, factor);
        assertEquals(0, bubble.delAttribute("attributeName"));
        assertEquals(1, bubble.delAttribute("bad_attributeName"));
        assertEquals(1, bubble2.delAttribute("bad_attributeName"));
    }

    @Test
    void getBubbleAttributes() {
        List<BubbleAttribute> bubbleAttributes= new ArrayList<>();
        Bubble bubble = new Bubble();
        bubble.setBubbleAttributes(bubbleAttributes);
        assertEquals(bubbleAttributes, bubble.getBubbleAttributes());
    }

    @Test
    void setBubbleAttributes() {
        List<BubbleAttribute> bubbleAttributes= new ArrayList<>();
        Bubble bubble = new Bubble();
        bubble.setBubbleAttributes(bubbleAttributes);
        assertEquals(bubbleAttributes, bubble.getBubbleAttributes());
    }

    @Test
    void equals() {
        Bubble bubble1 = new Bubble();
        Bubble bubble2 = new Bubble();
        Bubble bubble3 = new Bubble();
        bubble1.setBubbleName("name");
        bubble2.setBubbleName("name");
        bubble3.setBubbleName("name3");
        Project project = new Project();
        assertTrue(bubble1.equals(bubble2));
        assertFalse(bubble1.equals(bubble3));
        assertFalse(bubble1.equals(project));
        assertTrue(bubble1.equals(bubble1));
    }

    @Test
    void getProject() {
        Project project = new Project();
        Bubble bubble = new Bubble();
        bubble.setProject(project);
        assertEquals(project, bubble.getProject());
    }

    @Test
    void setProject() {
        Project project = new Project();
        Bubble bubble = new Bubble();
        bubble.setProject(project);
        assertEquals(project, bubble.getProject());
    }


    @Test
    void BubbleTest() {
        Project project = new Project();
        Factor factor1 = new Factor();
        factor1.setFactorValue(1);
        Factor factor2 = new Factor();
        factor2.setFactorValue(2);
        List<Factor> factorList = new ArrayList<>();
        factorList.add(factor1);
        factorList.add(factor2);
        project.setFactors(factorList);
        Bubble bubble = new Bubble(1, "name", project);
        assertEquals(project, bubble.getProject());
    }
}
