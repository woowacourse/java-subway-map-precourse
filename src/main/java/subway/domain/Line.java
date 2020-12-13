package subway.domain;

public class Line {

    private static final String WHITE_SPACE = " ";
    private static final String RULE_STATION_NAME = "선";
    private static final int LAST_INDEX = 1;
    private static final int MINIMUM_NAME_LENGTH = 3;

    private final String name;

    private Line(String name) {
        validateNameLastCharacter(name);
        validateNameContainWhitepace(name);
        validateNameLength(name);
        this.name = name;
    }

    public static Line newLineWithName(String lineName) {
        return new Line(lineName);
    }

    public String getName() {
        return name;
    }

    private void validateNameLastCharacter(String name) {
        if (!name.substring(name.length() - LAST_INDEX).equals(RULE_STATION_NAME)) {
            throw new IllegalArgumentException("지하철 노선 이름은 \"선\"으로 끝나야 합니다.");
        }
    }

    private void validateNameContainWhitepace(String name) {
        if (name.contains(WHITE_SPACE)) {
            throw new IllegalArgumentException("지하철 노선 이름에 공백이 포함될 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("지하철 노선 이름은 2글자 이상 + \"선\"으로 이루어져야 합니다.");
        }
    }
}
