package subway.domain.station;

import subway.exception.SubwayProgramException;

import java.util.Objects;

public class StationName {
    private static final String NAME_LENGTH_ERROR = "역 이름은 2자 이상으로 입력해주세요.";
    private static final String NAME_KOREAN_NUMBER_ERROR = "역 이름은 한글과 숫자만 입력 가능합니다.";
    private static final String NAME_FORM_ERROR = "역 이름은 OO역 형태로 입력해주세요.";
    private static final String NAME_DUPLICATE_ERROR = "같은 역은 올 수 없습니다.";
    private static final String KOREAN_REGEXP = "^[0-9가-힣]*$";
    private static final int MIN_NAME_LENGTH = 2;
    private static final char NAME_END = '역';

    private final String name;

    public StationName(String name) {
        validateStationName(name);
        this.name = name;
    }

    private void validateStationName(String name) {
        validateKoreanAndNumber(name);
        validateNameLength(name);
        validateStationNameForm(name);
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new SubwayProgramException(NAME_LENGTH_ERROR);
        }
    }

    private void validateKoreanAndNumber(String name) {
        if (!name.matches(KOREAN_REGEXP)) {
            throw new SubwayProgramException(NAME_KOREAN_NUMBER_ERROR);
        }
    }

    private void validateStationNameForm(String name) {
        if (name.charAt(name.length() - 1) != NAME_END) {
            throw new SubwayProgramException(NAME_FORM_ERROR);
        }
    }

    public void isSame(StationName stationName) {
        if (this.equals(stationName)) {
            throw new SubwayProgramException(NAME_DUPLICATE_ERROR);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationName that = (StationName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
