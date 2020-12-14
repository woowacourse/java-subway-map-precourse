package subway.utils;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.view.ErrorView;

public class LineRepositoryValidator {

    public static void validateAddition(Line line) {
        validateNoDuplicate(line);
    }

    public static void validateDeletion(String name) {
        validateExisting(name);
    }

    private static void validateNoDuplicate(Line line) {
        if (isDuplicate(line)) {
            throw new IllegalArgumentException(ErrorView.NAME_DUPLICATE);
        }
    }

    private static boolean isDuplicate(Line line) {
        return LineRepository.hasLine(line);
    }

    private static void validateExisting(String name) {
        if (!isDuplicate(name)) {
            throw new IllegalArgumentException(ErrorView.LINE_NOTHING);
        }
    }

    private static boolean isDuplicate(String name) {
        return LineRepository.lines().stream()
                .map(Line::getName)
                .anyMatch(x -> x.equals(name));
    }
}
