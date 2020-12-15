package subway.line.validation;

import subway.common.Prefix;
import subway.line.Line;
import subway.line.LineRepository;

import java.util.ArrayList;
import java.util.List;

public class CheckLineNameDuplicate {
    private static final String NAME_DUPLICATE = Prefix.ERROR.getPrefix() + "이미 등록된 노선 이름입니다.";

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
