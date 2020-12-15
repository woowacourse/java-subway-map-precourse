package subway.domain;

import subway.exception.LineAlreadyExistException;
import subway.exception.LineEmptyException;
import subway.exception.LineNotExistException;
import subway.exception.StationAlreadyExistException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void validateAlreadyExists(String lineName){
        if(contains(lineName)){
            throw new LineAlreadyExistException();
        }
    }

    public static boolean contains(String lineName) {
        for(Line line : lines){
            if(line.getName().equals(lineName)){
                return true;
            }
        }
        return false;
    }

    public static Line findLine(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                return line;
            }
        }
        throw new LineNotExistException();
    }

    public static void deleteLine(Line line) {
        if (lines.isEmpty()) {
            throw new LineEmptyException();
        }
        if (lines.contains(line)) {
            lines.remove(line);
            return;
        }
        throw new LineNotExistException();
    }
}
