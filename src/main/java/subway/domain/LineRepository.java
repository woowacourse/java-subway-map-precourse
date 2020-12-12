package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private static final String WHITE_SPACE = " ";
    private static final int EMPTY_LINES = 0;
    private static final int LAST_INDEX = 1;
    private static final int ENOUGH_STATIONS = 2;
    private static final int MINIMUM_NAME_LENGTH = 3;
    private static final String RULE_LINE_NAME = "선";

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(String name) {
        validateNameLastCharacter(name);
        validateNameContainWhitepace(name);
        validateNameLength(name);
        validateNameDuplicate(name);
        lines.add(new Line(name, new ArrayList<>()));
    }

    public static void enrollStartStation(String name) {
        validateEnoughStations();
        validateExistStation(name);
        lines.get(lines.size() - LAST_INDEX)
            .addStation(StationRepository.findStation(name));
    }

    public static void enrollEndStation(String name) {
        validateEnoughStations();
        validateExistStation(name);
        validateSameStation(name);
        lines.get(lines.size() - LAST_INDEX)
            .addStation(StationRepository.findStation(name));
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    private static void validateLinesEmpty() {
        if (lines.size() == EMPTY_LINES) {
            throw new IllegalArgumentException("등록 되어 있는 지하철 노선이 없습니다.");
        }
    }

    private static void validateNameLastCharacter(String name) {
        if (!name.substring(name.length() - LAST_INDEX).equals(RULE_LINE_NAME)) {
            throw new IllegalArgumentException("지하철 노선 이름은 \"선\"으로 끝나야 합니다.");
        }
    }

    private static void validateNameContainWhitepace(String name) {
        if (name.contains(WHITE_SPACE)) {
            throw new IllegalArgumentException("지하철 노선 이름에 공백이 포함될 수 없습니다.");
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("지하철 노선 이름은 2글자 이상 + \"선\"으로 이루어져야 합니다.");
        }
    }

    private static void validateNameDuplicate(String name) {
        if (lines.stream()
            .anyMatch(line -> line.getName().equals(name))) {
            throw new IllegalArgumentException("동일한 지하철 노선 이름이 존재합니다.");
        }
    }

    private static void validateEnoughStations() {
        if (StationRepository.stations().size() < ENOUGH_STATIONS) {
            throw new IllegalArgumentException("지하철 노선을 등록할 지하철 역 개수가 충분하지 않습니다.");
        }
    }

    private static void validateExistStation(String name) {
        if (!StationRepository.stations().stream()
            .anyMatch(station -> station.getName().equals(name))) {
            throw new IllegalArgumentException("해당 지하철 역은 등록되어 있지 않습니다.");
        }
    }

    private static void validateSameStation(String name) {
        if (lines.get(lines.size() - LAST_INDEX).getStations()
            .stream().anyMatch(station -> station.getName().equals(name))) {
            throw new IllegalArgumentException("상행 종점역과 하행 종점역은 서로 달라야 합니다.");
        }
    }

    public static void insertLineSection(String lineName, String stationName, int index) {
        lines.stream().filter(line -> line.getName().equals(lineName))
            .forEach(line -> line.addStation(StationRepository.findStation(stationName), index));
    }
}
