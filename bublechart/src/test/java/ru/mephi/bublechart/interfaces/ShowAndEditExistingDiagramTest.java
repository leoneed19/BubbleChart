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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ShowAndEditExistingDiagramTest {

    @Mock
    BubbleDiagramRepository bubbleDiagramRepository;

    private BubbleDiagramService bubbleDiagramService;

    private BubbleDiagram bubbleDiagram;

    @BeforeEach
    void init() {
        bubbleDiagramService = new BubbleDiagramServiceImpl(bubbleDiagramRepository);
        bubbleDiagram = new BubbleDiagram("A");
        bubbleDiagram.setId(1);
    }

    @Test
    void showAndEditDiagramTest() {
        Mockito.when(bubbleDiagramRepository.findDiagramList())
                .thenReturn(Arrays.asList(new DiagramDto(), new DiagramDto()));
        List<DiagramDto> diagramList = bubbleDiagramService.findDiagramList();
        assertEquals(2, diagramList.size());

        Mockito.when(bubbleDiagramRepository.findById(1))
                .thenReturn(bubbleDiagram);
        BubbleDiagram byId = bubbleDiagramService.findById(1);
        assertEquals(1, (int) byId.getId());

        Mockito.when(bubbleDiagramRepository.editBubbleDiagram(any()))
                .thenAnswer(invoc -> ((BubbleDiagram)invoc.getArguments()[0]).getId());
        Integer id = bubbleDiagramService.editBubbleDiagram(bubbleDiagram);
        assertEquals(1, (int) id);
    }

    @Test
    void showAndEditDiagramEditErrorTest() {
        Mockito.when(bubbleDiagramRepository.findDiagramList())
                .thenReturn(Arrays.asList(new DiagramDto(), new DiagramDto()));
        List<DiagramDto> diagramList = bubbleDiagramService.findDiagramList();
        assertEquals(2, diagramList.size());

        Mockito.when(bubbleDiagramRepository.findById(1))
                .thenReturn(bubbleDiagram);
        BubbleDiagram byId = bubbleDiagramService.findById(1);
        assertEquals(1, (int) byId.getId());

        Mockito.when(bubbleDiagramRepository.editBubbleDiagram(any()))
                .thenReturn(null);
        Integer id = bubbleDiagramService.editBubbleDiagram(bubbleDiagram);
        assertNull(id);
    }

    @Test
    void showAndEditDiagramFindByIdErrorTest() {
        Mockito.when(bubbleDiagramRepository.findDiagramList())
                .thenReturn(Arrays.asList(new DiagramDto(), new DiagramDto()));
        List<DiagramDto> diagramList = bubbleDiagramService.findDiagramList();
        assertEquals(2, diagramList.size());

        Mockito.when(bubbleDiagramRepository.findById(1))
                .thenReturn(null);
        BubbleDiagram byId = bubbleDiagramService.findById(1);
        assertNull(byId);
    }

    @Test
    void showAndEditDiagramFindDiagramListErrorTest() {
        Mockito.when(bubbleDiagramRepository.findDiagramList())
                .thenReturn(null);
        List<DiagramDto> diagramList = bubbleDiagramService.findDiagramList();
        assertNull(diagramList);
    }
}
