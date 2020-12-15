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
        //예외 처리 : 상행 종점과 하행 종점역이 같을 경우, 노선 이름 길이 2이상, 노선 이름 중복, 입력받은 2개의 역이 존재하는 역인지 확인
        if (!isEqualFirstStationAndLastStation(firstStation, lastStation) && checkNameLength(lineName) && !checkNameInLines(lineName)
                && StationRepository.checkNameInStations(firstStation) && StationRepository.checkNameInStations(lastStation)) {
            lines.add(new Line(lineName, firstStation, lastStation));
            return;
        }

        throw new IllegalArgumentException();
    }

    public static void deleteLineByName(String name) {
        //예외 처리 : 존재하는 노선인지 확인
        if (checkNameInLines(name)) {
            lines.removeIf(line -> Objects.equals(line.getName(), name));
            return;
        }

        throw new IllegalArgumentException();
    }

    public static void addSection(String order, String lineName, String name) {
        //예외 처리 : 순서가 숫자인지 확인, 존재하는 노선인지, 역 이름이 존재하는지, 순서가 노선 사이즈보다 작은지, 노선안에 중복되있는 역이름이 있는지
        if (isNumber(order) && checkNameInLines(lineName) && StationRepository.checkNameInStations(name)
                && checkOrderSize(Integer.parseInt(order), findByLineName(lineName)) && !checkStationInLine(findByLineName(lineName), name)) {
            executeAddSection(order, lineName, name);
            return;
        }

        throw new IllegalArgumentException();
    }

    public static void deleteSection(String lineName, String name) {
        //예외처리 : 있는 노선인지, 노선안에 해당 역이 있는지, 삭제후 노선 안에 역이 2개 이상
        if (checkNameInLines(lineName) && checkStationInLine(findByLineName(lineName), name) && isMinCountInLine(findByLineName(lineName))) {
            executeDeleteSection(lineName, name);
            return;
        }

        throw new IllegalArgumentException();
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
