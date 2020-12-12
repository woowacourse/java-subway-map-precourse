package subway.line.validation;

import subway.line.Line;
import subway.line.LineRepository;

import java.util.ArrayList;
import java.util.List;

public class CheckLineNameDuplicate {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NAME_DUPLICATE = ERROR_PREFIX + "이미 등록된 노선 이름입니다.";

    public static void validation(String name) {
        List<Line> lines = LineRepository.lines();
        List<String> lineNames = new ArrayList<>();

        for (Line line : lines) {
            lineNames.add(line.getName());
        }

        if (lineNames.contains(name)) {
            throw new IllegalArgumentException(NAME_DUPLICATE);
        }
    }
}
