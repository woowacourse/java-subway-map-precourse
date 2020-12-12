package subway.domain.line.service;

import subway.domain.line.model.Line;
import subway.domain.line.model.LineRepository;

import java.util.List;

public class LineService {
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
            throw new IllegalArgumentException();
        }
    }

    public static void remove(Line removedLine) {
        LineRepository.deleteLineByName(removedLine.getName());
    }
}
