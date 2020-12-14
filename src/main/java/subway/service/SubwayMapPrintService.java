package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.outputview.MainOutputView;

import java.util.List;

public class SubwayMapPrintService {
    private MainOutputView mainOutputView;

    public SubwayMapPrintService(MainOutputView mainOutputView) {
        this.mainOutputView = mainOutputView;
    }

    public void printSubwayMap() {
        this.mainOutputView.printSubwayList();

        for (Line line : LineRepository.lines()) {
            String lineName = line.getName();
            List<String> stationsNames = line.getStationsNames();
            this.mainOutputView.printStationsInLine(lineName, stationsNames);
        }
    }
}
