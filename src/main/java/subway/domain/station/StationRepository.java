package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.commonprint.Prefix;
import subway.function.station.StationManagementPrinter;

/*
필요 시 StationRepository, LineRepository 이 외 추가로 Repository를 만들 수 있다.
추가로 생성되는 객체에 대해서 XXXRepository 네이밍으로 저장 클래스를 추가할 수 있다.
객체들의 상태를 관리하기 위해서 XXXRepository 클래스를 활용해 저장 로직을 구현해야 한다.
필요에 따라 자유롭게 수정이 가능하다.
* */
public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void printAll() {
        StationManagementPrinter.printStationListTitle();
        stations.forEach(
            station -> {
                System.out.println(Prefix.INFO_PREFIX + station.getName());
            }
        );
    }

    public static Station findByName(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return station;
            }
        }
        return null;
    }
}
