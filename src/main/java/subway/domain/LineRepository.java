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

        if (!isEqualFirstStationAndLastStation(firstStation, lastStation) && checkNameLength(lineName) && !checkNameInLines(lineName)
                && StationRepository.checkNameInStations(firstStation) && StationRepository.checkNameInStations(lastStation)) {
            lines.add(new Line(lineName, firstStation, lastStation));
            return;
        }

        throw new IllegalArgumentException();
    }

    public static void deleteLineByName(String name) {
        if (checkNameInLines(name)) {
            lines.removeIf(line -> Objects.equals(line.getName(), name));
            return;
        }

        throw new IllegalArgumentException();
    }

    public static void addSection(String order, String lineName, String name) {

        if (isNumber(order) && checkNameInLines(lineName) && StationRepository.checkNameInStations(name)
                && checkOrderSize(Integer.parseInt(order), findByLineName(lineName)) && !checkStationInLine(findByLineName(lineName), name)) {
            executeAddSection(order, lineName, name);
            return;
        }

        throw new IllegalArgumentException();
    }

    private static void executeAddSection(String order, String lineName, String name) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                line.addStationInSection(Integer.parseInt(order), name);
                line.updateTerminalStations();
                return;
            }
        }
    }

    public static boolean checkOrderSize(int order, Line line) {
        return order <= line.getSection().size() + 1;
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void deleteSection(String lineName, String name) {
        //예외처리 : 있는 노선인지, 노선안에 해당 역이 있는지, 삭제후 노선 안에 역이 2개 이상
        if (checkNameInLines(lineName) && checkStationInLine(findByLineName(lineName), name) && isMinCountInLine(findByLineName(lineName))) {
            executeDeleteSection(lineName, name);
            return;
        }

        throw new IllegalArgumentException();
    }

    public static void executeDeleteSection(String lineName, String name) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                line.deleteStationInSection(name);
                line.updateTerminalStations();
            }
        }
    }

    public static boolean isMinCountInLine(Line line) {
        return line.getSection().size() > Constants.MIN_COUNT_SECTION;
    }

    public static Line findByLineName(String lineName) {
        Line result = null;

        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                result = line;
                break;
            }
        }

        return result;
    }

    public static boolean checkStationInLine(Line line, String name) {
        for (Station station : line.getSection()) {
            if (station.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkNameInLines(String lineName) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkNameLength(String name) {
        return name.length() >= Constants.MIN_NAME_LENGTH;
    }

    public static boolean isEqualFirstStationAndLastStation(String firstStation, String lastStation) {
        return firstStation.equals(lastStation);
    }
}
