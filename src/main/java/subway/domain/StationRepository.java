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

    public static boolean addStation(Station station) {
        stations.add(station);
        return true;
    }

    public static boolean isPossibleStation(String stationName) {
        System.out.println();
        if (InputTool.isValidName(stationName) == false) {
            OutputView.printError("지하철 역 이름은 2글자 이상이어야 합니다.");
            return false;
        }
        if (isExistStation(stationName) == true) {
            OutputView.printError("이미 등록된 역 이름입니다.");
            return false;
        }
        Station newStation = new Station(stationName);
        addStation(newStation);
        OutputView.printInfo("지하철 역이 등록되었습니다.");
        return true;
    }
    public static boolean deleteStation(String name) {
        if(LineRepository.isContainStationInLines(name)){
            OutputView.printError("노션에 등록된 역은 삭제할 수 없습니다");
            return false;
        }
        boolean isDelete =stations.removeIf(station -> Objects.equals(station.getName(), name));
        if(isDelete){
            OutputView.printInfo("지하철 역이 삭제되었습니다.");
            return true;
        }
        OutputView.printError("삭제할 지하철 역이 없습니다");
        return false;
    }

    public static boolean lookUpStation() {
        System.out.println();
        System.out.println("## 역 목록");
        Iterator<Station> itr = stations.iterator();
        while (itr.hasNext()) {
            OutputView.printInfo(itr.next().getName());
        }
        System.out.println();
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
