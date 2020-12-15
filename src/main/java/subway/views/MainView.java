package subway.views;

import java.util.Scanner;
import subway.controller.ErrorValidator;
import subway.controller.LineController;
import subway.controller.SectionController;
import subway.controller.StationController;

public class MainView {

    static final String mainScreen = "## 메인 화면";
    static final String stationManagement = "1. 역 관리";
    static final String lineManagement = "2. 노선 관리";
    static final String sectionManagement = "3. 구간 관리";
    static final String subwayMap = "4. 지하철 노선도 출력";
    static final String quit = "Q. 종료";
    static final String backToMain = "B. 돌아가기";
    static final String selectionMessage = "## 원하는 기능을 선택하세요.";
    static final String information = "[INFO] ";
    static final String intersection = "---";


    public static void showSelectManager(Scanner scanner) {
        System.out.println();
        System.out.println(String
            .join("\n", mainScreen, stationManagement, lineManagement, sectionManagement, subwayMap,
                quit, "", selectionMessage));
        String functionChoice = scanner.next();
        if (ErrorValidator.checkSelectManage(functionChoice)) {
            System.out.println();
            ErrorMessage.showWrongSelectionMessage();
            showSelectManager(scanner);
        }
        if (functionChoice.equals("1")) {
            StationController.manageStation(scanner);
        }
        if (functionChoice.equals("2")) {
            LineController.manageLine(scanner);
        }
        if (functionChoice.equals("3")) {
            SectionController.manageSection(scanner);
        }
        if (functionChoice.equals("4")) {
            TotalSubwayMapView.showTotalSubwayMap(scanner);
        }
    }
}
