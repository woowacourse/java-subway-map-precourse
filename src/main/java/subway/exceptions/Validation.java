package subway.exceptions;

public class Validation {
    private final String NAMING_RULE = "이름은 두 글자 이상 입력해야 합니다.";
    private final String LINE_CHECKER = "호선";
    private final String LINE_NAMING_RULE = "OO호선 형태로 입력해야 합니다.";

    public void stationNameValidation(String name) throws SubwayException {
        if (name.length() < 2) {
            throw new SubwayException(NAMING_RULE);
        }
    }

    public void lineNameValidation(String name) throws SubwayException {
        if (!name.substring(name.length() - 2, name.length()).equals(LINE_CHECKER)) {
            throw new SubwayException(LINE_NAMING_RULE);
        }
        if (name.length()-2 < 2) {
            throw new SubwayException(NAMING_RULE);
        }
    }
}
