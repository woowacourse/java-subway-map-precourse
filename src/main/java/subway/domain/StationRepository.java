package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {

    private static final String WHITE_SPACE = " ";
    private static final int EMPTY_STATIONS = 0;
    private static final int LAST_INDEX = 1;
    private static final int MINIMUM_NAME_LENGTH = 3;
    private static final String RULE_STATION_NAME = "역";

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        validateStationsEmpty();
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(String name) {
        validateNameLastCharacter(name);
        validateNameContainWhitepace(name);
        validateNameLength(name);
        validateNameDuplicate(name);
        stations.add(new Station(name));
    }

    public static Station findStation(String name) {
        Station foundStation = null;
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                foundStation = station;
                break;
            }
        }
        return foundStation;
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static void validateStationsEmpty() {
        if (stations.size() == EMPTY_STATIONS) {
            throw new IllegalArgumentException("등록 되어 있는 지하철 역이 없습니다.");
        }
    }

    private static void validateNameLastCharacter(String name) {
        if (!name.substring(name.length() - LAST_INDEX).equals(RULE_STATION_NAME)) {
            throw new IllegalArgumentException("지하철 역 이름은 \"역\"으로 끝나야 합니다.");
        }
    }

    private static void validateNameContainWhitepace(String name) {
        if (name.contains(WHITE_SPACE)) {
            throw new IllegalArgumentException("지하철 역 이름에 공백이 포함될 수 없습니다.");
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("지하철 역 이름은 2글자 이상 + \"역\"으로 이루어져야 합니다.");
        }
    }

    private static void validateNameDuplicate(String name) {
        if (stations.stream()
            .anyMatch(station -> station.getName().equals(name))) {
            throw new IllegalArgumentException("동일한 지하철 역 이름이 존재합니다.");
        }
    }
}