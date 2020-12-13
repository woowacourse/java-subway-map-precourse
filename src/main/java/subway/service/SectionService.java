package subway.service;

import subway.domain.LineRepository;
import subway.domain.LineStationRepository;
import subway.domain.MenuType;
import subway.domain.StationRepository;

import java.util.Scanner;

import static subway.view.OutputView.printAddSectionSuccessMessage;
import static subway.view.OutputView.printDeleteSectionSuccessMessage;

public class SectionService extends InputService {

    public void selectSectionManagementMenu(Scanner scanner, String menu, LineStationRepository lineStation) {
        if (menu.equals(MenuType.SECTION_ADD.getKey())) {
            addSection(scanner, lineStation);
        }
        if (menu.equals(MenuType.SECTION_DELETE.getKey())) {
            deleteSection(scanner, lineStation);
        }
    }

    private void addSection(Scanner scanner, LineStationRepository lineStation) {
        String lineName = inputLineNameToAddSection(scanner);
        String stationName = inputStationNameToAddSection(scanner);
        String position = inputPositionToAddSection(scanner);
        int pos = validatePositionIsOver(lineName, position, lineStation);
        lineStation.addStationInLine(LineRepository.findLine(lineName).get(),
                StationRepository.findStation(stationName).get(), pos);
        printAddSectionSuccessMessage();
    }

    private void deleteSection(Scanner scanner, LineStationRepository lineStation) {
        String lineName = inputLineNameToDeleteSection(scanner, lineStation);
        String stationName = inputStationNameToDeleteSection(scanner);
        lineStation.deleteStationInLineByName(LineRepository.findLine(lineName).get(), stationName);
        printDeleteSectionSuccessMessage();
    }
}