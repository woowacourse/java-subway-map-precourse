package subway.domain.line;

import subway.domain.station.Station;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MIN_INDEX = 1;
    private static final String NAME_LENGTH_ERROR = "[ERROR] 노선 이름은 2자 이상으로 입력해주세요.";
    private static final String NAME_KOREAN_NUMBER_ERROR = "[ERROR] 노선 이름은 한글과 숫자만 입력 가능합니다.";
    private static final String NAME_FORM_ERROR = "[ERROR] 노선 이름은 OO선 형태로 입력해주세요.";
    private static final String INDEX_RANGE_ERROR = "[ERROR] 순서의 범위를 벗어났습니다. 1 ~ %d 까지 입력 가능합니다.";
    private static final String STATION_DUPLICATE_ERROR = "[ERROR] 이미 노선에 해당 역이 동록되어 있습니다.";
    private static final String KOREAN_NUMBER_REGEXP = "^[0-9가-힣]*$";
    private static final char NAME_END = '선';
    private List<Station> stations;
    private String name;

    public Line(String name) {
        validateLineName(name);
        this.name = name;
        stations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현



    public void init(Station firstStation, Station lastStation) {
        stations.add(firstStation);
        stations.add(lastStation);
    }

    public void addStationToLine(Station newStation, int index) {
        validateIndexRange(index);
        stations.add(index - 1, newStation);
        for (Station station : stations) {
            System.out.println(station.getName());
        }
    }

    private void validateIndexRange(int index) {
        if (index < MIN_INDEX || index > stations.size() + 1) {
            throw new IllegalArgumentException(String.format(INDEX_RANGE_ERROR, stations.size() + 1));
        }
    }

    public void validateDuplicateStationToLine(Station newStation) {
        if (stations.contains(newStation)) {
            throw new IllegalArgumentException(STATION_DUPLICATE_ERROR);
        }
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
        Line line = (Line) o;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
