package subway.controller;

import subway.controller.exception.IllegalElementException;
import subway.controller.exception.NotExistedElementException;
import subway.controller.validator.LineValidator;
import subway.controller.validator.SectionValidator;
import subway.controller.validator.StationValidator;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController {
    private static final String LINE_INPUT_MESSAGE = "\n## 노선을 입력하세요.";
    private static final String STATION_INPUT_MESSAGE = "\n## 역이름을 입력하세요.";
    private static final String ORDER_INPUT_MESSAGE = "\n## 순서를 입력하세요.";
    private static final String LINE_DELETE_MESSAGE = "\n## 삭제할 구간의 노선을 입력하세요.";
    private static final String STATION_DELETE_MESSAGE = "\n## 삭제할 구간의 역을 입력하세요.";

    public static void goToSectionMenu() {
        OutputView.printSectionMenu();
        String selection = InputView.receiveMenu("Section");
        if (selection.equals("1")) {
            registerNewSection();
        }
        if (selection.equals("2")) {
            deleteSection();
        }
    }

    private static void registerNewSection() {
        try {
            String lineName = receiveLineNameAndValidate();
            String stationName = receiveStationNameAndValidate();
            SectionValidator.validateSectionDuplication(lineName, stationName);
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
        LineValidator.validateLineName(lineName);
        LineValidator.validateNotExistedLine(lineName);
        return lineName;
    }

    private static String receiveStationNameAndValidate() {
        String stationName = InputView.receiveName(STATION_INPUT_MESSAGE);
        StationValidator.validateStationName(stationName);
        StationValidator.validateNotExistedStation(stationName);
        return stationName;
    }

    private static String receiveOrderAndValidate(String lineName) {
        String order = InputView.receiveName(ORDER_INPUT_MESSAGE);
        SectionValidator.validateOrder(lineName, order);
        return order;
    }

    private static void deleteSection() {
        try {
            String lineName = InputView.receiveName(LINE_DELETE_MESSAGE);
            LineValidator.validateNotExistedLine(lineName);
            SectionValidator.validateLineSizeIsSufficient(lineName);
            String stationName = InputView.receiveName(STATION_DELETE_MESSAGE);
            SectionValidator.validateStationIsExistedInTheLine(lineName, stationName);
            LineRepository.deleteSectionFromLine(lineName, stationName);
            OutputView.printSectionDeleteSuccess();
        } catch (NotExistedElementException | IllegalElementException e) {
            System.out.println(e.getMessage());
            goToSectionMenu();
        }
    }
}
