package subway.repository;

import subway.domain.Line;
import subway.domain.Station;
import subway.view.OutputView;

import java.util.*;
import java.util.function.Predicate;

import static subway.view.OutputView.*;

public class LineRepository {
    private static final String LINE_DUPLICATE_WARN = "노선 이름은 중복이 되어서는 안됩니다.\n";
    private static final String SECTION_ADD_SUCCESS = "구간이 등록되었습니다.\n";
    private static final String SECTION_DELETE_SUCCESS = "구간이 삭제되었습니다.\n";
    private static final String SECTION_DELETE_WARN = "역이 2개 이하인 노선은 구간삭제가 불가능합니다.\n";
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static boolean addLine(Line line) {
        if (lines.contains(line)) {
            warnMessage(LINE_DUPLICATE_WARN);
            return false;
        }
        lines.add(line);
        return true;
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line findLineByName(String lineName) {
        Optional<Line> findLine = lines.stream()
                .filter(line -> line.getName().equals(lineName)).findAny();
        return findLine.orElse(null);
    }

    public static boolean isStationExistInLine(Station station) {
        return lines.stream()
                .anyMatch(line -> line.getStationList()
                        .stream()
                        .anyMatch(Predicate.isEqual(station)));
    }

    public static boolean addSection(Line findLine, Station findStation, int orderNum) {
        findLine.addSection(orderNum, findStation);
        sectionAddMessage(SECTION_ADD_SUCCESS);
        return true;
    }

    public static boolean deleteSection(Line findLine, Station findStation) {
        if (findLine.getStationList().size() <= 2) {
            warnMessage(SECTION_DELETE_WARN);
            return false;
        }
        findLine.deleteSection(findStation);
        sectionDeleteMessage(SECTION_DELETE_SUCCESS);
        return true;
    }
}