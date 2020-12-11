package subway.domain.line;

import java.util.Objects;

public class LineName {
    private static final int MIN_NAME_LENGTH = 2;

    private static final String NAME_LENGTH_ERROR = "[ERROR] 노선 이름은 2자 이상으로 입력해주세요.";
    private static final String NAME_KOREAN_NUMBER_ERROR = "[ERROR] 노선 이름은 한글과 숫자만 입력 가능합니다.";
    private static final String NAME_FORM_ERROR = "[ERROR] 노선 이름은 OO선 형태로 입력해주세요.";
    private static final String KOREAN_NUMBER_REGEXP = "^[0-9가-힣]*$";
    private static final char NAME_END = '선';

    private final String name;
    public LineName(String name) {
        validateLineName(name);
        this.name = name;
    }

    private void validateLineName(String name) {
        validateKoreanAndNumber(name);
        validateNameLength(name);
        validateLineNameForm(name);
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    private void validateKoreanAndNumber(String name) {
        if (!name.matches(KOREAN_NUMBER_REGEXP)) {
            throw new IllegalArgumentException(NAME_KOREAN_NUMBER_ERROR);
        }
    }

    private void validateLineNameForm(String name) {
        if (name.charAt(name.length() - 1) != NAME_END) {
            throw new IllegalArgumentException(NAME_FORM_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineName lineName = (LineName) o;
        return Objects.equals(name, lineName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
