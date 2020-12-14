package subway.userinterface.intervalmenu;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.service.IntervalService;
import subway.userinterface.Menu;
import subway.userinterface.OutputController;

import java.util.Scanner;

public class IntervalRegisterController implements Menu {

    private static final String INTERVAL_REGISTERED = "\n[INFO] 구간이 등록되었습니다.";
    private static final String MENU_NAME = "1. 구간 등록";
    private static final String MENU_KEY = "1";
    private static final IntervalService intervalService = new IntervalService();
    private static final IntervalRegisterLineInputController lineInput =
            new IntervalRegisterLineInputController();
    private static final IntervalRegisterStationInputController stationInput =
            new IntervalRegisterStationInputController();
    private static final IntervalRegisterPosInputController positionInput =
            new IntervalRegisterPosInputController();
    private static IntervalRegisterController intervalRegisterController;

    private static Line currentLine;

    public static Menu getInstance() {
        if (intervalRegisterController == null) {
            intervalRegisterController = new IntervalRegisterController();
        }

        return intervalRegisterController;
    }

    public static Line getCurrentLine() {
        return currentLine;
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
    public void run(Scanner scanner) {
        currentLine = LineRepository.findLineByName(lineInput.getUserInput(scanner));
        Station addStation =
                StationRepository.findStationByName(stationInput.getUserInput(scanner));
        int addPosition = Integer.parseInt(positionInput.getUserInput(scanner));
        intervalService.registerInterval(currentLine, addStation, addPosition);

        OutputController.printInfo(INTERVAL_REGISTERED);
    }
}

