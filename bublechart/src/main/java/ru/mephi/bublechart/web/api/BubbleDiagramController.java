package ru.mephi.bublechart.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mephi.bublechart.interfaces.BubbleDiagramService;
import ru.mephi.bublechart.mapper.DiagramMapper;
import ru.mephi.bublechart.model.BubbleDiagram;
import ru.mephi.bublechart.web.dto.*;

import javax.websocket.server.PathParam;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bubble")
public class BubbleDiagramController {

    private BubbleDiagramService bubbleDiagramService;

    @Autowired
    BubbleDiagramController(BubbleDiagramService bubbleDiagramService) {
        this.bubbleDiagramService = bubbleDiagramService;
    }

    @GetMapping("/diagrams")
    public ResponseEntity<?> getDiagrams() {
        DiagramsInfoDto dto
                = new DiagramsInfoDto(bubbleDiagramService.findDiagramList());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/projects")
    public ResponseEntity<?> getProjects() {
        ProjectInfoDto dto = new ProjectInfoDto(bubbleDiagramService.findProjectList());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/project")
    public ResponseEntity<?> addProjectToDiagram(@RequestBody PostProjectToDiagramDto dto) {
        bubbleDiagramService.addProjectToBubbleDiagram(dto.getDiagramId(), dto.getProjectId());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/diagram")
    public ResponseEntity<?> getDiagramById(@PathParam("id") int id) {
        BubbleDiagram byId = bubbleDiagramService.findById(id);

        DiagramDto dto = DiagramMapper.map(byId);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/project")
    public ResponseEntity<?> deleteProjectFromDiagram(@PathParam("diagramId") int diagramId, @PathParam(" ") int projectId) {
        boolean b = bubbleDiagramService.deleteProjectFromDiagram(diagramId, projectId);
        if (b) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/diagram")
    public ResponseEntity<?> putDiagram(@RequestBody PutDiagramDto dto) {
        boolean f = bubbleDiagramService.editDiagram(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
