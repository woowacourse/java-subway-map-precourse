package subway.userinterface.intervalmenu;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.service.IntervalService;
import subway.userinterface.Menu;
import subway.userinterface.OutputController;

import java.util.Scanner;

public class IntervalDeleteController implements Menu {

    private static final String INTERVAL_DELETED = "\n[INFO] 구간이 삭제되었습니다.";
    private static final String MENU_NAME = "2. 구간 삭제";
    private static final String MENU_KEY = "2";
    private static final IntervalService intervalService = new IntervalService();
    private static final IntervalDeleteLineInputController lineInput =
            new IntervalDeleteLineInputController();
    private static final IntervalDeleteStationInputController stationInput =
            new IntervalDeleteStationInputController();
    private static IntervalDeleteController intervalDeleteController;

    public static Menu getInstance() {
        if (intervalDeleteController == null) {
            intervalDeleteController = new IntervalDeleteController();
        }

        return intervalDeleteController;
    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    @Override
    public String getMenuKey() {
        return MENU_KEY;
    }

    @Override
    public void run(Scanner scanner) throws IllegalArgumentException {
        Line currLine = LineRepository.findLineByName(lineInput.getUserInput(scanner));
        Station deleteStation = currLine.findStationByName(stationInput.getUserInput(scanner));
        intervalService.deleteInterval(currLine, deleteStation);

        OutputController.printInfo(INTERVAL_DELETED);
    }
}
