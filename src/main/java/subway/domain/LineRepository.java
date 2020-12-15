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

        if (isNumber(order) && checkNameInLines(lineName)
                && StationRepository.checkNameInStations(name) && checkOrderSize(Integer.parseInt(order), lineName)) {
            findByLineName(order, lineName, name);
            return;
        }

        throw new IllegalArgumentException();
    }

    private static void findByLineName(String order, String lineName, String name) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                line.addStationInSection(Integer.parseInt(order), name);
                line.updateTerminalStations();
                return;
            }
        }
    }

    public static boolean checkOrderSize(int order, String lineName) {
        for (Line line : lines) {
            if(line.getName().equals(lineName)){
                return order <= line.getSection().size()+1;
            }
        }

        return false;
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void deleteSection(String line, String name) {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).getName().equals(line)) {
                lines.get(i).deleteStationInSection(name);
            }
        }
    }

    public static boolean checkNameInLines(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
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
