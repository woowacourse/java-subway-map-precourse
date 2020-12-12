package subway.controller;

import subway.controller.exception.DuplicationException;
import subway.controller.exception.NameFormatException;
import subway.controller.exception.NotExistedElementException;
import subway.controller.exception.StationValidator;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationMenu {
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
            // 역 조회
        }
        MainMenu.print();
    }

    private static void registerNewStation() {
        try {
            String name = InputView.receiveStationName(STATION_REGISTER_MESSAGE);
            StationValidator.validateStation(name);
            StationRepository.addStation(new Station(name));
            OutputView.printStationRegisterSuccess();
        } catch (NameFormatException | DuplicationException e) {
            System.out.println(e.getMessage());
            goToStationMenu();
        }
    }
    
    private static void deleteStation() {
        try {
            String name = InputView.receiveStationName(STATION_DELETE_MESSAGE);
            StationValidator.validateNotExistedStation(name);
            OutputView.printStationDeleteSuccess();
        } catch (NotExistedElementException e) {
            System.out.println(e.getMessage());
            goToStationMenu();
        }
    }
}
