package subway.controller;

import subway.controller.exception.DuplicationException;
import subway.controller.exception.IllegalElementException;
import subway.controller.exception.NameFormatException;
import subway.controller.exception.NotExistedElementException;
import subway.controller.validator.StationValidator;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController extends SubController {
    private static final String STATION_REGISTER_MESSAGE = "\n## 등록할 역 이름을 입력하세요.";
    private static final String STATION_DELETE_MESSAGE = "\n## 삭제할 역 이름을 입력하세요.";

    @Override
    public void goToMenu() {
        OutputView.printStationMenu();
        this.selection = InputView.receiveMenu("Station");
        goToRegisterMenuIfUserSelect();
        goToDeleteMenuIfUserSelect();
        goToInquireMenuIfUserSelect();
        OutputView.printLineBreak();
    }

    @Override
    protected void register() {
        try {
            String stationName = InputView.receiveName(STATION_REGISTER_MESSAGE);
            validateStationWhenRegister(stationName);
            StationRepository.addStation(new Station(stationName));
            OutputView.printStationRegisterSuccess();
        } catch (NameFormatException | DuplicationException e) {
            System.out.println(e.getMessage());
            goToMenu();
        }
    }

    private void validateStationWhenRegister(String stationName) {
        StationValidator.validateStationName(stationName);
        StationValidator.validateDuplication(stationName);
    }

    @Override
    protected void delete() {
        try {
            String stationName = InputView.receiveName(STATION_DELETE_MESSAGE);
            StationValidator.validateDeleteStation(stationName);
            StationRepository.deleteStation(stationName);
            OutputView.printStationDeleteSuccess();
        } catch (NotExistedElementException | IllegalElementException e) {
            System.out.println(e.getMessage());
            goToMenu();
        }
    }

    @Override
    protected void inquire() {
        OutputView.printStationList(StationRepository.stations());
    }
}
