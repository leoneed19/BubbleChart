package ru.mephi.bublechart.interfaces;


import ru.mephi.bublechart.model.BubbleDiagram;
import ru.mephi.bublechart.interfaces.dto.DiagramDto;

import java.util.List;

public interface BubbleDiagramService {

    // bpmn обработка диаграммы в реальном времени (выгрузка списка доступных диаграмм)
    List<DiagramDto> findDiagramList();

    // bpmn обработка диаграммы в реальном времени (выгрузка диаграммы)
    BubbleDiagram findById(int id);

    // bpmn удаление существующей диаграммы
    Integer deleteById(int id);

    // bpmn построение новой диаграммы (return id новой диаграммы или null)
    Integer addBubbleDiagram(BubbleDiagram bubbleDiagram);

    // bpmn просмотр/редактирование существующей диаграммы (return id диаграммы или null)
    Integer editBubbleDiagram(BubbleDiagram bubbleDiagram);
}
