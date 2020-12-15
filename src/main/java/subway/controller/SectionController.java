package subway.controller;

import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.views.ErrorMessage;
import subway.views.SectionControlView;

public class SectionController {

    public static void manageSection(Scanner scanner) {
        SectionControlView.showSectionControlView(scanner);
    }

    public static void addSection(String lineName, String stationName, int position) {
        Line line = LineRepository.searchLineByName(lineName);
        Station station = StationRepository.searchStationByName(stationName);
        station.changeStatus();
        line.addStationInLine(position, station);
    }

    public static void deleteSection(String deleteLineName, String deleteStationName,
        Scanner scanner) {
        Line line = LineRepository.searchLineByName(deleteLineName);
        Station station = StationRepository.searchStationByName(deleteStationName);
        int linesize = line.getSectionSize();
        if (linesize <= 2) {
            ErrorMessage.showSectionDeleteSizeError();
            SectionControlView.showSectionControlView(scanner);
        }
        line.deleteStationInLine(station);
    }
}
