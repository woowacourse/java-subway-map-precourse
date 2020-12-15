package subway.controller;

import subway.controller.initialization.InitialLine;
import subway.controller.initialization.InitialSection;
import subway.controller.initialization.InitialStation;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;

import java.util.Arrays;
import java.util.List;

public class SubwayController {
    public static void initStation() {
        Arrays.stream(InitialStation.values())
                .forEach(station -> StationService.addStation(station.getName()));
    }

    public static void initLine() {
        Arrays.stream(InitialLine.values())
                .forEach(line -> LineService.addLine(line.getName()));
        Arrays.stream(InitialLine.values())
                .forEach(line -> SectionService.createSection(line.getName()));
    }

    public static void initSection() {
        Arrays.stream(InitialSection.values())
                .forEach(initialSection -> initSection(initialSection));
    }

    public static void initSection(InitialSection initialSection) {
        String lineName = initialSection.getLineName();
        List<String> stationNames = initialSection.getStationNames();
        stationNames.stream()
                .forEach(stationName -> SectionService.addSection(lineName, stationName));
    }

    public static void run() {
        initStation();
        initLine();
        initSection();
        MainController.run();
    }
}
