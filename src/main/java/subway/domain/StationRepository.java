package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {

    private static final int STATION_NAME_MINIMUM_LENGTH = 2;
    private static final String ERROR_STATION_NAME_LENGTH = "지하철 역 이름은 두 글자 이상이어야 합니다.";
    private static final String ERROR_STATION_NAME_DUPLICATION = "이미 등록된 역 이름입니다.";
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    //역 추가
    public static void addStation(Station station) {
        if (validate(station)) {
            stations.add(station);
        }
    }

    //역 삭제
    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    //역 유효성 확인
    private static boolean validate(Station station) {
        return (validateStationNameRange(station) && validateDuplicationStation(station));
    }

    //역 길이 유효성 확인
    private static boolean validateStationNameRange(Station station) {
        if (station.getName()
                .length() < STATION_NAME_MINIMUM_LENGTH) {
            throw new IllegalArgumentException(ERROR_STATION_NAME_LENGTH);
        }
        return true;
    }

    //역 중복 유효성 확인
    private static boolean validateDuplicationStation(Station station) {
        if (stations().stream()
                .anyMatch(name -> name.getName().equals(station.getName()))) {
            throw new IllegalArgumentException(ERROR_STATION_NAME_DUPLICATION);
        }
        return true;
    }

    //구간 역 업데이트
    public static void updateStation(Station inputStationName) {
        if (!hasStation(inputStationName)) {
            addStation(inputStationName);
        }
    }

    //구간에 포함되엉 있는 역인지 확인
    public static boolean hasStation(Station station) {
        return stations().stream()
                .anyMatch(name -> name.getName().equals(station.getName()));
    }
}
