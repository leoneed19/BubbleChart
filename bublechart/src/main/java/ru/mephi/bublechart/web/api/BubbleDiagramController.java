package ru.mephi.bublechart.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
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

    @PostMapping("/diagram")
    public ResponseEntity<?> postDiagrams(@RequestBody PostDiagramDto postDiagramDto) {

        String name = (String) RequestContextHolder.getRequestAttributes().getAttribute("name", 0);

        bubbleDiagramService.createNewDiagram(postDiagramDto.getName(), name, postDiagramDto.isPublic());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/diagrams")
    public ResponseEntity<?> getDiagrams() {

        String name = (String) RequestContextHolder.getRequestAttributes().getAttribute("name", 0);

        DiagramsInfoDto dto
                = new DiagramsInfoDto(bubbleDiagramService.findDiagramList(name));
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

        dto.setProjectsInDiagram(bubbleDiagramService.findProjectsInDiagramById(id));
        dto.setProjectsNotInDiagram(bubbleDiagramService.findProjectsNotInDiagramById(id));

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
