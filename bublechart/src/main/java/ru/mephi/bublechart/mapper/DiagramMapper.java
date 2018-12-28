package ru.mephi.bublechart.mapper;

import org.springframework.stereotype.Component;
import ru.mephi.bublechart.model.Bubble;
import ru.mephi.bublechart.model.BubbleDiagram;
import ru.mephi.bublechart.web.dto.AttributeDto;
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
            AttributeDto attributeDto = new AttributeDto();

            //bubbleDto.setX(bubble.getBubbleAttributes().get(0).getAttributeValue());
            //bubbleDto.setY(bubble.getBubbleAttributes().get(1).getAttributeValue());
            attributeDto.setValue((float) bubble.getBubbleAttributes().get(0).getAttributeValue());
            attributeDto.setName(bubble.getBubbleAttributes().get(0).getAttributeName());
            bubbleDto.setX(attributeDto);

            attributeDto = new AttributeDto();
            attributeDto.setValue((float) bubble.getBubbleAttributes().get(1).getAttributeValue());
            attributeDto.setName(bubble.getBubbleAttributes().get(1).getAttributeName());
            bubbleDto.setY(attributeDto);

            if (bubble.getBubbleAttributes().size() > 2) {
                attributeDto = new AttributeDto();
                attributeDto.setValue((float) bubble.getBubbleAttributes().get(2).getAttributeValue());
                attributeDto.setName(bubble.getBubbleAttributes().get(2).getAttributeName());
                bubbleDto.setR(attributeDto);

            }
            if (bubble.getBubbleAttributes().size() > 3) {
                attributeDto = new AttributeDto();
                attributeDto.setValue((float) bubble.getBubbleAttributes().get(3).getAttributeValue());
                attributeDto.setName(bubble.getBubbleAttributes().get(3).getAttributeName());
                bubbleDto.setT(attributeDto);
            }

            dto.getBubbles().add(bubbleDto);
        }

        return dto;
    }
}
