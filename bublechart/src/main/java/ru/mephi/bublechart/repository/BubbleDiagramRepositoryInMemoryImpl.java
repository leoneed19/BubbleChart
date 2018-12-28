package ru.mephi.bublechart.repository;


import org.springframework.stereotype.Component;
import ru.mephi.bublechart.interfaces.dto.DiagramDto;
import ru.mephi.bublechart.model.*;
import ru.mephi.bublechart.web.dto.AttributeDto;
import ru.mephi.bublechart.web.dto.BubbleDto;
import ru.mephi.bublechart.web.dto.ProjectDto;
import ru.mephi.bublechart.web.dto.PutDiagramDto;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class BubbleDiagramRepositoryInMemoryImpl implements BubbleDiagramRepository {

    private int currentMaxId = 0;
    private List<BubbleDiagram> bubbleDiagrams = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();

    @PostConstruct
    void init() {
        Project project = new Project();
        project.setProjectName("First");
        project.setProjectid(1);

        List<Factor> factors = new ArrayList<>();

        factors.add(new Factor("Цена", (float) 1.1));
        factors.add(new Factor("Площадь", (float) 2.3));
        factors.add(new Factor("Плотность населения", (float) 2.1));
        factors.add(new Factor("Прибыльность", (float) 10.2));

        project.setFactors(factors);

        projects.add(project);

        project = new Project();
        project.setProjectName("Second");
        project.setProjectid(2);

        factors = new ArrayList<>();

        factors.add(new Factor("Цена", (float) 1.5));
        factors.add(new Factor("Площадь", (float) 2.32));
        factors.add(new Factor("Плотность населения", (float) 4.1));
        factors.add(new Factor("Прибыльность", (float) 1.2));

        project.setFactors(factors);

        projects.add(project);

        int a = createNewDiagram("A");
        addProjectToBubbleDiagram(a, projects.get(0).getProjectid());
    }

    @Override
    public List<DiagramDto> findDiagramList() {
        List<DiagramDto> diagramDtos = new ArrayList<>();

        for (BubbleDiagram bubbleDiagram : bubbleDiagrams) {
            DiagramDto diagramDto = new DiagramDto();
            diagramDto.setId(bubbleDiagram.getId());
            diagramDto.setName(bubbleDiagram.getNameOfBubbleDiagram());

            diagramDtos.add(diagramDto);
        }

        return diagramDtos;
    }

    @Override
    public List<ProjectDto> findProjectList() {
        List<ProjectDto> projectDtos = new ArrayList<>();

        for (Project project : projects) {
            ProjectDto projectDto = new ProjectDto();

            projectDto.setId(project.getProjectid());
            projectDto.setName(project.getProjectName());

            projectDtos.add(projectDto);
        }

        return projectDtos;
    }

    @Override
    public Integer deleteById(int id) {
        return null;
    }

    @Override
    public boolean deleteProjectFromDiagram(int diagramId, int projectId) {
        for (BubbleDiagram bubbleDiagram : bubbleDiagrams) {
            if (bubbleDiagram.getId() == diagramId) {
                Project pr = null;
                for (Project project : bubbleDiagram.getProjects()) {
                    if (project.getProjectid() == projectId) {
                        pr = project;
                        break;
                    }
                }

                Bubble b = null;
                for (Bubble bubble : bubbleDiagram.getBubbles()) {
                    if (bubble.getProject().getProjectid() == projectId) {
                        b = bubble;
                        break;
                    }
                }

                if (pr == null || b == null) {
                    return false;
                }

                bubbleDiagram.getProjects().remove(pr);

                bubbleDiagram.getBubbles().remove(b);
            }
        }
        return true;
    }

    @Override
    public BubbleDiagram findById(int id) {
        for (BubbleDiagram diagram : bubbleDiagrams) {
            if (diagram.getId() == id) {
                return diagram;
            }
        }
        return null;
    }

    @Override
    public Integer addBubbleDiagram(BubbleDiagram bubbleDiagram) {
        return null;
    }

    @Override
    public Integer editBubbleDiagram(BubbleDiagram bubbleDiagram) {
        return null;
    }

    @Override
    public int createNewDiagram(String name) {
        BubbleDiagram bubbleDiagram = new BubbleDiagram(name);
        bubbleDiagram.setId(currentMaxId + 1);
        currentMaxId++;
        bubbleDiagrams.add(bubbleDiagram);
        return currentMaxId;
    }

    @Override
    public boolean addProjectToBubbleDiagram(int bubbleDiagramId, int projectId) {

        Project project = null;

        for (Project proj : projects) {
            if (proj.getProjectid() == projectId) {
                project = proj;
            }
        }

        if (project == null) {
            return false;
        }

        for (BubbleDiagram bubbleDiagram : bubbleDiagrams) {
            if (bubbleDiagram.getId() == bubbleDiagramId) {
                bubbleDiagram.addProject(project);
                Bubble bubble = new Bubble();

                bubble.setProject(project);

                List<BubbleAttribute> attributes = new ArrayList<>();

                for (Factor factor : project.getFactors()) {
                    BubbleAttribute attribute = new BubbleAttribute();
                    attribute.setAttributeValue(factor.getFactorValue());
                    attribute.setAttributeName(factor.getFactorName());
                    attributes.add(attribute);
                }

                bubble.setBubbleAttributes(attributes);

                bubbleDiagram.getBubbles().add(bubble);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean editDiagram(PutDiagramDto dto) {
        for (BubbleDiagram diagram : bubbleDiagrams) {
            if (diagram.getId() == dto.getId()) {

                List<BubbleDto> bubblesDto = dto.getBubbles();
                List<Bubble> bubbles = diagram.getBubbles();

                for (int i = 0; i < dto.getBubbles().size(); i++) {
                    BubbleDto bubbleDto = bubblesDto.get(i);
                    Bubble bubble = bubbles.get(i);

                    BubbleAttribute attribute = bubble.getBubbleAttributes().get(0);
                    AttributeDto attributeDto = bubbleDto.getX();
                    attribute.setAttributeName(attributeDto.getName());
                    attribute.setAttributeValue(attributeDto.getValue());

                    attribute = bubble.getBubbleAttributes().get(1);
                    attributeDto = bubbleDto.getY();
                    attribute.setAttributeName(attributeDto.getName());
                    attribute.setAttributeValue(attributeDto.getValue());


                    attribute = bubble.getBubbleAttributes().get(2);
                    attributeDto = bubbleDto.getR();
                    attribute.setAttributeName(attributeDto.getName());
                    attribute.setAttributeValue(attributeDto.getValue());


                    attribute = bubble.getBubbleAttributes().get(3);
                    attributeDto = bubbleDto.getT();
                    attribute.setAttributeName(attributeDto.getName());
                    attribute.setAttributeValue(attributeDto.getValue());


                }
                return true;
            }
        }
        return false;
    }
}
