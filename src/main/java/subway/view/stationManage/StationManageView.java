package subway.view.stationManage;

import subway.station.StationController;
import subway.station.StationRepository;
import subway.station.StationRepositoryJava;
import subway.view.OutputView;
import subway.view.ViewStrategy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StationManageView implements ViewStrategy {
    private static final String VIEW_NAME = "역 관리";
    private static final String STATION_MANAGE_MESSAGE = "역 관리 화면";
    private static final Map<String, StationManageViewStrategy> STATION_MANAGE_VIEW = new LinkedHashMap<>();
    private final Scanner scanner;
    private StationManageViewStrategy stationManageViewStrategy;

    public StationManageView(Scanner scanner) {
        this.scanner = scanner;
        StationController stationController = StationController.get(StationRepositoryJava.get());
        STATION_MANAGE_VIEW.put("1", new CreateStationView(stationController, scanner));
        STATION_MANAGE_VIEW.put("B", new BackView());
    }

    @Override
    public void show() {
        manageStation();
        OutputView.enter();
        stationFunction();
        OutputView.enter();
    }

    private void manageStation() {
        OutputView.selectStrategy(STATION_MANAGE_VIEW, STATION_MANAGE_MESSAGE);
        String stationManageKey = scanner.nextLine();
        stationManageViewStrategy = STATION_MANAGE_VIEW.get(stationManageKey);
        if (stationManageViewStrategy == null) {
            OutputView.notExist();
            manageStation();
        }

    }

    private void stationFunction() {
        stationManageViewStrategy.show();
    }

    @Override
    public String toString() {
        return VIEW_NAME;
    }
}
