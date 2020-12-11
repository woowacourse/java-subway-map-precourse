package subway.view.stationManage;

import subway.station.StationController;
import subway.view.OutputView;

import java.util.Scanner;

public class ShowStationView implements StationManageViewStrategy {
    private static final String VIEW_NAME = "역 조회";
    private static final String SHOW_MESSAGE = "역 목록";
    private final StationController stationController;

    public ShowStationView(StationController stationController) {
        this.stationController = stationController;
    }

    @Override
    public void show() {
        OutputView.selectView(SHOW_MESSAGE);
        stationController.findStations()
                .forEach(station -> OutputView.infoView(station.getName()));
    }

    @Override
    public String toString() {
        return VIEW_NAME;
    }
}
