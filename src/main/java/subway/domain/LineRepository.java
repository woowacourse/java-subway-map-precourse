package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> retrieveLine() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(String lineName, String firstStation, String lastStation) {
        if (isEqualFirstStationAndLastStation(firstStation, lastStation)) {
            throw new IllegalArgumentException("[ERROR] 상행 종점과 하행 종점 역 이름은 달라야합니다.\n");
        }
        if (!checkNameLength(lineName)) {
            throw new IllegalArgumentException("[ERROR] 노선의 이름은 두 글자이상이여야 합니다.\n");
        }
        if (checkNameInLines(lineName)) {
            throw new IllegalArgumentException("[ERROR] 이미 등록된 노선 이름입니다.\n");
        }
        if (!StationRepository.checkNameInStations(firstStation) || !StationRepository.checkNameInStations(lastStation)) {
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 역 이름입니다.\n");
        }
        lines.add(new Line(lineName, firstStation, lastStation));
    }

    public static void deleteLineByName(String name) {
        if (!checkNameInLines(name)) {
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 노선 이름입니다.\n");
        }
        lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void addSection(String order, String lineName, String name) {
        if (!isNumber(order)) {
            throw new IllegalArgumentException("[ERROR] 순서는 숫자로 입력해야합니다.\n");
        }
        if (!checkNameInLines(lineName)) {
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 노선 이름입니다.\n");
        }
        if (!StationRepository.checkNameInStations(name)) {
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 역 이름입니다.\n");
        }
        if (!checkOrderSize(Integer.parseInt(order), findByLineName(lineName))) {
            throw new IllegalArgumentException("[ERROR] 순서는 해당 노선 길이보다 작아야합니다.\n");
        }
        if (checkStationInLine(findByLineName(lineName), name)) {
            throw new IllegalArgumentException("[ERROR] 해당 노선에 이미 존재하는 역입니다.\n");
        }
        executeAddSection(order, lineName, name);
    }

    public static void deleteSection(String lineName, String name) {
        //예외처리 : 있는 노선인지, 노선안에 해당 역이 있는지, 삭제후 노선 안에 역이 2개 이상
        if (!checkNameInLines(lineName)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 노선입니다.\n");
        }
        if (!checkStationInLine(findByLineName(lineName), name)) {
            throw new IllegalArgumentException("[ERROR] 해당 노선에 존재하지 않는 역입니다.\n");
        }
        if (!isMinCountInLine(findByLineName(lineName))) {
            throw new IllegalArgumentException("[ERROR] 노선에는 최소 2개의 역이 존재해야합니다.\n");
        }
        executeDeleteSection(lineName, name);
    }

    private static void executeDeleteSection(String lineName, String name) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                line.deleteStationInSection(name);
            }
        }
    }

    private static void executeAddSection(String order, String lineName, String name) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                line.addStationInSection(Integer.parseInt(order), name);
                return;
            }
        }
    }

    private static boolean checkStationInLine(Line line, String name) {
        for (Station station : line.getSection()) {
            if (station.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkNameInLines(String lineName) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkNameLength(String name) {
        return name.length() >= Constants.MIN_NAME_LENGTH;
    }

    private static boolean isEqualFirstStationAndLastStation(String firstStation, String lastStation) {
        return firstStation.equals(lastStation);
    }

    private static boolean checkOrderSize(int order, Line line) {
        return order <= line.getSection().size() + 1;
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isMinCountInLine(Line line) {
        return line.getSection().size() > Constants.MIN_COUNT_SECTION;
    }

    private static Line findByLineName(String lineName) {
        Line result = null;

        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                result = line;
                break;
            }
        }
        return result;
    }
}
