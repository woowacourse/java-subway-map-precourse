package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private static final int LINE_NAME_MINIMUM_LENGTH = 2;
    private static final String ERROR_LINE_NAME_LENGTH = "노선 이름은 두 글자 이상이어야 합니다.";
    private static final String ERROR_LINE_NAME_DUPLICATION = "이미 등록된 노선 이름입니다.";
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    //노선 추가
    public static void addLine(Line line) {
        if (validateAddLine(line)) {
            lines.add(line);
        }
    }

    //노선 삭제
    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }


    //노선 유효성 확인
    private static boolean validateAddLine(Line line) {
        return validateLineNameRange(line) && validateDuplicationLine(line);
    }

    //노선 길이 유효성 확인
    private static boolean validateLineNameRange(Line line) {
        if (line.getName()
                .length() < LINE_NAME_MINIMUM_LENGTH) {
            throw new IllegalArgumentException(ERROR_LINE_NAME_LENGTH);
        }
        return true;
    }

    //노선 중복 유효성 확인
    private static boolean validateDuplicationLine(Line line) {
        if (lines().stream()
                .anyMatch(name -> name.getName().equals(line.getName()))) {
            throw new IllegalArgumentException(ERROR_LINE_NAME_DUPLICATION);
        }
        return true;
    }

    //노선이 존재하는지 확인
    public static boolean hasLine(Line inputLine) {
        return lines().stream()
                .anyMatch(name -> name.getName().equals(inputLine.getName()));
    }
}
