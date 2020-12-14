package subway.domain;

import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final String DIVIDING_LINE = "---";
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean validateNewStationName(String name) {
        for (int i = 0; i < lines.size(); i++) {
            if (!lines.get(i).validateNewName(name)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateNewLineName(String name) {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public static void runLineMap() {
        OutputView.printLineMapTitle();
        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            OutputView.printLineMapElement(line.getName());
            OutputView.printLineMapElement(DIVIDING_LINE);
            line.runLineMap();
            OutputView.printEmptyLine();
        }
    }
}
