package subway.util;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class LineValidator {

    private static final int SIZE = 2;

    public static boolean checkValidLineName(String name) {
        return !checkDuplicateName(name) && checkValidName(name);
    }

    public static boolean checkDuplicateName(String name) {
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(name)) {
                System.out.println("[ ERROR ] 이미 존재하는 노선입니다.\n");
                return true;
            }
        }
        return false;
    }

    public static boolean checkValidName(String name) {
        if (name.length() >= SIZE) {
            return true;
        }
        System.out.println("[ ERROR ] 노선 이름은 2글자 이상이어야 합니다.\n");
        return false;
    }

    public static boolean haveLineName(String name) {
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(name)) {
                return true;
            }
        }
        System.out.println("[ ERROR ] 등록 되지않은 노선입니다.\n");
        return false;
    }

    public static boolean checkValidDownLastStop(String upName, String downName) {
        if (StationValidator.haveStationName(downName) && !isSameStation(upName, downName)) {
            return true;
        }
        return false;
    }

    public static boolean isSameStation(String upName, String downName) {
        if (upName.equals(downName)) {
            System.out.println("[ ERROR ] 상행선종점과 하행선종점은 각각 다른 지하철 역이어야 합니다.");
            return true;
        }
        return false;
    }
}
