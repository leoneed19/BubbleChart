package ru.mephi.bublechart.interfaces;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mephi.bublechart.model.BubbleDiagram;
import ru.mephi.bublechart.interfaces.dto.DiagramDto;
import ru.mephi.bublechart.repository.BubbleDiagramRepository;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class DeleteExistingDiagramTest {

    @Mock
    BubbleDiagramRepository bubbleDiagramRepository;

    private BubbleDiagramService bubbleDiagramService;

    private BubbleDiagram bubbleDiagram;

    @BeforeEach
    void init() {
        bubbleDiagramService = new BubbleDiagramServiceImpl(bubbleDiagramRepository);

        bubbleDiagram = new BubbleDiagram("Diagram");
        bubbleDiagram.setId(1);
    }

    @Test
    void deleteExistingDiagramTest() {
        Mockito.when(bubbleDiagramRepository.findDiagramList(""))
                .thenReturn(Arrays.asList(new DiagramDto(), new DiagramDto()));
        List<DiagramDto> diagramList = bubbleDiagramService.findDiagramList("");
        assertEquals(2, diagramList.size());

        Mockito.when(bubbleDiagramRepository.findById(1))
                .thenReturn(bubbleDiagram);
        BubbleDiagram byId = bubbleDiagramService.findById(1);
        assertEquals(1, (int) byId.getId());

        Mockito.when(bubbleDiagramRepository.deleteById(1))
                .thenReturn(1);
        Integer id = bubbleDiagramService.deleteById(1);
        assertEquals(1, (int) id);
    }

    @Test
    void deleteExistingDiagramEmptyDiagramListTest() {
        Mockito.when(bubbleDiagramRepository.findDiagramList(""))
                .thenReturn(Collections.<DiagramDto>emptyList());

        List<DiagramDto> diagramList = bubbleDiagramService.findDiagramList("");

        assertEquals(0, diagramList.size());
    }

    @Test
    void deleteExistingDiagramDiagramDidNotFoundTest() {
        Mockito.when(bubbleDiagramRepository.findDiagramList(""))
                .thenReturn(Arrays.asList(new DiagramDto(), new DiagramDto()));
        List<DiagramDto> diagramList = bubbleDiagramService.findDiagramList("");
        assertEquals(2, diagramList.size());

        Mockito.when(bubbleDiagramRepository.findById(1))
                .thenReturn(null);
        BubbleDiagram byId = bubbleDiagramService.findById(1);
        assertNull(byId);
    }

    @Test
    void deleteExistingDiagramWrongDiagramIdTest() {
        Mockito.when(bubbleDiagramRepository.deleteById(1))
                .thenReturn(null);

        Integer id = bubbleDiagramService.deleteById(1);
        assertNull(id);
    }
}
