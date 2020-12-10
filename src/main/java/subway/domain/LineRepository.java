package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.exception.SubwayCustomException;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();
    public static final String NOT_VALID_LINE_EXCEPTION_MESSAGE = "존재하지 않는 노선입니다.";

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void deleteLine(String name) {
        if(!(lines.removeIf(line -> Objects.equals(line.getName(), name)))){
            throw new SubwayCustomException(NOT_VALID_LINE_EXCEPTION_MESSAGE);
        }
    }

    public static Line searchLine(String name){
        return lines.stream()
            .filter(line -> Objects.equals(line.getName(), name))
            .findFirst()
            .orElseThrow(()->new SubwayCustomException(NOT_VALID_LINE_EXCEPTION_MESSAGE));
    }
}
