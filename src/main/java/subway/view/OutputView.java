package subway.view;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import static subway.constant.Constant.DIVIDER;
import static subway.constant.Information.*;

public class OutputView {

    public void printErrorMessage(String message) {
        print(message);
    }

    public void printInformation(String information) {
        printEmptyLine();
        print(information);
    }

    private void print(String message) {
        System.out.println(message);
    }

    public void printStationList() {
        print(SHOW_STATION_INFO);
        for (Station station : StationRepository.stations())
            print(INFO_HEADER + station.getName());
    }

    private void printEmptyLine() {
        print("");
    }

    public void printLineList() {
        print(SHOW_LINE_INFO);
        for (Line line : LineRepository.lines())
            print(INFO_HEADER + line.getName());
    }


    public void printMap() {
        print(PRINT_INFO);
        for (Line line : LineRepository.lines()) {
            printLineAndItsStations(line);
            printEmptyLine();
        }
    }

    private void printLineAndItsStations(Line line) {
        print(INFO_HEADER + line.getName());
        print(INFO_HEADER + DIVIDER);
        for (Station station : line.getStations())
            print(INFO_HEADER + station.getName());
    }
}
