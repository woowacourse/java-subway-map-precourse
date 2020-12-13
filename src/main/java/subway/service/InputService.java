package subway.service;

import subway.domain.LineStationRepository;
import subway.utils.InputValidation;

import java.util.List;
import java.util.Scanner;

import static subway.view.InputView.*;

public class InputService extends InputValidation {

    public String inputSelectMenu(Scanner scanner, List<String> menuRange) {
        inputSelectMenuRequestMessage();
        String menu = scanner.nextLine();
        validateMenuRange(menuRange, menu);
        return menu;
    }

    public String inputAddStationName(Scanner scanner) {
        inputAddStationNameRequestMessage();
        String stationName = scanner.nextLine();
        validateNameLengthIsMoreThan2(stationName);
        validateStationNameIsDuplicate(stationName);
        return stationName;
    }

    public String inputDeleteStationName(Scanner scanner, LineStationRepository lineStation) {
        inputDeleteStationNameRequestMessage();
        String stationName = scanner.nextLine();
        validateStationNameIsContains(stationName);
        validateStationIsContainsLineStation(stationName, lineStation);
        return stationName;
    }

    public String inputAddLineName(Scanner scanner) {
        inputAddLineNameRequestMessage();
        String lineName = scanner.nextLine();
        validateNameLengthIsMoreThan2(lineName);
        validateLineNameIsDuplicate(lineName);
        return lineName;
    }

    public String inputDeleteLineName(Scanner scanner) {
        inputDeleteLineNameRequestMessage();
        String lineName = scanner.nextLine();
        validateLineNameIsContains(lineName);
        return lineName;
    }

    public String inputAddStartStationName(Scanner scanner) {
        inputAddStartStationNameRequestMessage();
        String stationName = scanner.nextLine();
        validateStationNameIsContains(stationName);
        return stationName;
    }

    public String inputAddEndStationName(Scanner scanner) {
        inputAddEndStationNameRequestMessage();
        String stationName = scanner.nextLine();
        validateStationNameIsContains(stationName);
        return stationName;
    }

    public String inputLineNameToAddSection(Scanner scanner) {
        inputLineNameToAddSectionRequestMessage();
        String lineName = scanner.nextLine();
        validateLineNameIsContains(lineName);
        return lineName;
    }

    public String inputStationNameToAddSection(Scanner scanner) {
        inputStationNameToAddSectionRequestMessage();
        String stationName = scanner.nextLine();
        validateStationNameIsContains(stationName);
        return stationName;
    }

    public String inputPositionToAddSection(Scanner scanner) {
        inputPositionToAddSectionRequestMessage();
        String position = scanner.nextLine();
        validatePositionIsDigit(position);
        return position;
    }

    public String inputLineNameToDeleteSection(Scanner scanner, LineStationRepository lineStation) {
        inputLineNameToDeleteSectionRequestMessage();
        String lineName = scanner.nextLine();
        validateLineNameIsContains(lineName);
        validateStationSizeOfLineIsMoreThan2(lineName, lineStation);
        return lineName;
    }

    public String inputStationNameToDeleteSection(Scanner scanner) {
        inputStationNameToDeleteSectionRequestMessage();
        String stationName = scanner.nextLine();
        validateStationNameIsContains(stationName);
        return stationName;
    }
}