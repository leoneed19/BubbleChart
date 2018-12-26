package ru.mephi.bublechart.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mephi.bublechart.interfaces.BubbleDiagramService;
import ru.mephi.bublechart.mapper.DiagramMapper;
import ru.mephi.bublechart.model.BubbleDiagram;
import ru.mephi.bublechart.web.dto.DiagramDto;
import ru.mephi.bublechart.web.dto.DiagramsInfoDto;

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
    public DiagramsInfoDto getDiagrams() {
        return new DiagramsInfoDto(bubbleDiagramService.findDiagramList());
    }

    @GetMapping("/diagram")
    public DiagramDto getDiagramById(@PathParam("id") int id){
        BubbleDiagram byId = bubbleDiagramService.findById(id);

        DiagramDto dto = DiagramMapper.map(byId);

        return dto;
    }
}
