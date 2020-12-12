package subway.domain.line.service;

import subway.domain.line.model.Line;
import subway.domain.line.model.LineRepository;

import java.util.List;

public class LineService {
    private static final String NOT_DUPLICATION_LINE_NAME_MESSAGE = "[ERROR] 중복된 노선 이름은 등록할 수 없습니다.";

    public static List<Line> findAll() {
        return LineRepository.lines();
    }

    public static void save(Line line) {
        validateDuplicationLine(line);
        LineRepository.addLine(line);
    }

    private static void validateDuplicationLine(Line line) {
        List<Line> lines = LineRepository.lines();
        boolean isDuplicated = lines.stream()
                .anyMatch(savedLine -> savedLine.isEqualTo(line));

        if (isDuplicated) {
            throw new IllegalArgumentException(NOT_DUPLICATION_LINE_NAME_MESSAGE);
        }
    }

    public static void remove(Line removedLine) {
        LineRepository.deleteLineByName(removedLine.getName());
    }
}
