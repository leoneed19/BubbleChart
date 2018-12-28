package ru.mephi.bublechart.web.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DiagramDto {

    private Integer id;
    private String name;
    private List<BubbleDto> bubbles = new ArrayList<>();
    private List<ProjectDto> projectsInDiagram = new ArrayList<>();
    private List<ProjectDto> projectsNotInDiagram  = new ArrayList<>();
}
