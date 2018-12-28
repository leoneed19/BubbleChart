package ru.mephi.bublechart.interfaces;


import ru.mephi.bublechart.interfaces.dto.DiagramDto;
import ru.mephi.bublechart.model.BubbleDiagram;
import ru.mephi.bublechart.web.dto.ProjectDto;
import ru.mephi.bublechart.web.dto.PutDiagramDto;

import java.util.List;

public interface BubbleDiagramService {

    List<DiagramDto> findDiagramList();

    Integer deleteById(int id);

    BubbleDiagram findById(int id);

    Integer addBubbleDiagram(BubbleDiagram bubbleDiagram);

    Integer editBubbleDiagram(BubbleDiagram bubbleDiagram);

    int createNewDiagram(String name);

    boolean addProjectToBubbleDiagram(int bubbleDiagramId, int projectId);

    List<ProjectDto> findProjectList();

    boolean deleteProjectFromDiagram(int diagramId, int projectId);

    boolean editDiagram(PutDiagramDto dto);
}
