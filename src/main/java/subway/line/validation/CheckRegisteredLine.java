package subway.line.validation;

import subway.line.Line;
import subway.line.LineRepository;

import java.util.ArrayList;
import java.util.List;

public class CheckRegisteredLine {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NOT_EXIST = ERROR_PREFIX + "등록되지 않은 노선입니다.";

    public static void validation(String name) {
        List<Line> lines = LineRepository.lines();
        List<String> lineNames = new ArrayList<>();

        for (Line line : lines) {
            lineNames.add(line.getName());
        }

        if (!lineNames.contains(name)) {
            throw new IllegalArgumentException(NOT_EXIST);
        }
    }
}
