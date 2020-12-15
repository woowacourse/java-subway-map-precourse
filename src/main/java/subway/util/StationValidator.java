package subway.util;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationValidator {

    private static final int SIZE = 2;

    public static boolean checkValidStationName(String name) {
        if (checkValidName(name) && !checkDuplicateName(name)) {
            return true;
        }
        return false;
    }

    public static boolean checkDuplicateName(String name) {
        for(Station station : StationRepository.stations()) {
            if (station.getName().equals(name)) {
                System.out.println("[ ERROR ] 이미 존재하는 역입니다.\n");
                return true;
            }
        }
        return false;
    }

    public static boolean checkValidName(String name) {
        if (name.length() >= SIZE) {
            return true;
        }
        System.out.println("[ ERROR ] 역 이름은 2글자 이상이어야합니다.\n");
        return false;
    }

    public static boolean checkRemovableStation(String name) {
        if (haveStationName(name) && checkValidRemoveStation(name)) {
            return true;
        }
        return false;
    }

    public static boolean checkValidRemoveStation(String name) {
        Station station = StationRepository.findStationByName(name);
        if (station.isRemovable()) {
            return true;
        }
        System.out.println("[ ERROR ] 노선과 연결되어 있어서 삭제할 수 없는 역입니다.\n");
        return false;
    }

    public static boolean haveStationName(String name) {
        for(Station station : StationRepository.stations()) {
            if (station.getName().equals(name)) {
                return true;
            }
        }
        System.out.println("[ ERROR ] 등록 되지않은 지하철 역입니다.\n");
        return false;
    }
}
