package ru.mephi.bublechart.web.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PutDiagramDto {

    private Integer id;
    private String name;
    private List<BubbleDto> bubbles = new ArrayList<>();
}
