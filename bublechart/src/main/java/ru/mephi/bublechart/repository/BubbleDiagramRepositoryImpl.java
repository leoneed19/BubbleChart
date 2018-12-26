package ru.mephi.bublechart.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.mephi.bublechart.interfaces.dto.DiagramDto;
import ru.mephi.bublechart.model.BubbleAttribute;
import ru.mephi.bublechart.model.Bubble;
import ru.mephi.bublechart.model.BubbleDiagram;
import ru.mephi.bublechart.repository.dto.SelectBubbleDiagramByIdDto;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BubbleDiagramRepositoryImpl implements BubbleDiagramRepository {

    private final String createTableBubbleDiagram =
            "create table if not exists BubbleDiagram(" +
                    "id serial primary key," +
                    "name varchar);";

    private final String createTableBubble =
            "create table if not exists Bubble(" +
                    "id serial primary key," +
                    "bubbleDiagramId int references BubbleDiagram(id));";

    private final String Attribute =
            "create table if not exists Attribute(" +
                    "id serial primary key," +
                    "value float," +
                    "bubbleId int references Bubble(id));";

    private final String selectDiagramsInfo =
            "select id, name " +
                    "FROM BubbleDiagram;";

    private final String selectDiagramById =
            "select BubbleDiagram.id as bubbleDiagramId, Bubble.id as bubbleId, name, value " +
                    "from BubbleDiagram left join Bubble " +
                    "on BubbleDiagram.id = Bubble.bubbleDiagramId " +
                    "left join Attribute " +
                    "on Bubble.id = Attribute.bubbleId " +
                    "where BubbleDiagram.id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    BubbleDiagramRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init() {
        jdbcTemplate.execute(createTableBubbleDiagram);
        jdbcTemplate.execute(createTableBubble);
        jdbcTemplate.execute(Attribute);
    }

    @Override
    public List<DiagramDto> findDiagramList() {
        return jdbcTemplate.query(selectDiagramsInfo,
                (rs, rowNum) -> new DiagramDto(rs.getInt("id"), rs.getString("name"))
        );
    }

    @Override
    public Integer deleteById(int id) {
        return null;
    }

    @Override
    public BubbleDiagram findById(int id) {
        List<SelectBubbleDiagramByIdDto> dtos = jdbcTemplate.query(selectDiagramById, new Object[]{id},
                (rs, rowNum) ->
                        new SelectBubbleDiagramByIdDto(
                                rs.getInt("bubbleDiagramId"),
                                rs.getInt("bubbleId"),
                                rs.getString("name"),
                                rs.getInt("value"))
        );

        return dtos.size() != 0 ? parseFindByIdAnswer(dtos) : null;
    }

    @Override
    public Integer addBubbleDiagram(BubbleDiagram bubbleDiagram) {
        return null;
    }

    @Override
    public Integer editBubbleDiagram(BubbleDiagram bubbleDiagram) {
        return null;
    }

    private BubbleDiagram parseFindByIdAnswer(List<SelectBubbleDiagramByIdDto> dtos) {
        if (dtos.size() == 0) {
            return null;
        }
        BubbleDiagram bubbleDiagram = new BubbleDiagram();
        bubbleDiagram.setNameOfBubbleDiagram(dtos.get(0).getName());
        bubbleDiagram.setId(dtos.get(0).getId());

        Map<Integer, List<Integer>> bubbleIdValueMap = new HashMap<>();

        for (SelectBubbleDiagramByIdDto dto : dtos) {
            if (!bubbleIdValueMap.containsKey(dto.getBubbleId())) {
                bubbleIdValueMap.put(dto.getBubbleId(), new ArrayList<>());
            }

            bubbleIdValueMap.get(dto.getBubbleId()).add(dto.getValue());
        }

        for (Integer bubbleId : bubbleIdValueMap.keySet()) {
            Bubble bubble = new Bubble();
            for (Integer value : bubbleIdValueMap.get(bubbleId)) {
                BubbleAttribute bubbleAttribute = new BubbleAttribute();
                bubbleAttribute.setAttributeValue(value);
                bubble.getBubbleAttributes().add(bubbleAttribute);
            }
            bubbleDiagram.getBubbles().add(bubble);
        }

        return bubbleDiagram;
    }
}
