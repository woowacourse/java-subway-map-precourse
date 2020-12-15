package subway.domain;

import java.util.Scanner;

import static subway.Application.startProgram;

public class StationManage {
    public static void manageStation(Scanner kbd) {
        View.showStationMenu();
        String input = InputView.inputFunction(kbd, Constants.SUB_FUNCTIONS);
        if (input.equals(Constants.ADD_MENU))
            addStation(kbd);
        if (input.equals(Constants.DELETE_MENU))
            deleteStation(kbd);
        if (input.equals(Constants.SEARCH_MENU))
            searchStation(kbd);
        if (input.equalsIgnoreCase(Constants.GO_BACK_MENU))
            startProgram(kbd);
    }

    public static void addStation(Scanner kbd) {
        try {
            System.out.println("\n## 등록할 역 이름을 입력하세요.");
            String stationName = kbd.nextLine();
            Errors.checkSameStation(stationName);
            Errors.checkTextLength(stationName);
            StationRepository.addStation(new Station(stationName));
            System.out.println("\n[INFO] 지하철 역이 등록되었습니다.");
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }

    public static void deleteStation(Scanner kbd) {
        try {
            System.out.println("\n## 삭제할 역 이름을 입력하세요.");
            String stationName = kbd.nextLine();
            Errors.checkExistStation(stationName);
            Errors.checkInLine(stationName);
            StationRepository.deleteStation(stationName);
            System.out.println("\n[INFO] 지하철 역이 삭제되었습니다.");
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }

    public static void searchStation(Scanner kbd) {
        System.out.println("\n## 역 목록");
        for (Station station : StationRepository.stations())
            System.out.println("[INFO] " + station.getName());
        startProgram(kbd);
    }
}
