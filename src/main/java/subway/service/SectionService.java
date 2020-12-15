package subway.service;

import subway.domain.LineStationRepository;

import java.util.Scanner;

import static subway.domain.LineRepository.findLine;
import static subway.domain.MenuType.*;
import static subway.domain.StationRepository.findStation;
import static subway.view.OutputView.printAddSectionSuccessMessage;
import static subway.view.OutputView.printDeleteSectionSuccessMessage;

public class SectionService extends InputService {

    public boolean selectSectionManagementMenu(Scanner scanner, String menu, LineStationRepository lineStation) {
        if (SECTION_ADD.isKeyEquals(menu)) {
            return addSection(scanner, lineStation);
        }
        if (SECTION_DELETE.isKeyEquals(menu)) {
            return deleteSection(scanner, lineStation);
        }
        if (BACK.isKeyEquals(menu)) {
            return true;
        }
        return false;
    }

    private boolean addSection(Scanner scanner, LineStationRepository lineStation) {
        try {
            String lineName = inputLineNameToAddSection(scanner);
            String stationName = inputStationNameToAddSection(scanner);
            String position = inputPositionToAddSection(scanner);
            int pos = validatePositionIsOutOfRange(lineName, position, lineStation);
            lineStation.addStationInLine(findLine(lineName), findStation(stationName), pos);
            printAddSectionSuccessMessage();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private boolean deleteSection(Scanner scanner, LineStationRepository lineStation) {
        try {
            String lineName = inputLineNameToDeleteSection(scanner, lineStation);
            String stationName = inputStationNameToDeleteSection(scanner, lineName, lineStation);
            lineStation.deleteStationInLineByName(findLine(lineName), stationName);
            printDeleteSectionSuccessMessage();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}