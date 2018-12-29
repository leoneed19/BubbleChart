package ru.mephi.bublechart.interfaces.diagramDtoTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mephi.bublechart.interfaces.BubbleDiagramService;
import ru.mephi.bublechart.interfaces.BubbleDiagramServiceImpl;
import ru.mephi.bublechart.interfaces.dto.DiagramDto;
import ru.mephi.bublechart.model.BubbleDiagram;
import ru.mephi.bublechart.repository.BubbleDiagramRepository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyObject;

@ExtendWith(MockitoExtension.class)
class DiagramDtoTest {

    @Mock
    private DiagramDto diagramDto_1;
    private DiagramDto diagramDto_2;

    @BeforeEach
    void init() {
        diagramDto_1 = new DiagramDto();
        diagramDto_2 = new DiagramDto(2, "name2");
    }

    @Test
    void getIdTest() {
        assertEquals(2, (int)diagramDto_2.getId());
    }

    @Test
    void setIdTest() {
        diagramDto_1.setId(1);
        assertEquals(1, (int)diagramDto_1.getId());
    }

    @Test
    void getNameTest() {
        assertEquals("name2", diagramDto_2.getName());
    }

    @Test
    void setNameTest() {
        diagramDto_1.setName("name_1");
        assertEquals("name_1", diagramDto_1.getName());
    }
}
