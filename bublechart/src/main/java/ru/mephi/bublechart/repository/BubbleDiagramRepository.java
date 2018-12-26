package ru.mephi.bublechart.repository;


import ru.mephi.bublechart.model.BubbleDiagram;
import ru.mephi.bublechart.interfaces.dto.DiagramDto;

import java.util.List;

public interface BubbleDiagramRepository {

    List<DiagramDto> findDiagramList();

    Integer deleteById(int id);

    BubbleDiagram findById(int id);

    Integer addBubbleDiagram(BubbleDiagram bubbleDiagram);

    Integer editBubbleDiagram(BubbleDiagram bubbleDiagram);
}
