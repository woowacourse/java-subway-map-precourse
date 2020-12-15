package subway.views;

import java.util.Scanner;
import subway.controller.ErrorValidator;
import subway.controller.StationController;
import subway.domain.StationRepository;

public class StationControlView {

    static final String stationControlScreen = "## 역 관리 화면";
    static final String stationAdd = "1. 역 등록";
    static final String stationDelete = "2. 역 삭제";
    static final String stationSearch = "3. 역 조회";
    static final String stationAddName = "## 등록할 역 이름을 입력하세요.";
    static final String stationDeleteName = "## 삭제할 역 이름을 입력하세요.";
    static final String stationList = "## 역 목록";
    static final String stationAddSuccess = "지하철 역이 등록되었습니다.";
    static final String stationDeleteSuccess = "지하철 역이 삭제되었습니다.";

    public static void showStationControlView(Scanner scanner) {
        System.out.println();
        System.out.println(String
            .join("\n", stationControlScreen, stationAdd, stationDelete, stationSearch,
                MainView.backToMain,
                "", MainView.selectionMessage));
        String userInput = scanner.next();
        if (ErrorValidator.checkStationLineSelection(userInput)) {
            System.out.println();
            ErrorMessage.showWrongSelectionMessage();
            showStationControlView(scanner);
        }
        if (userInput.equals("1")) {
            showStationAddView(scanner);
            System.out.println();
            MainView.showSelectManager(scanner);
        }
        if (userInput.equals("2")) {
            showStationDeleteView(scanner);
            System.out.println();
            MainView.showSelectManager(scanner);
        }
        if (userInput.equals("3")) {
            showStationSearchView();
            System.out.println();
            MainView.showSelectManager(scanner);
        }
        if (userInput.equals("B")) {
            System.out.println();
            MainView.showSelectManager(scanner);
        }
    }

    public static void showStationAddView(Scanner scanner) {
        System.out.println();
        System.out.println(stationAddName);
        String userInput = scanner.next();
        System.out.println();
        StationController.addStation(userInput, scanner);
        System.out.println(MainView.information + stationAddSuccess);
    }

    public static void showStationDeleteView(Scanner scanner) {
        System.out.println();
        System.out.println(stationDeleteName);
        String userInput = scanner.next();
        System.out.println();
        StationController.deleteStation(userInput, scanner);
        System.out.println(MainView.information + stationDeleteSuccess);
    }

    public static void showStationSearchView() {
        System.out.println();
        System.out.println(stationList);
        for (int i = 0; i < StationRepository.stations().size(); i++) {
            System.out
                .println(MainView.information + StationRepository.stations().get(i).getName());
        }
    }
}
