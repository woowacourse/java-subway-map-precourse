package subway.domain;

import subway.view.ErrorView;
import subway.view.OutputView;

import java.util.*;

public class LineRepository {
    private static final String[] LINES = {"2호선", "3호선", "신분당선"};
    private static final String[][] STATIONS = {{"교대역", "강남역", "역삼역"}, {"교대역", "남부터미널역", "양재역", "매봉역"}, {"강남역", "양재역", "양재시민의숲역"}};

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        if (existLine(line.getName())) {
            ErrorView.duplicateName();
            return;
        }
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void init() {
        int index = 0;
        for (String lineName : LINES) {
            Line line = new Line(lineName);
            line.addStations(STATIONS[index++]);
            addLine(line);
        }
    }

    public static boolean lineRegisterStation(String name) {
        for (Line line : lines) {
            if (line.isExistStation(name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean existLine(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
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

    public static Line getLineByName(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                return line;
            }
        }
        return null;
    }

    public static boolean deleteSection(String lineName, Scanner scanner) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                OutputView.writeDeleteStation();
                return line.deleteStation(scanner.next());
            }
        }
        ErrorView.notExistName();
        return false;
    }
}
