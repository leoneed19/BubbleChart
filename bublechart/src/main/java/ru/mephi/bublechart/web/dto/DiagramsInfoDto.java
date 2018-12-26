package ru.mephi.bublechart.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mephi.bublechart.interfaces.dto.DiagramDto;

import java.util.List;

@Data
@AllArgsConstructor
public class DiagramsInfoDto {

    private List<DiagramDto> diagrams;
}
