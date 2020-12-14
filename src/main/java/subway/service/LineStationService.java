package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.LineStationRepository;
import subway.domain.MenuType;

import java.util.Scanner;

import static subway.domain.LineRepository.*;
import static subway.domain.MenuType.*;
import static subway.domain.StationRepository.findStation;
import static subway.view.OutputView.printAddLineStationSuccessMessage;
import static subway.view.OutputView.printDeleteLineStationSuccessMessage;

public class LineStationService extends InputService {

    public void selectLineStationManagementMenu(Scanner scanner, String menu, LineStationRepository lineStation) {
        if (LINE_STATION_ADD.isKeyEquals(menu)) {
            addLineStation(scanner, lineStation);
        }
        if (LINE_STATION_DELETE.isKeyEquals(menu)) {
            deleteLineStation(scanner, lineStation);
        }
        if (LINE_STATION_SEARCH.isKeyEquals(menu)) {
            printLines();
        }
    }

    private void addLineStation(Scanner scanner, LineStationRepository lineStation) {
        String lineName = inputAddLineName(scanner);
        String startStationName = inputAddStartStationName(scanner);
        String endStationName = inputAddEndStationName(scanner);
        Line line = new Line(lineName);
        addLine(line);
        lineStation.addLineStation(line, findStation(startStationName));
        lineStation.addLineStation(line, findStation(endStationName));
        printAddLineStationSuccessMessage();
    }

    private void deleteLineStation(Scanner scanner, LineStationRepository lineStation) {
        String lineName = inputDeleteLineName(scanner);
        lineStation.deleteLineStation(findLine(lineName));
        deleteLineByName(lineName);
        printDeleteLineStationSuccessMessage();
    }

    private void printLines() {
        LineRepository.printLines();
    }
}