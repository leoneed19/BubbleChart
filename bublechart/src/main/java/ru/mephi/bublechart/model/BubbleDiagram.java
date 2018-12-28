package ru.mephi.bublechart.model;

import java.util.ArrayList;
import java.util.List;

public class BubbleDiagram {
    private int id;
    private String nameOfBubbleDiagram;
    private List<Project> projects = new ArrayList<>();
    private int transparency;
    private int[] xScale;
    private int[] yScale;
    private List<Bubble> bubbles = new ArrayList<>();
    private List<Type> types = new ArrayList<>();
    private String userName;
    private boolean publicDiagram;

    public BubbleDiagram() {
    }

    public BubbleDiagram(String nameOfBubbleDiagram) {
        List<Type> types = new ArrayList<Type>();
        this.nameOfBubbleDiagram = nameOfBubbleDiagram;
    }

    public List<Bubble> getBubbles() {
        return bubbles;
    }

    public void setBubbles(List<Bubble> bubbles) {
        this.bubbles = bubbles;
    }

    public String getNameOfBubbleDiagram() {
        return nameOfBubbleDiagram;
    }

    public void setNameOfBubbleDiagram(String nameOfBubbleDiagram) {
        this.nameOfBubbleDiagram = nameOfBubbleDiagram;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public int[] getxScale() {
        return xScale;
    }

    public void setxScale(int[] xScale) {
        this.xScale = xScale;
    }

    public int[] getyScale() {
        return yScale;
    }

    public void setyScale(int[] yScale) {
        this.yScale = yScale;
    }

    public int addProject(Project project) {
        for (Project pr : projects) {
            if (pr.equals(project))
                return 1;
        }
        projects.add(project);
        return 0;
    }

    //private Bubble makeBubble(int bubbleNumber, String bubbleName, Project p1) {
    //    Bubble b1 = new Bubble(bubbleNumber, bubbleName, p1);
    //    return b1;
    //}

    public Bubble addBubble(int bubbleNumber, String bubbleName, Project p1) {
        //Bubble b1 = makeBubble(bubbleNumber, bubbleName, p1);
        Bubble b1 = new Bubble(bubbleNumber, bubbleName, p1);
        for (Bubble b : bubbles) {
            if (b.equals(b1)) {
                return null;
            }
        }
        //projectmanagement.model.Bubble b1 = new projectmanagement.model.Bubble(bubbleNumber, bubbleName, p1);
        bubbles.add(b1);
        return b1;
    }

    public int addFactorToProject(String projectName, Factor factor) {
        int flag = 0;
        ///projectmanagement.model.Type t1;
        for (Type t : types) {
            if (t.equals(factor.getFactorType()))
                flag = 1;
        }
        // добавить в массив types новый тип, если его нет и если количество типов не больше 7
        if (flag == 0 && types.size() < 7) {
            //projectmanagement.model.Type t1 = new projectmanagement.model.Type(factor.getFactorType());
            //types.add(t1);

            for (Project pr : projects) {
                if (pr.getProjectName().equals(projectName)) {
                    List<Factor> f = pr.getFactors();
                    for (Factor f1 : f) {
                        if (f1.equals(factor))
                            return 1;
                    }
                    pr.addFactor(factor);
                    types.add(factor.getFactorType());
                    return 0;
                }
            }
        }
        if (flag == 0 && (types.size() > 7 || types.size() == 7)) {
            return 1;
        }

        if (flag == 1) {
            for (Project pr : projects) {
                if (pr.getProjectName().equals(projectName)) {
                    List<Factor> f = pr.getFactors();
                    for (Factor f1 : f) {
                        if (f1.equals(factor))
                            return 1;
                    }
                    pr.addFactor(factor);
                    //types.add(factor.getFactorType());
                    return 0;
                }
            }
        }
        return 1;
    }

    public int deleteProject(String projectName) {
        for (Project pr : projects) {
            if (pr.getProjectName().equals(projectName)) {
                projects.remove(pr);
                return 0;
            }
        }
        return 1;
    }

    public int deleteProject(Project project) {
        for (Project pr : projects) {
            if (pr.equals(project)) {
                projects.remove(pr);
                return 0;
            }
        }
        return 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isPublicDiagram() {
        return publicDiagram;
    }

    public void setPublicDiagram(boolean publicDiagram) {
        this.publicDiagram = publicDiagram;
    }
}
