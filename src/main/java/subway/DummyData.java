package subway;

import subway.line.LineController;
import subway.line.LineRepositoryJava;
import subway.line.LineRequestDTO;
import subway.station.StationController;
import subway.station.StationRepositoryJava;

import java.util.*;

public class DummyData {
    private static final StationController STATION_CONTROLLER =
            StationController.get(StationRepositoryJava.get());
    private static final LineController LINE_CONTROLLER =
            LineController.get(LineRepositoryJava.get(), StationRepositoryJava.get());
    private static final int MIN_STATION_SIZE = 2;

    public static void insert() {
        createStation();
        createLine();
    }

    private static void createStation() {
        Set<String> stations = DummyDataList.getStationNames();
        stations.forEach(STATION_CONTROLLER::createStation);
    }

    private static void createLine() {
        Map<String, List<String>> lineGroup = DummyDataList.getLineGroup();
        lineGroup.forEach((lineName, stationNames) -> {
            LINE_CONTROLLER.createLine(createLineRequest(lineName, stationNames));
            insertStation(lineName, stationNames);
        });
    }

    private static LineRequestDTO createLineRequest(String lineName, List<String> stationNames) {
        return new LineRequestDTO(lineName, stationNames.get(0), stationNames.get(1));
    }

    private static void insertStation(String lineName, List<String> stationNames) {
        for (int index = MIN_STATION_SIZE; index < stationNames.size(); index++) {
            LINE_CONTROLLER.addStationOnLine(stationNames.get(index), lineName, index+1);
        }
    }

}
