package subway.domain;

import subway.tool.InputTool;
import subway.view.OutputView;

import java.util.*;
import java.util.logging.ErrorManager;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static boolean addStation(String stationName) {
        if (InputTool.isValidName(stationName) == false) {
            OutputView.printError("지하철 역 이름은 2글자 이상이어야 합니다.");
            return false;
        }
        if (isExistStation(stationName) == true) {
            OutputView.printError("이미 등록된 역 이름입니다.");
            return false;
        }
        Station newStation = new Station(stationName);
        stations.add(newStation);
        OutputView.printInfo("지하철 역이 등록되었습니다.");
        return true;
    }

    public static boolean deleteStation(String name) {
        OutputView.printInfo("지하철 역이 삭제되었습니다.");
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean lookUpStation() {
        Iterator<Station> itr = stations.iterator();
        while (itr.hasNext()) {
            OutputView.printInfo(itr.next().getName());
        }
        return true;
    }

    public static boolean isExistStation(String name) {
        Iterator<Station> itr = stations.iterator();
        while (itr.hasNext()) {
            if (itr.next().isEqual(name) == true) return true;
        }
        return false;
    }

}
