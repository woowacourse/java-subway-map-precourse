package subway.views;

import java.util.Scanner;
import subway.controller.ErrorValidator;
import subway.controller.SectionController;

public class SectionControlView {

    static final String sectionControlScreen = "## 구간 관리 화면";
    static final String sectionAdd = "1. 구간 등록";
    static final String sectionDelete = "2. 구간 삭제";
    static final String lineNameMessage = "## 노선을 입력하세요.";
    static final String stationNameMessage = "## 역이름을 입력하세요.";
    static final String positionMessage = "## 순서를 입력하세요.";
    static final String sectionAddSuccessMessage = "구간이 등록되었습니다";
    static final String sectionDeleteLineMessage = "## 삭제할 구간의 노선을 입력하세요.";
    static final String sectionDeleteStationMessage = "## 삭제할 구간의 역을 입력하세요.";
    static final String sectionDeleteSuccessMessage = "구간이 삭제되었습니다";

    public static void showSectionControlView(Scanner scanner) {
        System.out.println();
        System.out.println(String
            .join("\n", sectionControlScreen, sectionAdd, sectionDelete, MainView.backToMain,
                "", MainView.selectionMessage));
        String userInput = scanner.next();
        if (ErrorValidator.checkSectionSelection(userInput)) {
            System.out.println();
            ErrorMessage.showWrongSelectionMessage();
            showSectionControlView(scanner);
        }
        System.out.println();
        if (userInput.equals("1")) {
            showSectionAddView(scanner);
            System.out.println();
            MainView.showSelectManager(scanner);
        }
        if (userInput.equals("2")) {
            showSectionDeleteView(scanner);
            System.out.println();
            MainView.showSelectManager(scanner);
        }
        if (userInput.equals("B")) {
            System.out.println();
            MainView.showSelectManager(scanner);
        }
    }


    private static void showSectionAddView(Scanner scanner) {
        System.out.println(lineNameMessage);
        String lineName = scanner.next();
        if (!ErrorValidator.checkSameLineName(lineName)) {
            System.out.println(ErrorMessage.error + ErrorMessage.lineNotFound);
            showSectionControlView(scanner);
        }
        System.out.println();
        System.out.println(stationNameMessage);
        String stationName = scanner.next();
        if (!ErrorValidator.checkSameStationName(stationName)) {
            System.out.println(ErrorMessage.error + ErrorMessage.stationNotFound);
            showSectionControlView(scanner);
        }
        System.out.println();
        System.out.println(positionMessage);
        int position = scanner.nextInt();
        if (!ErrorValidator.checkPositionInLine(position, lineName)) {
            System.out.println(ErrorMessage.error + ErrorMessage.wrongPosition);
            showSectionControlView(scanner);
        }
        SectionController.addSection(lineName, stationName, position);
        System.out.println();
        System.out.println(MainView.information + sectionAddSuccessMessage);
        MainView.showSelectManager(scanner);
    }


    private static void showSectionDeleteView(Scanner scanner) {
        System.out.println(sectionDeleteLineMessage);
        String deleteLineName = scanner.next();
        if (!ErrorValidator.checkSameLineName(deleteLineName)) {
            System.out.println(ErrorMessage.error + ErrorMessage.lineNotFound);
            showSectionControlView(scanner);
        }
        System.out.println();
        System.out.println(sectionDeleteStationMessage);
        String deleteStationName = scanner.next();
        if (!ErrorValidator.checkSameStationName(deleteStationName)) {
            System.out.println(ErrorMessage.error + ErrorMessage.stationNotFound);
            showSectionControlView(scanner);
        }
        System.out.println();
        SectionController.deleteSection(deleteLineName, deleteStationName, scanner);
        System.out.println();
        System.out.println(MainView.information + sectionDeleteSuccessMessage);
        MainView.showSelectManager(scanner);
    }
}
