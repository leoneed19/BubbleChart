package ru.mephi.bublechart.interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mephi.bublechart.model.BubbleDiagram;
import ru.mephi.bublechart.repository.BubbleDiagramRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ExternalSystemServiceTest {

    @Mock
    ExernalSystemService exernalSystemService;

    @Mock
    BubbleDiagramRepository bubbleDiagramRepository;

    private BubbleDiagramService bubbleDiagramService;

    private List<BubbleDiagram> list;

    @BeforeEach
    void init() {
        bubbleDiagramService = new BubbleDiagramServiceImpl(bubbleDiagramRepository);
        list  = new ArrayList<>();

        BubbleDiagram bubbleDiagram1 = new BubbleDiagram("A");
        bubbleDiagram1.setId(1);

        list.add(bubbleDiagram1);

        BubbleDiagram bubbleDiagram2 = new BubbleDiagram("B");
        bubbleDiagram2.setId(2);

        list.add(bubbleDiagram2);
    }

    @Test
    void importDiagramsTest() {
        Mockito.when(exernalSystemService.importDiagrams())
                .thenReturn(list);

        List<BubbleDiagram> bubbleDiagrams = exernalSystemService.importDiagrams();

        assertEquals(2, bubbleDiagrams.size());
        assertEquals(1, (int) bubbleDiagrams.get(0).getId());
        assertEquals("A", bubbleDiagrams.get(0).getNameOfBubbleDiagram());
        assertEquals(2, (int) bubbleDiagrams.get(1).getId());
        assertEquals("B", bubbleDiagrams.get(1).getNameOfBubbleDiagram());

        Mockito.when(bubbleDiagramRepository.addBubbleDiagram(any()))
                .thenReturn(0);

        for (BubbleDiagram bubbleDiagram : bubbleDiagrams) {
            Integer integer = bubbleDiagramService.addBubbleDiagram(bubbleDiagram);
            assertNotNull(integer);
        }
    }

    @Test
    void importDiagramsImportErrorTest() {
        Mockito.when(exernalSystemService.importDiagrams())
                .thenReturn(null);

        List<BubbleDiagram> bubbleDiagrams = exernalSystemService.importDiagrams();

        assertNull(bubbleDiagrams);
    }

    @Test
    void importDiagramsSaveErrorTest() {
        Mockito.when(exernalSystemService.importDiagrams())
                .thenReturn(list);

        List<BubbleDiagram> bubbleDiagrams = exernalSystemService.importDiagrams();

        assertEquals(2, bubbleDiagrams.size());
        assertEquals(1, (int) bubbleDiagrams.get(0).getId());
        assertEquals("A", bubbleDiagrams.get(0).getNameOfBubbleDiagram());
        assertEquals(2, (int) bubbleDiagrams.get(1).getId());
        assertEquals("B", bubbleDiagrams.get(1).getNameOfBubbleDiagram());

        Mockito.when(bubbleDiagramRepository.addBubbleDiagram(any()))
                .thenReturn(null);

        for (BubbleDiagram bubbleDiagram : bubbleDiagrams) {
            Integer integer = bubbleDiagramService.addBubbleDiagram(bubbleDiagram);
            assertNull(integer);
        }
    }
}
