package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.LineStationRepository;

import java.util.Scanner;

import static subway.domain.LineRepository.*;
import static subway.domain.MenuType.*;
import static subway.domain.StationRepository.findStation;
import static subway.view.OutputView.printAddLineStationSuccessMessage;
import static subway.view.OutputView.printDeleteLineStationSuccessMessage;

public class LineStationService extends InputService {

    public boolean selectLineStationManagementMenu(Scanner scanner, String menu, LineStationRepository lineStation) {
        if (LINE_STATION_ADD.isKeyEquals(menu)) {
            return addLineStation(scanner, lineStation);
        }
        if (LINE_STATION_DELETE.isKeyEquals(menu)) {
            return deleteLineStation(scanner, lineStation);
        }
        if (LINE_STATION_SEARCH.isKeyEquals(menu)) {
            return printLines();
        }
        if (BACK.isKeyEquals(menu)) {
            return true;
        }
        return false;
    }

    private boolean addLineStation(Scanner scanner, LineStationRepository lineStation) {
        try {
            String lineName = inputAddLineName(scanner);
            String startStationName = inputAddStartStationName(scanner);
            String endStationName = inputAddEndStationName(scanner);
            Line line = new Line(lineName);
            addLine(line);
            lineStation.addLineStation(line, findStation(startStationName));
            lineStation.addLineStation(line, findStation(endStationName));
            printAddLineStationSuccessMessage();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private boolean deleteLineStation(Scanner scanner, LineStationRepository lineStation) {
        try {
            String lineName = inputDeleteLineName(scanner);
            lineStation.deleteLineStation(findLine(lineName));
            deleteLineByName(lineName);
            printDeleteLineStationSuccessMessage();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private boolean printLines() {
        LineRepository.printLines();
        return true;
    }
}