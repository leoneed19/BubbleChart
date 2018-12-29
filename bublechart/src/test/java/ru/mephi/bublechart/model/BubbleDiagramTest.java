package ru.mephi.bublechart.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleDiagramTest {

    @Test
    public void getNameOfBubbleDiagram() {
        BubbleDiagram bubbleDiagram = new BubbleDiagram("name_bubble_D");
        BubbleDiagram bubbleDiagram2 = new BubbleDiagram();
        assertEquals("name_bubble_D", bubbleDiagram.getNameOfBubbleDiagram());
    }

    @Test
    public void setNameOfBubbleDiagram() {
        BubbleDiagram bubbleDiagram = new BubbleDiagram("name_bubble_D");
        bubbleDiagram.setNameOfBubbleDiagram("new_name");
        assertEquals("new_name", bubbleDiagram.getNameOfBubbleDiagram());
    }

    @Test
    public void getTransparency() {
        BubbleDiagram bubbleDiagram = new BubbleDiagram("name_bubble_D");
        bubbleDiagram.setTransparency(11);
        assertEquals(11, bubbleDiagram.getTransparency());
    }

    @Test
    public void setTransparency() {
        BubbleDiagram bubbleDiagram = new BubbleDiagram("name_bubble_D");
        bubbleDiagram.setTransparency(10);
        assertEquals(10, bubbleDiagram.getTransparency());
    }

    @Test
    public void getxScale() {
        int[] a = {1,10};
        BubbleDiagram bubbleDiagram = new BubbleDiagram("name_bubble_D");
        bubbleDiagram.setxScale(a);
        assertEquals(a, bubbleDiagram.getxScale());
    }

    @Test
    public void setxScale() {
        int[] a = {1,10};
        BubbleDiagram bubbleDiagram = new BubbleDiagram("name_bubble_D");
        bubbleDiagram.setxScale(a);
        assertEquals(a, bubbleDiagram.getxScale());
    }

    @Test
    public void getyScale() {
        int[] a = {1,11};
        BubbleDiagram bubbleDiagram = new BubbleDiagram("name_bubble_D");
        bubbleDiagram.setyScale(a);
        assertEquals(a, bubbleDiagram.getyScale());
    }

    @Test
    public void setyScale() {
        int[] a = {1,11};
        BubbleDiagram bubbleDiagram = new BubbleDiagram("name_bubble_D");
        bubbleDiagram.setyScale(a);
        assertEquals(a, bubbleDiagram.getyScale());
    }

    @Test
    public void addProject() {
        Project project = new Project ("projectName");
        Project project2 = new Project ("projectName2");
        BubbleDiagram bubbleDiagram = new BubbleDiagram("name_bubble_D");
        bubbleDiagram.addProject(project);
        assertEquals(1,bubbleDiagram.addProject(project));
        assertEquals(0,bubbleDiagram.addProject(project2));
    }

    @Test
    public void addBubble() {
        Project project = new Project ("projectName");
        Project project2 = new Project ("projectName2");
        Project project3 = new Project ("projectName2");
        BubbleDiagram bubbleDiagram = new BubbleDiagram("name_bubble_D");
        Bubble b1 = new Bubble(1, "bubbleName", project);
        Bubble b2 = new Bubble(2, "bubbleName2", project2);
        Bubble b3 = new Bubble(3, "bubbleName3", project3);
        bubbleDiagram.addBubble(1, "bubbleName", project);
        //assertEquals(b1, bubbleDiagram.addBubble(3, "bubbleName2", project));
        assertNull(bubbleDiagram.addBubble(1, "bubbleName", project));


        assertEquals(b2.getBubbleNumber(), bubbleDiagram.addBubble(2, "bubbleName2", project2).getBubbleNumber());
        //assertEquals(b2.getBubbleName(), bubbleDiagram.addBubble(2, "bubbleName2", project2).getBubbleName());
        assertEquals(b3.getBubbleName(), bubbleDiagram.addBubble(3, "bubbleName3", project3).getBubbleName());

        //bubbleDiagram.addBubble(project, "bubbleName", 1);
        //assertEquals(0, bubbleDiagram.addBubble(project, "bubbleName2", 2));
    }

    @Test
    public void addFactorToProject() {
        Type type1 = new Type ("typeName");
        Type type2 = new Type ("typeName2");
        Type type3 = new Type ("typeName3");
        Type type4 = new Type ("typeName4");
        Type type5 = new Type ("typeName5");
        Type type6 = new Type ("typeName6");
        Type type7 = new Type ("typeName7");
        Type type8 = new Type ("typeName8");

        Factor factor = new Factor("factorname_1", type1);
        Factor factor2 = new Factor("factorname_2", type2);
        Factor factor3 = new Factor("factorname_3", type3);
        Factor factor4 = new Factor("factorname_4", type4);
        Factor factor5 = new Factor("factorname_5", type5);
        Factor factor6 = new Factor("factorname_6", type6);
        Factor factor7 = new Factor("factorname_7", type7);
        Factor factor8 = new Factor("factorname_8", type8);
        Factor factor9 = new Factor("factorname_8", type7);
        Project project = new Project ("projectName");
        Project project2 = new Project ("projectName2");

        BubbleDiagram bubbleDiagram = new BubbleDiagram("name_bubble_D");
        bubbleDiagram.addProject(project);
        assertEquals(0,bubbleDiagram.addFactorToProject("projectName", factor));
        assertEquals(0,bubbleDiagram.addFactorToProject("projectName", factor2));
        assertEquals(0,bubbleDiagram.addFactorToProject("projectName", factor3));
        assertEquals(0,bubbleDiagram.addFactorToProject("projectName", factor4));
        assertEquals(0,bubbleDiagram.addFactorToProject("projectName", factor5));
        assertEquals(0,bubbleDiagram.addFactorToProject("projectName", factor6));
        assertEquals(0,bubbleDiagram.addFactorToProject("projectName", factor7));
        assertEquals(1,bubbleDiagram.addFactorToProject("projectName", factor8));
        assertEquals(1,bubbleDiagram.addFactorToProject("projectName2", factor8));
        bubbleDiagram.addFactorToProject("projectName2", factor2);
        bubbleDiagram.addFactorToProject("projectName3", factor3);
        bubbleDiagram.addFactorToProject("projectName4", factor4);
        bubbleDiagram.addFactorToProject("projectName5", factor5);
        bubbleDiagram.addFactorToProject("projectName6", factor6);
        bubbleDiagram.addFactorToProject("projectName7", factor7);
        assertEquals(0,bubbleDiagram.addFactorToProject("projectName", factor9));
        assertEquals(1,bubbleDiagram.addFactorToProject("projectName", factor9));
        //assertEquals(1,bubbleDiagram.addFactorToProject("projectName", factor2));
    }

    @Test
    public void deleteProject() {
        Project project = new Project ("projectName");
        Project project2 = new Project ("projectName2");
        BubbleDiagram bubbleDiagram = new BubbleDiagram("name_bubble_D");
        bubbleDiagram.addProject(project);

        assertEquals(0, bubbleDiagram.deleteProject("projectName"));
        assertEquals(1, bubbleDiagram.deleteProject("eferreg"));
    }

    @Test
    public void deleteProject1() {
        Project project = new Project ("projectName");
        Project project2 = new Project ("projectName2");
        BubbleDiagram bubbleDiagram = new BubbleDiagram("name_bubble_D");
        bubbleDiagram.addProject(project);

        assertEquals(0, bubbleDiagram.deleteProject(project));
        assertEquals(1, bubbleDiagram.deleteProject(project2));
    }

    @Test
    void getBubbles() {
        List<Bubble> bubbles = new ArrayList<>();
        BubbleDiagram bubbleDiagram = new BubbleDiagram();
        bubbleDiagram.setBubbles(bubbles);
        assertEquals(bubbles, bubbleDiagram.getBubbles());
    }

    @Test
    void setBubbles() {
        List<Bubble> bubbles = new ArrayList<>();
        BubbleDiagram bubbleDiagram = new BubbleDiagram();
        bubbleDiagram.setBubbles(bubbles);
        assertEquals(bubbles, bubbleDiagram.getBubbles());
    }

    @Test
    void getId() {
        BubbleDiagram bubbleDiagram = new BubbleDiagram();
        bubbleDiagram.setId(1);
        assertEquals(1, bubbleDiagram.getId());
    }

    @Test
    void setId() {
        BubbleDiagram bubbleDiagram = new BubbleDiagram();
        bubbleDiagram.setId(2);
        assertEquals(2, bubbleDiagram.getId());
    }

    @Test
    void getProjects() {
        List<Project> projectList = new ArrayList<>();
        Project project = new Project();
        projectList.add(project);
        BubbleDiagram bubbleDiagram = new BubbleDiagram();
        bubbleDiagram.addProject(project);
        assertEquals(projectList, bubbleDiagram.getProjects());
    }

    @Test
    void getUserName() {

    }

    @Test
    void setUserName() {
    }

    @Test
    void isPublicDiagram() {
    }

    @Test
    void setPublicDiagram() {
    }

   /* @Test
    void makeBubble() {
        BubbleDiagram bubbleDiagram = new BubbleDiagram("name_bubble_D");
        Project p1 = new Project("project_Name");
        //Bubble b1 = new Bubble(1, "bubble_Name", p1);
        Bubble b1 = bubbleDiagram.makeBubble(1,"bubble_Name", p1);
        assertEquals(b1.getBubbleName(),bubbleDiagram.makeBubble(1,"bubble_Name", p1).getBubbleName());
        assertEquals(b1.getBubbleNumber(),bubbleDiagram.makeBubble(1,"bubble_Name", p1).getBubbleNumber());


        //assertEquals(, bubbleDiagram.);
        //assertEquals(1, bubbleDiagram.deleteProject(project2));
    }*/
}
