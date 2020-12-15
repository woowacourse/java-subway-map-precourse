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
        if (!checkBeforeAddPathInLine(findLine, inputStation, inputIndex)) {
            return false;
        }
        getLine(findLine).getPath().addOneStationBetweenStations(StationRepository.getStation(inputStation), inputIndex);
        return true;
    }

    private static boolean checkBeforeAddPathInLine(String findLine, String inputStation, int inputIndex) {
        Line line = getLine(findLine);
        if (line == null) {
            OutputView.printDoesNotExistErrorMessage(findLine);
            return false;
        }
        Station station = StationRepository.getStation(inputStation);
        if (line.getPath().isStationInLine(station)) {
            OutputView.printSameStationAlreadyInLineError(station.getName());
            return false;
        }
        Path path = line.getPath();
        if (path.getSize() <= inputIndex) {
            OutputView.printIndexOutOfRange();
            return false;
        }
        return true;
    }

    public static boolean deletePathInLine(String findLine, String deleteStation) {
        Line line = getLine(findLine);
        if (line == null || !line.getPath().isStationInLine(StationRepository.getStation(deleteStation))) {
            OutputView.printDoesNotExistErrorMessage(findLine);
            return false;
        }
        getLine(findLine).getPath().checkSizeBeforeDeleteStation(StationRepository.getStation(deleteStation));
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
            if (line.getName().equals(checkedLineName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isStationInLine(Station station) {
        for (Line line : lines) {
            if (line.getPath().isStationInLine(station)) {
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
