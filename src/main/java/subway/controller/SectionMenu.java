package subway.controller;

import subway.controller.exception.SectionValidator;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionMenu {
    private static final String LINE_INPUT_MESSAGE = "\n## 노선을 입력하세요.";
    private static final String STATION_INPUT_MESSAGE = "\n## 역이름을 입력하세요.";
    private static final String ORDER_INPUT_MESSAGE = "\n## 순서를 입력하세요.";

    public static void goToSectionMenu() {
        OutputView.printSectionMenu();
        String selection = InputView.receiveMenu("Section");
        if (selection.equals("1")) {
            registerNewSection();
        }
        if (selection.equals("2")) {
            // 구간 삭제
        }
    }

    private static void registerNewSection() {
        try {
            String lineName = receiveLineNameAndValidate();
            String stationName = receiveStationNameAndValidate(lineName);
            String order = receiveOrderAndValidate(lineName);
            LineRepository.addSectionToLine(lineName, stationName, order);
            OutputView.printSectionRegisterSuccess();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            goToSectionMenu();
        }
    }

    private static String receiveLineNameAndValidate() {
        String lineName = InputView.receiveName(LINE_INPUT_MESSAGE);
        SectionValidator.validateLineCanAddSection(lineName);
        return lineName;
    }

    private static String receiveStationNameAndValidate(String lineName) {
        String stationName = InputView.receiveName(STATION_INPUT_MESSAGE);
        SectionValidator.validateStationCanMakeSection(lineName, stationName);
        return stationName;
    }

    private static String receiveOrderAndValidate(String lineName) {
        String order = InputView.receiveName(ORDER_INPUT_MESSAGE);
        SectionValidator.validateOrder(lineName, order);
        return order;
    }
}
