package subway.controller;

import subway.controller.exception.IllegalElementException;
import subway.controller.exception.NameFormatException;
import subway.controller.exception.NotExistedElementException;
import subway.controller.validator.LineValidator;
import subway.controller.validator.SectionValidator;
import subway.controller.validator.StationValidator;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController extends SubController {
    private static final String SECTION_MENU = "Section";
    private static final String LINE_INPUT_MESSAGE = "\n## 노선을 입력하세요.";
    private static final String STATION_INPUT_MESSAGE = "\n## 역이름을 입력하세요.";
    private static final String ORDER_INPUT_MESSAGE = "\n## 순서를 입력하세요.";
    private static final String LINE_DELETE_MESSAGE = "\n## 삭제할 구간의 노선을 입력하세요.";
    private static final String STATION_DELETE_MESSAGE = "\n## 삭제할 구간의 역을 입력하세요.";

    @Override
    public void goToMenu() {
        OutputView.printSectionMenu();
        String selection = InputView.receiveMenu(SECTION_MENU);
        goToRegisterMenuIfUserSelect(selection);
        goToDeleteMenuIfUserSelect(selection);
    }

    @Override
    protected void register() {
        try {
            String lineName = receiveAndValidateLineNameWhenRegister();
            String stationName = receiveAndValidateStationNameWhenRegister();
            SectionValidator.validateSectionDuplication(lineName, stationName);
            String order = receiveAndValidateOrder(lineName);
            LineRepository.addSectionToLine(lineName, stationName, order);
            OutputView.printSectionRegisterSuccess();
        } catch (NameFormatException | NotExistedElementException | IllegalElementException e) {
            OutputView.printExceptionMessage(e.getMessage());
            goToMenu();
        }
    }

    private String receiveAndValidateLineNameWhenRegister() {
        String lineName = InputView.receiveName(LINE_INPUT_MESSAGE);
        validateLineWhenRegister(lineName);
        return lineName;
    }

    private void validateLineWhenRegister(String lineName) {
        LineValidator.validateLineName(lineName);
        LineValidator.validateNotExistedLine(lineName);
    }

    private String receiveAndValidateStationNameWhenRegister() {
        String stationName = InputView.receiveName(STATION_INPUT_MESSAGE);
        validateStationWhenRegister(stationName);
        return stationName;
    }

    private void validateStationWhenRegister(String stationName) {
        StationValidator.validateStationName(stationName);
        StationValidator.validateNotExistedStation(stationName);
    }

    private String receiveAndValidateOrder(String lineName) {
        String order = InputView.receiveName(ORDER_INPUT_MESSAGE);
        validateOrder(lineName, order);
        return order;
    }

    private void validateOrder(String lineName, String order) {
        SectionValidator.validateOrder(lineName, order);
    }

    @Override
    protected void delete() {
        try {
            String lineName = receiveAndValidateLineNameWhenDelete();
            String stationName = receiveStationNameWhenDelete();
            validateAndDeleteSection(lineName, stationName);
            OutputView.printSectionDeleteSuccess();
        } catch (NotExistedElementException | IllegalElementException e) {
            OutputView.printExceptionMessage(e.getMessage());
            goToMenu();
        }
    }

    private String receiveAndValidateLineNameWhenDelete() {
        String lineName = InputView.receiveName(LINE_DELETE_MESSAGE);
        validateLineWhenDelete(lineName);
        return lineName;
    }

    private void validateLineWhenDelete(String lineName) {
        LineValidator.validateNotExistedLine(lineName);
        SectionValidator.validateLineSizeIsSufficient(lineName);
    }

    private String receiveStationNameWhenDelete() {
        return InputView.receiveName(STATION_DELETE_MESSAGE);
    }

    private void validateAndDeleteSection(String lineName, String stationName) {
        validateSectionWhenDelete(lineName, stationName);
        deleteSection(lineName, stationName);
    }

    private void validateSectionWhenDelete(String lineName, String stationName) {
        SectionValidator.validateStationIsExistedInTheLine(lineName, stationName);
    }

    private void deleteSection(String lineName, String stationName) {
        LineRepository.deleteSectionFromLine(lineName, stationName);
    }
}
