package subway.util;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

import java.util.List;

public class SectionValidator {
    private static final int SIZE = 2;

    public static boolean checkValidStation(String name, List<Station> stationList) {
        for (Station station : stationList) {
            if (station.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkValidIndex(String index, String lineName) {
        int lineSize = LineRepository.findLineByName(lineName).size();
        if (Integer.parseInt(index) > 0 && Integer.parseInt(index) <= lineSize) {
            return true;
        }
        System.out.println("[ ERROR ] 유효하지 않은 순서입니다.(현재 노선의 최대 크기 : " + lineSize + ")");
        return false;
    }

    public static boolean checkRemovableSection(String lineName, String stationName) {
        if (haveSection(lineName, stationName) && checkValidDelete(lineName)) {
            return true;
        }
        return false;
    }

    public static boolean haveSection(String lineName, String stationName) {
        Line line = LineRepository.findLineByName(lineName);
        for (Station station : line.stationList()) {
            if (station.getName().equals(stationName)) {
                return true;
            }
        }
        System.out.println("[ ERROR ] 구간에 존재하지 않는 역입니다.");
        return false;
    }

    public static boolean checkValidDelete(String lineName) {
        Line line = LineRepository.findLineByName(lineName);
        if (line.stationList().size() <= SIZE) {
            System.out.println("[ ERROR ] 상행선 종점과 하행선 종점만 남았을 때는 구간을 삭제할 수 없습니다.");
            return false;
        }
        return true;
    }

}
