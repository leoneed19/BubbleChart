package ru.mephi.bublechart.repository;


import ru.mephi.bublechart.interfaces.dto.DiagramDto;
import ru.mephi.bublechart.model.BubbleDiagram;
import ru.mephi.bublechart.web.dto.ProjectDto;
import ru.mephi.bublechart.web.dto.PutDiagramDto;

import java.util.List;

public interface BubbleDiagramRepository {

    List<DiagramDto> findDiagramList(String name);

    List<ProjectDto> findProjectList();

    Integer deleteById(int id);

    boolean deleteProjectFromDiagram(int diagramId, int projectId);

    BubbleDiagram findById(int id);

    Integer addBubbleDiagram(BubbleDiagram bubbleDiagram);

    Integer editBubbleDiagram(BubbleDiagram bubbleDiagram);

    int createNewDiagram(String name, String userName, boolean isPuplic);

    boolean addProjectToBubbleDiagram(int bubbleDiagramId, int projectId);

    boolean editDiagram(PutDiagramDto dto);

    List<ProjectDto> findProjectsNotInDiagramById(int id);

    List<ProjectDto> findProjectsInDiagramById(int id);
}
