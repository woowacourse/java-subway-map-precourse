package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.common.ErrorMessageException;
import subway.domain.SubwayRepository;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    private static final String FAIL_TO_DELETE = "노선을 삭제하지 못했습니다.";
    private static final String NOT_FOUND_LINE = "존재하지 않는 노선입니다.";

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
        SubwayRepository.deleteSubwayLineByName(name);
    }

    public static Line findLine(String name) {
        return lines.stream().filter(item -> Objects.equals(item.getName(), name)).findFirst()
            .orElseThrow(() -> new ErrorMessageException(NOT_FOUND_LINE));
    }

    public static boolean containsName(String lineName) {
        return lines.stream().anyMatch(item -> Objects.equals(item.getName(), lineName));
    }
}
