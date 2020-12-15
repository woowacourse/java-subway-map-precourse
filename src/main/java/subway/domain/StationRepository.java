package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.utils.PrintUtils;

/**
 * 지하철 역 객체를 관리하는 클래스
 *
 * @author 483759@naver.com / 윤이진
 * @version 1.0 2020/12/10
 */
public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();
    private static final PrintUtils printUtils = new PrintUtils();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean isStationExist(Station newStation) {
        for (Station station : stations) {
            if (station.getName().equals(newStation.getName())) {
                return true;
            }
        }
        return false;
    }

    public static void printStationsList() {
        for (Station station : stations) {
            printUtils.printStation(station.getName());
        }
        System.out.println("");
    }
}
