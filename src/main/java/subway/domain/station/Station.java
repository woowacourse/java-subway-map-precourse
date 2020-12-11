package subway.domain.station;

import java.util.ArrayList;
import java.util.List;
import subway.domain.line.Line;
import subway.view.OutputView;

public class Station {

    public static final int MIN_NAME_LENGTH = 2;

    private String name;
    private List<Line> includedLine = new ArrayList<>();

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void validateName(String name) {
        validateLength(name);
    }

    private static void validateLength(String name) {
        if (shorterThanMinimalLength(name)) {
            throw new IllegalArgumentException(OutputView.ERROR_NAME_SHORT);
        }
    }

    private static boolean shorterThanMinimalLength(String name) {
        return name.length() < MIN_NAME_LENGTH;
    }

    public boolean isIncluded() {
        return includedLine.size() != 0;
    }

    public void includeLine(Line line) {
        includedLine.add(line);
    }

    public void removeLine(Line line) {
        includedLine.remove(line);
    }
}
