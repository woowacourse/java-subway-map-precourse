package subway.domain.station;

import java.util.Objects;

public class Station {
    private static final int MIN_NAME_LENGTH = 2;
    private static final String NAME_LENGTH_ERROR = "[ERROR] 역 이름은 2자 이상으로 입력해주세요.";
    private static final String NAME_KOREAN_ERROR = "[ERROR] 역 이름은 한글만 입력 가능합니다.";
    private static final String NAME_FORM_ERROR = "[ERROR] 역 이름은 OO역 형태로 입력해주세요.";
    private static final String KOREAN_REGEXP = "^[가-힣]*$";
    private static final char NAME_END = '역';
    private final String name;

    public Station(String name) {
        validateStationName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

//    public boolean isStationName(String name) {
//        return this.name.equals(name);
//    }

    private void validateStationName(String name) {
        validateKorean(name);
        validateNameLength(name);
        validateStationNameForm(name);
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    private void validateKorean(String name) {
        if (!name.matches(KOREAN_REGEXP)) {
            throw new IllegalArgumentException(NAME_KOREAN_ERROR);
        }
    }

    private void validateStationNameForm(String name) {
        if (name.charAt(name.length() - 1) != NAME_END) {
            throw new IllegalArgumentException(NAME_FORM_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
