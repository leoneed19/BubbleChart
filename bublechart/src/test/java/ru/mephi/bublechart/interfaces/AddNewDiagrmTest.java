package ru.mephi.bublechart.interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mephi.bublechart.model.BubbleDiagram;
import ru.mephi.bublechart.repository.BubbleDiagramRepository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class AddNewDiagrmTest {

    @Mock
    BubbleDiagramRepository bubbleDiagramRepository;

    private BubbleDiagramService bubbleDiagramService;

    private BubbleDiagram bubbleDiagram;

    @BeforeEach
    void init() {
        bubbleDiagramService = new BubbleDiagramServiceImpl(bubbleDiagramRepository);

        bubbleDiagram = new BubbleDiagram("Diagram");
    }

    @Test
    void deleteExistingDiagramTest() {
        Mockito.when(bubbleDiagramRepository.addBubbleDiagram(any()))
                .thenReturn(1);
        Integer id = bubbleDiagramService.addBubbleDiagram(bubbleDiagram);
        assertEquals(1, (int) id);
    }

    @Test
    void deleteExistingDiagramAddErrorTest() {
        Mockito.when(bubbleDiagramRepository.addBubbleDiagram(any()))
                .thenReturn(null);
        Integer id = bubbleDiagramService.addBubbleDiagram(bubbleDiagram);
        assertNull(id);
    }
}
