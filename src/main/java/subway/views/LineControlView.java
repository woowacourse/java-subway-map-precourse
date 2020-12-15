package subway.views;

import java.util.Scanner;
import subway.controller.ErrorValidator;
import subway.controller.LineController;
import subway.domain.LineRepository;

public class LineControlView {

    static final String lineControlScreen = "## 노선 관리 화면";
    static final String lineAdd = "1. 노선 등록";
    static final String lineDelete = "2. 노선 삭제";
    static final String lineSearch = "3. 노선 조회";
    static final String lineAddName = "## 등록할 노선 이름을 입력하세요.";
    static final String lineStartStationMessage = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    static final String lineEndStationMessage = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    static final String lineDeleteName = "## 삭제할 노선 이름을 입력하세요.";
    static final String lineList = "## 노선 목록";
    static final String lineAddSuccess = "지하철 노선이 등록되었습니다.";
    static final String lineDeleteSuccess = "지하철 노선이 삭제되었습니다.";

    public static void showLineControlView(Scanner scanner) {
        System.out.println();
        System.out.println(String
            .join("\n", lineControlScreen, lineAdd, lineDelete, lineSearch, MainView.backToMain,
                "", MainView.selectionMessage));
        String userInput = scanner.next();
        if (ErrorValidator.checkStationLineSelection(userInput)) {
            System.out.println();
            ErrorMessage.showWrongSelectionMessage();
            showLineControlView(scanner);
        }
        if (userInput.equals("1")) {
            showLineAddView(scanner);
            System.out.println();
            MainView.showSelectManager(scanner);
        }
        if (userInput.equals("2")) {
            showLineDeleteView(scanner);
            System.out.println();
            MainView.showSelectManager(scanner);
        }
        if (userInput.equals("3")) {
            showLineSearchView();
            System.out.println();
            MainView.showSelectManager(scanner);
        }
        if (userInput.equals("B")) {
            System.out.println();
            MainView.showSelectManager(scanner);
        }
    }

    public static void showLineAddView(Scanner scanner) {
        System.out.println();
        System.out.println(lineAddName);
        String userInput = scanner.next();
        if (ErrorValidator.checkSameLineName(userInput)) {
            ErrorMessage.showLineSameNameError();
            showLineControlView(scanner);
        }
        if (ErrorValidator.checkNameLength(userInput)) {
            ErrorMessage.showLineNameLengthError();
            showLineControlView(scanner);
        }
        System.out.println();
        System.out.println(lineStartStationMessage);
        String startStation = scanner.next();
        if (!ErrorValidator.checkSameStationName(startStation)) {
            System.out.println();
            System.out.println(ErrorMessage.error + ErrorMessage.stationNotFound);
            showLineControlView(scanner);
        }
        System.out.println();
        System.out.println(lineEndStationMessage);
        String endStation = scanner.next();
        if (!ErrorValidator.checkSameStationName(endStation)) {
            System.out.println();
            System.out.println(ErrorMessage.error + ErrorMessage.stationNotFound);
            showLineControlView(scanner);
        }
        LineController.addStationInLine(userInput, startStation, endStation);
        System.out.println();
        System.out.println(MainView.information + lineAddSuccess);
    }

    public static void showLineDeleteView(Scanner scanner) {
        System.out.println();
        System.out.println(lineDeleteName);
        String userInput = scanner.next();
        LineController.deleteLine(userInput, scanner);
        System.out.println();
        System.out.println(MainView.information + lineDeleteSuccess);
    }


    public static void showLineSearchView() {
        System.out.println();
        System.out.println(lineList);
        for (int i = 0; i < LineRepository.lines().size(); i++) {
            System.out.println(MainView.information + LineRepository.lines().get(i).getName());
        }
    }
}
