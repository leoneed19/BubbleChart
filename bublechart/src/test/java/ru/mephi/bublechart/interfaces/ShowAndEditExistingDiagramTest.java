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
import ru.mephi.bublechart.web.dto.ProjectDto;
import ru.mephi.bublechart.web.dto.PutDiagramDto;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
        Mockito.when(bubbleDiagramRepository.findDiagramList(""))
                .thenReturn(Arrays.asList(new DiagramDto(), new DiagramDto()));
        List<DiagramDto> diagramList = bubbleDiagramService.findDiagramList("");
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
        Mockito.when(bubbleDiagramRepository.findDiagramList(""))
                .thenReturn(Arrays.asList(new DiagramDto(), new DiagramDto()));
        List<DiagramDto> diagramList = bubbleDiagramService.findDiagramList("");
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
    void showAndEditDiagramFindDiagramListErrorTest() {
        Mockito.when(bubbleDiagramRepository.findDiagramList(""))
                .thenReturn(null);
        List<DiagramDto> diagramList = bubbleDiagramService.findDiagramList("");
        assertNull(diagramList);
    }


    @Test
    void showAndEditDiagramCreateNewDiagramTest() {
        Mockito.when(bubbleDiagramRepository.createNewDiagram("1", "2", true))
                .thenReturn(0);
        //List<DiagramDto> diagramList = bubbleDiagramService.findDiagramList("1");
        assertEquals(0, bubbleDiagramService.createNewDiagram("1", "2", true));
    }

    @Test
    void showAndEditDiagramAddProjectToBubbleDiagramTest() {
        Mockito.when(bubbleDiagramRepository.addProjectToBubbleDiagram(1, 2)).thenReturn(true);
        //List<DiagramDto> diagramList = bubbleDiagramService.findDiagramList("1");
        assertTrue(bubbleDiagramService.addProjectToBubbleDiagram(1, 2));
    }

    @Test
    void showAndEditDiagramFindProjectListTest() {
        Mockito.when(bubbleDiagramRepository.findProjectList()).thenReturn(null);
        List<ProjectDto> projectDtoList = bubbleDiagramService.findProjectList();
        assertNull(projectDtoList);
    }

    @Test
    void showAndEditDiagramDeleteProjectFromDiagramTest() {
        Mockito.when(bubbleDiagramRepository.deleteProjectFromDiagram(1, 2))
                .thenReturn(true);
        assertTrue(bubbleDiagramService.deleteProjectFromDiagram(1, 2));
    }

    @Test
    void showAndEditDiagramEditDiagramTest() {
        PutDiagramDto dto = new PutDiagramDto();
        Mockito.when(bubbleDiagramRepository.editDiagram(dto))
                .thenReturn(true);
        //List<DiagramDto> diagramList = bubbleDiagramService.findDiagramList("1");
        assertTrue(bubbleDiagramService.editDiagram(dto));
    }

    @Test
    void showAndEditDiagramFindProjectsInDiagramByIdTest() {
        List<ProjectDto> projectDtoList = new ArrayList<>();
        Mockito.when(bubbleDiagramRepository.findProjectsInDiagramById(1))
                .thenReturn(projectDtoList);
        //List<DiagramDto> diagramList = bubbleDiagramService.findDiagramList("1");
        assertEquals(projectDtoList, bubbleDiagramService.findProjectsInDiagramById(1));
    }

    @Test
    void showAndEditDiagramFindProjectsNotInDiagramByIdTest() {
        ProjectDto projectDto1= new ProjectDto();
        ProjectDto projectDto2= new ProjectDto();
        List<ProjectDto> projectDtoList = new ArrayList<>();
        projectDtoList.add(projectDto1);
        projectDtoList.add(projectDto2);
        Mockito.when(bubbleDiagramRepository.findProjectsNotInDiagramById(1))
                .thenReturn(projectDtoList);
        assertEquals(projectDtoList, bubbleDiagramService.findProjectsNotInDiagramById(1));
    }





}
