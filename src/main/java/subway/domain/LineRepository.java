package subway.domain;

import subway.view.OutputView;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        if (!hasDuplicatedLine(line)) {
            lines.add(line);
            return;
        }
        OutputView.printDuplicatedErrorMessage(line.toString());
    }

    public static void addLines(List<Line> lines) {
        lines.forEach(LineRepository::addLine);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean addPathInLine(String findLine, String inputStation, int inputIndex) {
        if (getLine(findLine) == null) {
            OutputView.printLineDoesNotExistErrorMessage(findLine);
            return false;
        }
        Station station = StationRepository.getStation(inputStation);
        if (station == null) {
            return false;
        }
        getLine(findLine).getPath().addOneStationBetweenStations(station, inputIndex);
        return true;
    }

    public static Line getLine(String findLine) {
        for (Line line : lines) {
            if (line.getName().equals(findLine)) {
                return line;
            }
        }
        return null;
    }

    public static boolean hasDuplicatedLine(Line line) {
        return lines.contains(line);
    }

    public static boolean hasDuplicatedLine(String checkedLineName) {
        for (Line line : lines) {
            if (line.getName() == checkedLineName) {
                return true;
            }
        }
        return false;
    }

    public static void printLineInfo() {
        lines.forEach(line -> {
            OutputView.printLineTitle(line.getName());
            line.getPath().printAllPath();
            OutputView.printNewLine();
        });
    }

    public static void printOnlyLineName() {
        lines.forEach(line -> {
            OutputView.printWithInformationMark(line.getName());
        });
    }
}
