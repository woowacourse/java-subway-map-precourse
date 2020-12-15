package subway.domain;

import java.util.Scanner;

import static subway.Application.startProgram;

public class SectionManage {
    public static void manageSection(Scanner kbd) {
        View.showSectionMenu();
        String input = InputView.inputFunction(kbd, Constants.SECTION_FUNCTIONS);
        if (input.equals(Constants.ADD_MENU))
            addSection(kbd);
        if (input.equals(Constants.DELETE_MENU))
            deleteSection(kbd);
        if (input.equals(Constants.GO_BACK_MENU))
            startProgram(kbd);
    }

    public static void addSection(Scanner kbd) {
        try {
            makeNewSection(kbd);
            System.out.println("\n[INFO] 구간이 등록되었습니다.");
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }

    public static void makeNewSection(Scanner kbd) {
        System.out.println("\n## 노선을 입력하세요.");
        String lineName = kbd.nextLine();
        Errors.checkExistLine(lineName);
        System.out.println("\n## 역이름을 입력하세요.");
        String stationName = kbd.nextLine();
        Errors.checkExistStation(stationName);
        Line line = Errors.checkInSpecificLine(lineName, stationName);
        System.out.println("\n## 순서를 입력하세요.");
        String index = kbd.nextLine();
        Errors.checkValidIndex(line, index);
        LineRepository.addStationToLine(lineName, stationName, Integer.parseInt(index));
    }

    public static void deleteSection(Scanner kbd) {
        try {
            System.out.println("\n## 삭제할 구간의 노선을 입력하세요.");
            String lineName = kbd.nextLine();
            Errors.checkExistLine(lineName);
            Errors.checkValidLine(lineName);
            System.out.println("\n## 삭제할 구간의 역을 입력하세요.");
            String stationName = kbd.nextLine();
            Errors.checkNotInSpecificLine(lineName, stationName);
            LineRepository.deleteStationInLine(lineName, stationName);
            System.out.println("\n[INFO] 구간이 삭제되었습니다.");
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }
}
