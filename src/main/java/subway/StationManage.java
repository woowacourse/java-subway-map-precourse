package subway;

import static subway.domain.StationRepository.addStation;
import static subway.domain.StationRepository.deleteStation;
import static subway.domain.StationRepository.hasStation;
import static subway.domain.StationRepository.stations;

import java.util.List;
import java.util.Scanner;
import subway.domain.Station;

public class StationManage {

    static final String ADD_STATION = "1";
    static final String DELETE_STATION = "2";
    static final String ALL_STATIONS = "3";
    static final String BACK_SCREEN = "B";
    static final int MIN_STATION_NAME_LENGTH = 2;

    static public void stationManage(Scanner scanner) {
        stationManagePrint();
        String stationManageInput = scanner.next();
        inputValidate(scanner, stationManageInput);
    }

    private static void inputValidate(Scanner scanner, String mainInput) {
        if (mainInput.equalsIgnoreCase(ADD_STATION)) {
            addStationPrint(scanner);
            return;
        }
        if (mainInput.equalsIgnoreCase(DELETE_STATION)) {
            deleteStationPrint(scanner);
            return;
        }
        if (mainInput.equalsIgnoreCase(ALL_STATIONS)) {
            allStationsPrint();
            return;
        }
        if (mainInput.equalsIgnoreCase(BACK_SCREEN)) {
            return;
        }
        System.out.println("\n[ERROR] 선택할 수 없는 기능입니다.");
        throw new IllegalArgumentException();
    }

    private static void addStationPrint(Scanner scanner) {
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
        String stationName = scanner.next();
        if (!stationNameLengthValidate(stationName)) {
            System.out.println("\n[ERROR] 역의 이름은 최소 2자 이상이어야 합니다. ");
            throw new IllegalArgumentException();
        }
        if (stationExists(stationName)) {
            System.out.println("\n[ERROR] 이미 등록된 역 이름입니다. ");
            throw new IllegalArgumentException();
        }
        addStation(new Station(stationName));
        System.out.println("\n[INFO] 지하철 역이 등록되었습니다.");
    }

    private static void deleteStationPrint(Scanner scanner) {
        System.out.println("\n## 삭제할 역 이름을 입력하세요.");
        String stationName = scanner.next();
        if (!stationExists(stationName)) {
            System.out.println("\n[ERROR] 존재하지 않는 역 이름입니다. ");
            throw new IllegalArgumentException();
        }
        deleteStation(stationName);
        System.out.println("\n[INFO] 지하철 역이 삭제되었습니다.");
    }

    private static void allStationsPrint() {
        System.out.println("\n## 역 목록");
        List<Station> allStations = stations();
        for (Station station : allStations) {
            station.print();
        }
    }

    private static boolean stationNameLengthValidate(String stationName) {
        return stationName.length() >= MIN_STATION_NAME_LENGTH;
    }

    private static boolean stationExists(String stationName) {
        return hasStation(stationName);
    }

    private static void stationManagePrint() {
        System.out.println("\n## 역 관리 화면\n"
            + "1. 역 등록\n"
            + "2. 역 삭제\n"
            + "3. 역 조회\n"
            + "B. 돌아가기\n"
            + "\n"
            + "## 원하는 기능을 선택하세요.");
    }
}
