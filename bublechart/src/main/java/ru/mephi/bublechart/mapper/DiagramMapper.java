package ru.mephi.bublechart.mapper;

import org.springframework.stereotype.Component;
import ru.mephi.bublechart.model.Bubble;
import ru.mephi.bublechart.model.BubbleDiagram;
import ru.mephi.bublechart.web.dto.BubbleDto;
import ru.mephi.bublechart.web.dto.DiagramDto;

@Component
public class DiagramMapper {

    public static DiagramDto map(BubbleDiagram bubbleDiagram) {
        DiagramDto dto = new DiagramDto();
        dto.setId(bubbleDiagram.getId());
        dto.setName(bubbleDiagram.getNameOfBubbleDiagram());

        for (Bubble bubble : bubbleDiagram.getBubbles()) {

            BubbleDto bubbleDto = new BubbleDto();
            bubbleDto.setX(bubble.getBubbleAttributes().get(0).getAttributeValue());
            bubbleDto.setY(bubble.getBubbleAttributes().get(1).getAttributeValue());

            if (bubble.getBubbleAttributes().size() > 2) {
                bubbleDto.setR(bubble.getBubbleAttributes().get(2).getAttributeValue());
            }
            if (bubble.getBubbleAttributes().size() > 3) {
                bubbleDto.setT(bubble.getBubbleAttributes().get(3).getAttributeValue());
            }

            dto.getBubbles().add(bubbleDto);
        }

        return dto;
    }
}
