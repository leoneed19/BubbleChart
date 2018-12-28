package ru.mephi.bublechart.interfaces;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mephi.bublechart.interfaces.dto.DiagramDto;
import ru.mephi.bublechart.model.BubbleDiagram;
import ru.mephi.bublechart.repository.BubbleDiagramRepository;
import ru.mephi.bublechart.web.dto.ProjectDto;
import ru.mephi.bublechart.web.dto.PutDiagramDto;

import java.util.List;

@Component
public class BubbleDiagramServiceImpl implements BubbleDiagramService {

    private BubbleDiagramRepository bubbleDiagramRepository;

    @Autowired
    public BubbleDiagramServiceImpl(BubbleDiagramRepository bubbleDiagramRepository) {
        this.bubbleDiagramRepository = bubbleDiagramRepository;
    }

    @Override
    public List<DiagramDto> findDiagramList() {
        return bubbleDiagramRepository.findDiagramList();
    }

    @Override
    public BubbleDiagram findById(int id) {
        return bubbleDiagramRepository.findById(id);
    }

    @Override
    public Integer deleteById(int id) {
        return bubbleDiagramRepository.deleteById(id);
    }

    @Override
    public Integer addBubbleDiagram(BubbleDiagram bubbleDiagram) {
        return bubbleDiagramRepository.addBubbleDiagram(bubbleDiagram);
    }

    @Override
    public Integer editBubbleDiagram(BubbleDiagram bubbleDiagram) {
        return bubbleDiagramRepository.editBubbleDiagram(bubbleDiagram);
    }

    @Override
    public int createNewDiagram(String name) {
        return 0;
    }

    @Override
    public boolean addProjectToBubbleDiagram(int bubbleDiagramId, int projectId) {
        return bubbleDiagramRepository.addProjectToBubbleDiagram(bubbleDiagramId, projectId);
    }

    @Override
    public List<ProjectDto> findProjectList() {
        return bubbleDiagramRepository.findProjectList();
    }

    @Override
    public boolean deleteProjectFromDiagram(int diagramId, int projectId) {
        return bubbleDiagramRepository.deleteProjectFromDiagram(diagramId, projectId);
    }

    @Override
    public boolean editDiagram(PutDiagramDto dto) {
        return bubbleDiagramRepository.editDiagram(dto);
    }
}
