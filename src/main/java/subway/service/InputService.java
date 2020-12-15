package subway.service;

import subway.domain.LineStationRepository;
import subway.domain.MenuType;
import subway.utils.InputValidation;

import java.util.Scanner;

import static subway.utils.ParseUtils.parseStringToTrimString;
import static subway.view.InputView.*;

public class InputService extends InputValidation {

    public String inputSelectMenu(Scanner scanner, MenuType menuType) {
        inputSelectMenuRequestMessage();
        String menu = parseStringToTrimString(scanner.nextLine());
        validateMenuRange(menuType.getKeys(), menu);
        return menu;
    }

    public String inputAddStationName(Scanner scanner) {
        inputAddStationNameRequestMessage();
        String stationName = parseStringToTrimString(scanner.nextLine());
        validateNameLengthIsMoreThan2(stationName);
        validateStationNameIsDuplicate(stationName);
        return stationName;
    }

    public String inputDeleteStationName(Scanner scanner, LineStationRepository lineStation) {
        inputDeleteStationNameRequestMessage();
        String stationName = parseStringToTrimString(scanner.nextLine());
        validateStationNameIsContains(stationName);
        validateStationIsContainsLineStation(stationName, lineStation);
        return stationName;
    }

    public String inputAddLineName(Scanner scanner) {
        inputAddLineNameRequestMessage();
        String lineName = parseStringToTrimString(scanner.nextLine());
        validateNameLengthIsMoreThan2(lineName);
        validateLineNameIsDuplicate(lineName);
        return lineName;
    }

    public String inputDeleteLineName(Scanner scanner) {
        inputDeleteLineNameRequestMessage();
        String lineName = parseStringToTrimString(scanner.nextLine());
        validateLineNameIsContains(lineName);
        return lineName;
    }

    public String inputAddStartStationName(Scanner scanner) {
        inputAddStartStationNameRequestMessage();
        String stationName = parseStringToTrimString(scanner.nextLine());
        validateStationNameIsContains(stationName);
        return stationName;
    }

    public String inputAddEndStationName(Scanner scanner) {
        inputAddEndStationNameRequestMessage();
        String stationName = parseStringToTrimString(scanner.nextLine());
        validateStationNameIsContains(stationName);
        return stationName;
    }

    public String inputLineNameToAddSection(Scanner scanner) {
        inputLineNameToAddSectionRequestMessage();
        String lineName = parseStringToTrimString(scanner.nextLine());
        validateLineNameIsContains(lineName);
        return lineName;
    }

    public String inputStationNameToAddSection(Scanner scanner) {
        inputStationNameToAddSectionRequestMessage();
        String stationName = parseStringToTrimString(scanner.nextLine());
        validateStationNameIsContains(stationName);
        return stationName;
    }

    public String inputPositionToAddSection(Scanner scanner) {
        inputPositionToAddSectionRequestMessage();
        String position = parseStringToTrimString(scanner.nextLine());
        validatePositionIsDigit(position);
        return position;
    }

    public String inputLineNameToDeleteSection(Scanner scanner, LineStationRepository lineStation) {
        inputLineNameToDeleteSectionRequestMessage();
        String lineName = parseStringToTrimString(scanner.nextLine());
        validateLineNameIsContains(lineName);
        validateStationSizeOfLineIsMoreThan2(lineName, lineStation);
        return lineName;
    }

    public String inputStationNameToDeleteSection(Scanner scanner, String lineName, LineStationRepository lineStation) {
        inputStationNameToDeleteSectionRequestMessage();
        String stationName = parseStringToTrimString(scanner.nextLine());
        validateStationNameIsContains(stationName);
        validateStationIsContainsInLineStation(lineName, stationName, lineStation);
        return stationName;
    }
}