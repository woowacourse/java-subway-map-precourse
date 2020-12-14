package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SectionRepository {

    private static final int EMPTY_SECTIONS = 0;

    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static void deleteSection(String lineName) {
        validateSectionsEmpty();
        if (!sections.removeIf(section -> Objects
            .equals(section.getLine().getName(), lineName))) {
            throw new IllegalArgumentException("일치하는 지하철 노선이 없습니다.");
        }
    }

    public static Section getSectionByLineName(String lineName){
        try {
            return sections().stream()
                .filter(section -> section.getLine().getName().equals(lineName))
                .findAny()
                .get();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("해당 지하철 노선은 존재하지 않습니다.");
        }
    }

    private static void validateSectionsEmpty() {
        if (sections.size() == EMPTY_SECTIONS) {
            throw new IllegalArgumentException("등록 되어 있는 지하철 노선 구간이 없습니다.");
        }
    }
}
