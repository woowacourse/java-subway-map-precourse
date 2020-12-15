package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.common.ErrorMessageException;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    private static final String FAIL_TO_DELETE = "노선을 삭제하지 못했습니다.";
    private static final String NOT_FOUND_LINE = "노선을 찾지 못했습니다.";

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void deleteLineByName(String name) {
        if(!lines.removeIf(line -> Objects.equals(line.getName(), name))){
            throw new ErrorMessageException(FAIL_TO_DELETE);
        }
    }

    public static Line findLineByName(String name) {
        return lines.stream().filter(line -> Objects.equals(line.getName(), name)).findFirst()
            .orElseThrow(() -> new ErrorMessageException(NOT_FOUND_LINE));
    }

    public static boolean containsName(String lineName) {
        return lines.stream().anyMatch(item -> Objects.equals(item.getName(), lineName));
    }
}
