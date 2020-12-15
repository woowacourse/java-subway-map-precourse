package subway;

import static subway.domain.StationRepository.addStation;

import java.util.Scanner;
import subway.domain.Station;

public class StationManage {
    static final String stationAddInput = "1";
    static final String stationDeleteInput = "2";
    static final String stationsGetInput = "3";
    static final String backScreenInput = "B";
    static final int stationNameMinLength = 2;

    static public void stationManage(Scanner scanner) {
        stationManagePrint();
        boolean validateFlag = true;
        String stationManageInput = scanner.next();
        validateFlag = inputValidate(scanner, stationManageInput);

    }

    private static boolean inputValidate(Scanner scanner, String mainInput) {
        if (mainInput.equalsIgnoreCase(stationAddInput)) {
            addStationPrint(scanner);
            return true;
        }
        if (mainInput.equalsIgnoreCase(backScreenInput)) {
            return true;
        }
        System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
        throw new IllegalArgumentException();
    }

    private static void addStationPrint(Scanner scanner) {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        String stationName = scanner.next();
        if (!stationNameLengthValidate(stationName)) {
            System.out.println("[ERROR] 역의 이름은 최소 2자 이상이어야 합니다.");
            throw new IllegalArgumentException();
        }
        addStation(new Station(stationName));
    }

    private static boolean stationNameLengthValidate(String stationName) {
        if (stationName.length() < stationNameMinLength) {
            return false;
        }
        return true;
    }

    private static void stationManagePrint() {
        System.out.println("## 역 관리 화면\n"
            + "1. 역 등록\n"
            + "2. 역 삭제\n"
            + "3. 역 조회\n"
            + "B. 돌아가기\n"
            + "\n"
            + "## 원하는 기능을 선택하세요.");
    }
}
