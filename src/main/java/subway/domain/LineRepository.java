package subway.domain;

import subway.view.ErrorView;
import subway.view.OutputView;

import java.util.*;

public class LineRepository {
    private static final String[] LINES = {"2호선", "3호선", "신분당선"};
    private static final String[][] STATIONS = {{"교대역", "강남역", "역삼역"}, {"교대역", "남부터미널역", "양재역", "매봉역"}, {"강남역", "양재역", "양재시민의숲역"}};
    private static int INDEX = 0;

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        if (isExistLine(line.getName())) {
            ErrorView.duplicateName();
            return;
        }
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void init() {
        for (String lineName : LINES) {
            Line line = new Line(lineName);
            line.addStations(STATIONS[INDEX++]);
            addLine(line);
        }
    }

    public static boolean isLineRegisterStation(String stationName) {
        for (Line line : lines) {
            if (line.isExistStation(stationName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isExistLine(String lineName) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return true;
            }
        }
        return false;
    }

    public static void allStatus() {
        for (Line line : lines) {
            OutputView.status(line.getName());
            line.status();
        }
    }

    public static void lineStatus() {
        for (Line line : lines) {
            OutputView.status(line.getName());
        }
        OutputView.space();
    }

    public static Line getLineByName(String lineName) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return line;
            }
        }
        return null;
    }

    public static boolean deleteSection(String lineName, Scanner scanner) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return line.deleteStation(scanner);
            }
        }
        ErrorView.notExistName();
        return false;
    }

    public static boolean isDuplicateLine(String lineName) {
        for(Line line : lines){
            if(line.getName().equals(lineName)){
                return true;
            }
        }
        return false;
    }
}
