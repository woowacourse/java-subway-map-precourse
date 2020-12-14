package subway.service;

import subway.domain.LineStationRepository;
import subway.domain.MenuType;

import java.util.Scanner;

import static subway.domain.LineRepository.findLine;
import static subway.domain.MenuType.*;
import static subway.domain.StationRepository.findStation;
import static subway.view.OutputView.printAddSectionSuccessMessage;
import static subway.view.OutputView.printDeleteSectionSuccessMessage;

public class SectionService extends InputService {

    public void selectSectionManagementMenu(Scanner scanner, String menu, LineStationRepository lineStation) {
        if (SECTION_ADD.isKeyEquals(menu)) {
            addSection(scanner, lineStation);
        }
        if (SECTION_DELETE.isKeyEquals(menu)) {
            deleteSection(scanner, lineStation);
        }
    }

    private void addSection(Scanner scanner, LineStationRepository lineStation) {
        String lineName = inputLineNameToAddSection(scanner);
        String stationName = inputStationNameToAddSection(scanner);
        String position = inputPositionToAddSection(scanner);
        int pos = validatePositionIsOutOfRange(lineName, position, lineStation);
        lineStation.addStationInLine(findLine(lineName), findStation(stationName), pos);
        printAddSectionSuccessMessage();
    }

    private void deleteSection(Scanner scanner, LineStationRepository lineStation) {
        String lineName = inputLineNameToDeleteSection(scanner, lineStation);
        String stationName = inputStationNameToDeleteSection(scanner);
        lineStation.deleteStationInLineByName(findLine(lineName), stationName);
        printDeleteSectionSuccessMessage();
    }
}