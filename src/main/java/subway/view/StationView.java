package subway.view;

import subway.domain.station.Station;
import subway.domain.station.Stations;
import subway.service.output.OutputService;

import java.util.List;

public class StationView extends Screen{

    private static final String PRINT_STATION = "역 목록";

    public StationView(OutputService outputService) {
        super(outputService);
    }

    public void printAllStations(Stations stations) {
        outputService.printSharp(PRINT_STATION);
        List<Station> stationList = stations.getStations();
        for (Station station : stationList) {
            outputService.printInfo(station.getName());
        }
    }
}
