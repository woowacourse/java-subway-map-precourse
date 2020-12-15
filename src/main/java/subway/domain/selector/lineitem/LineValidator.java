package subway.domain.selector.lineitem;

import java.util.List;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;

public class LineValidator {

    public static final int MIN_NAME_LENGTH = 2;
    public static final String DUPLICATE_STATION_NAME_ERROR = "[ERROR] 이미 등록되어있는 노선 입니다.";
    public static final String UNDER_NAME_LENGTH_ERROR = "[ERROR] 노선 이름은 2글자 이상이어야 합니다.";
    public static final String NOT_CONTAINS_ERROR = "[ERROR] 입력하신 노선은 등록되지 않았습니다.";

    public void validateAddLine(String name) {
        validateNameDuplication(name);
        validateNameLength(name);
    }

    private void validateNameDuplication(String name) {
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                throw new IllegalArgumentException(DUPLICATE_STATION_NAME_ERROR);
            }
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(UNDER_NAME_LENGTH_ERROR);
        }
    }

    public void validateContainsLines(String name) {
        List<Line> lines = LineRepository.lines();

        for (Line line : lines) {
            if (name.equals(line.getName())) {
                return;
            }
        }
        throw new IllegalArgumentException(NOT_CONTAINS_ERROR);
    }

}
