package ru.mephi.bublechart.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelectBubbleDiagramByIdDto {

    private Integer id;
    private Integer bubbleId;
    private String name;
    private Integer value;
}
