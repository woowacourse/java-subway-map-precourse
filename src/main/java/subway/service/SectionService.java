package subway.service;

import subway.domain.LineRepository;
import subway.domain.LineStationRepository;
import subway.domain.MenuType;
import subway.domain.StationRepository;
import subway.utils.InputValidation;

import java.util.Scanner;

import static subway.view.InputView.*;
import static subway.view.OutputView.printAddSectionSuccessMessage;
import static subway.view.OutputView.printDeleteSectionSuccessMessage;

public class SectionService extends InputValidation {

    public void selectSectionManagementMenu(Scanner scanner, String menu, LineStationRepository lineStation) {
        if (menu.equals(MenuType.SECTION_ADD.getKey())) {
            addSection(scanner, lineStation);
        }
        if (menu.equals(MenuType.SECTION_DELETE.getKey())) {
            deleteSection(scanner, lineStation);
        }
    }

    private void addSection(Scanner scanner, LineStationRepository lineStation) {
        inputLineNameToAddSectionRequestMessage();
        String lineName = scanner.nextLine();
        inputStationNameToAddSectionRequestMessage();
        String stationName = scanner.nextLine();
        inputPositionToAddSectionRequestMessage();
        String position = scanner.nextLine();
        validateLineNameIsContains(lineName);
        validateStationNameIsContains(stationName);
        validatePositionIsDigit(position);
        int pos = validatePositionIsOver(lineName, position, lineStation);
        lineStation.addStationInLine(LineRepository.findLine(lineName).get(),
                StationRepository.findStation(stationName).get(), pos);
        printAddSectionSuccessMessage();
    }

    private void deleteSection(Scanner scanner, LineStationRepository lineStation) {
        inputLineNameToDeleteSectionRequestMessage();
        String lineName = scanner.nextLine();
        inputStationNameToDeleteSectionRequestMessage();
        String stationName = scanner.nextLine();
        validateLineNameIsContains(lineName);
        validateStationSizeOfLineIsMoreThan2(lineName, lineStation);
        validateStationNameIsContains(stationName);
        lineStation.deleteStationInLineByName(LineRepository.findLine(lineName).get(), stationName);
        printDeleteSectionSuccessMessage();
    }
}