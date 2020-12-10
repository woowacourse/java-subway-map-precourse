package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class LineManagement {
    private static final String REGISTER = "1";
    private static final String DELETE = "2";
    private static final String PRINT = "3";
    private static final String BACK = "B";

    private static String menu;

    public static void run() {
        do {
            OutputView.showLineManagementView();
            menu = InputView.getLineMenuSelection();
            runSelectedMenuFunction();
        } while(!menu.equals(BACK));
    }

    private static void runSelectedMenuFunction() {

    }

    private static void registerLine() {
        try {
            Line line = new Line(InputView.getLineNameToRegister());
            Station upLineEndStation = StationRepository.searchStationByName(InputView.getUplineStationName());
            Station downLineEndStation = StationRepository.searchStationByName(InputView.getDownlineStationName());
            line.addStation(upLineEndStation);
            line.addStation(downLineEndStation);
            LineRepository.addLine(line);
        } catch (Exception e) {
            OutputView.showErrorMessage(e);
        }
    }
}
