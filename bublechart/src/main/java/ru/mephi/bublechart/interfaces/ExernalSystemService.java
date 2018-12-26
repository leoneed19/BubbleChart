package ru.mephi.bublechart.interfaces;

import ru.mephi.bublechart.model.BubbleDiagram;

import java.util.List;

public interface ExernalSystemService {

    // bpmn ввод данных в систему (выгрузка данных из внешней
    // системы + формат + проверка)
    List<BubbleDiagram> importDiagrams();
}
