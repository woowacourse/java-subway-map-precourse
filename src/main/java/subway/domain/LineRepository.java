package subway.domain;

import subway.view.LineMessages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    static {
        /* - 2호선: 교대역 - 강남역 - 역삼역
        - 3호선: 교대역 - 남부터미널역 - 양재역 - 매봉역
        - 신분당선: 강남역 - 양재역 - 양재시민의숲역 */
        addLine(new Line("2호선", "교대역", "역삼역"));
        addLine(new Line("3호선", "교대역", "매봉역"));
        addLine(new Line("신분당선","강남역", "양재시민의숲역"));
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLine(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line getLine(String lineName) throws IllegalArgumentException {
        return LineRepository.lines().stream()
                .filter(line -> line.getName().equals(lineName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(LineMessages.UNREGISTERED_NAME_ERROR.getMessage()));
    }

    public static boolean hasName(String name) {
        return LineRepository.lines().stream()
                .map(Line::getName)
                .anyMatch(lineName -> lineName.equals(name));
    }

    public static void validateDuplicate(String name) throws IllegalArgumentException {
        if (hasName(name)) {
            throw new IllegalArgumentException(LineMessages.DUPLICATE_NAME_ERROR.getMessage());
        }
    }

    public static void validateRegistration(String name) throws IllegalArgumentException {
        if (!hasName(name)) {
            throw new IllegalArgumentException(LineMessages.UNREGISTERED_NAME_ERROR.getMessage());
        }
    }
}
