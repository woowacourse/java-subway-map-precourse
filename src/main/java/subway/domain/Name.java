package subway.domain;

public class Name {
    private static final int MINIMUM_LENGTH = 2;
    private static final String LENGTH_UNAVAILABLE = "\n[ERROR] 이름의 길이는 2자 이상이어야 합니다.";
    private static final String NAME_REGEX = "^[가-힣|0-9]*$";
    private static final String NOT_KOREAN_AND_NUMBER_NAME = "\n[ERROR] 이름은 올바른 한글과 숫자만 가능합니다.";

    private final String name;

    public Name(String name) {
        isNameLongerThanTwo(name);
        isKoreanName(name);
        this.name = name;
    }

    private void isNameLongerThanTwo(String name) {
        if (name.length() < MINIMUM_LENGTH) {
            throw new IllegalArgumentException(LENGTH_UNAVAILABLE);
        }
    }

    private void isKoreanName(String name) {
        if (!name.matches(NAME_REGEX)) {
            throw new IllegalArgumentException(NOT_KOREAN_AND_NUMBER_NAME);
        }
    }

    public String getName() {
        return name;
    }
}
