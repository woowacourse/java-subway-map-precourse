package subway.controller;

import subway.controller.exception.DuplicationException;
import subway.controller.exception.IllegalElementException;
import subway.controller.exception.NameFormatException;
import subway.controller.exception.NotExistedElementException;
import subway.controller.validator.LineValidator;
import subway.controller.validator.StationValidator;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController extends SubController {
    private static final String LINE_MENU = "Line";
    private static final String LINE_REGISTER_MESSAGE = "\n## 등록할 노선 이름을 입력하세요.";
    private static final String LINE_DELETE_MESSAGE = "\n## 삭제할 노선 이름을 입력하세요.";
    private static final String UP_STATION_MESSAGE = "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String DOWN_STATION_MESSAGE = "\n## 등록할 노선의 하행 종점역 이름을 입력하세요.";

    @Override
    public void goToMenu() {
        OutputView.printLineMenu();
        selection = InputView.receiveMenu(LINE_MENU);
        goToRegisterMenuIfUserSelect();
        goToDeleteMenuIfUserSelect();
        goToInquireMenuIfUserSelect();
        OutputView.printLineBreak();
    }

    @Override
    protected void register() {
        try {
            String lineName = InputView.receiveName(LINE_REGISTER_MESSAGE);
            validateLine(lineName);
            addLineToRepository(lineName);
            OutputView.printLineRegisterSuccess();
        } catch (NameFormatException | DuplicationException | IllegalElementException e) {
            OutputView.printExceptionMessage(e.getMessage());
            goToMenu();
        }
    }

    private void validateLine(String lineName) {
        LineValidator.validateLineName(lineName);
        LineValidator.validateDuplication(lineName);
    }

    private void addLineToRepository(String lineName) {
        String upStation = receiveAndValidateUpStation();
        String downStation = receiveAndValidateDownStation();
        LineValidator.validateUpAndDownIsEqual(upStation, downStation);
        makeNewLine(lineName, upStation, downStation);
    }

    private String receiveAndValidateUpStation() {
        String upStation = InputView.receiveName(UP_STATION_MESSAGE);
        validateStation(upStation);
        return upStation;
    }

    private String receiveAndValidateDownStation() {
        String downStation = InputView.receiveName(DOWN_STATION_MESSAGE);
        validateStation(downStation);
        return downStation;
    }

    private void validateStation(String stationName) {
        StationValidator.validateStationName(stationName);
        StationValidator.validateNotExistedStation(stationName);
    }

    public void makeNewLine(String lineName, String upStation, String downStation) {
        Line line = new Line(lineName);
        line.addStation(upStation);
        line.addStation(downStation);
        LineRepository.addLine(line);
    }

    @Override
    protected void delete() {
        try {
            String lineName = InputView.receiveName(LINE_DELETE_MESSAGE);
            LineValidator.validateNotExistedLine(lineName);
            LineRepository.deleteLineByName(lineName);
            OutputView.printLineDeleteSuccess();
        } catch (NotExistedElementException e) {
            OutputView.printExceptionMessage(e.getMessage());
            goToMenu();
        }
    }

    @Override
    protected void inquire() {
        OutputView.printLineList(LineRepository.lines());
    }
}
