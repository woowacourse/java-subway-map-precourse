package subway.repository;

import subway.domain.Line;
import subway.domain.Station;
import subway.view.OutputView;

import java.util.*;
import java.util.function.Predicate;

import static subway.view.OutputView.*;

public class LineRepository {
    private static final String LINE_DUPLICATE_WARN = "노선 이름은 중복이 되어서는 안됩니다.";
    private static final String SECTION_ADD_SUCCESS = "구간이 등록되었습니다.";
    private static final String SECTION_DELETE_SUCCESS = "구간이 삭제되었습니다.";
    private static final String SECTION_DELETE_WARN = "역이 2개 이하인 노선은 구간삭제가 불가능합니다.";
    private static final String LINE_ADD_SUCCESS = "노선이 등록되었습니다.";
    private static final String LINE_DELETE_SUCCESS = "노선이 삭제되었습니다.";
    private static final String LINE_SIZE_ZERO = "등록된 노선이 없습니다.";
    private static final String LINE_NOT_EXIST_WARN = "존재하지 않는 노선 입니다.";

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        if (lines.contains(line)) {
            warnMessage(LINE_DUPLICATE_WARN);
            return;
        }
        lines.add(line);
        infoMessage(LINE_ADD_SUCCESS);
    }

    public static void deleteLineByName(String lineName) {
        Line findLine = findLineByName(lineName);
        if (findLine == null) {
            warnMessage(LINE_NOT_EXIST_WARN);
            return;
        }
        lines.remove(findLine);
        infoMessage(LINE_DELETE_SUCCESS);
    }

    public static void printLineList() {
        if (lines.size() == 0) {
            warnMessage(LINE_SIZE_ZERO);
            return;
        }
        lines.forEach(line -> infoMessage(line.getName()));
    }

    public static Line findLineByName(String lineName) {
        return lines.stream()
                .filter(line -> line.getName().equals(lineName)).findAny().orElse(null);
    }

    public static boolean isStationExistInLine(Station station) {
        return lines.stream()
                .anyMatch(line -> line.stations().contains(station));
    }

    public static boolean addSection(Line findLine, Station findStation, int orderNum) {
        findLine.addSection(orderNum, findStation);
        infoMessage(SECTION_ADD_SUCCESS);
        return true;
    }

    public static boolean deleteSection(Line findLine, Station findStation) {
        if (findLine.stations().size() <= 2) {
            warnMessage(SECTION_DELETE_WARN);
            return false;
        }
        findLine.deleteSection(findStation);
        infoMessage(SECTION_DELETE_SUCCESS);
        return true;
    }

    public static void printLineAndStation() {
        lines.forEach(Line::printLineDetail);
    }
}