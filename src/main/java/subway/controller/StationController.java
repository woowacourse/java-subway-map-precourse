package subway.controller;

import java.util.List;

import subway.controller.exception.DuplicationException;
import subway.controller.exception.IllegalElementException;
import subway.controller.exception.NameFormatException;
import subway.controller.exception.NotExistedElementException;
import subway.controller.validator.StationValidator;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {
    private static final String STATION_REGISTER_MESSAGE = "\n## 등록할 역 이름을 입력하세요.";
    private static final String STATION_DELETE_MESSAGE = "\n## 삭제할 역 이름을 입력하세요.";
    
    public static void goToStationMenu() {
        OutputView.printStationMenu();
        String selection = InputView.receiveMenu("Station");
        if (selection.equals("1")) {
            registerNewStation();
        }
        if (selection.equals("2")) {
            deleteStation();
        }
        if (selection.equals("3")) {
            inquireStationList();
        }
    }

    private static void registerNewStation() {
        try {
            String stationName = InputView.receiveName(STATION_REGISTER_MESSAGE);
            StationValidator.validateStationName(stationName);
            StationValidator.validateDuplication(stationName);
            StationRepository.addStation(new Station(stationName));
            OutputView.printStationRegisterSuccess();
        } catch (NameFormatException | DuplicationException e) {
            System.out.println(e.getMessage());
            goToStationMenu();
        }
    }
    
    private static void deleteStation() {
        try {
            String name = InputView.receiveName(STATION_DELETE_MESSAGE);
            StationValidator.validateDeleteStation(name);
            StationRepository.deleteStation(name);
            OutputView.printStationDeleteSuccess();
        } catch (NotExistedElementException | IllegalElementException e) {
            System.out.println(e.getMessage());
            goToStationMenu();
        }
    }
    
    private static void inquireStationList() {
        List<Station> stations = StationRepository.stations();
        OutputView.printStationList(stations);
    }
}
