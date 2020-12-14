package subway.service;

import subway.domain.LineStationRepository;
import subway.domain.MenuType;
import subway.utils.InputValidation;

import java.util.List;
import java.util.Scanner;

import static subway.utils.ParseUtils.parseStringToTrimString;
import static subway.view.InputView.*;

public class InputService extends InputValidation {

    public String inputSelectMenu(Scanner scanner, MenuType menuType) {
        inputSelectMenuRequestMessage();
        String menu = scanner.nextLine();
        validateMenuRange(menuType.getKeys(), menu);
        return parseStringToTrimString(menu);
    }

    public String inputAddStationName(Scanner scanner) {
        inputAddStationNameRequestMessage();
        String stationName = scanner.nextLine();
        validateNameLengthIsMoreThan2(stationName);
        validateStationNameIsDuplicate(stationName);
        return parseStringToTrimString(stationName);
    }

    public String inputDeleteStationName(Scanner scanner, LineStationRepository lineStation) {
        inputDeleteStationNameRequestMessage();
        String stationName = scanner.nextLine();
        validateStationNameIsContains(stationName);
        validateStationIsContainsLineStation(stationName, lineStation);
        return parseStringToTrimString(stationName);
    }

    public String inputAddLineName(Scanner scanner) {
        inputAddLineNameRequestMessage();
        String lineName = scanner.nextLine();
        validateNameLengthIsMoreThan2(lineName);
        validateLineNameIsDuplicate(lineName);
        return parseStringToTrimString(lineName);
    }

    public String inputDeleteLineName(Scanner scanner) {
        inputDeleteLineNameRequestMessage();
        String lineName = scanner.nextLine();
        validateLineNameIsContains(lineName);
        return parseStringToTrimString(lineName);
    }

    public String inputAddStartStationName(Scanner scanner) {
        inputAddStartStationNameRequestMessage();
        String stationName = scanner.nextLine();
        validateStationNameIsContains(stationName);
        return parseStringToTrimString(stationName);
    }

    public String inputAddEndStationName(Scanner scanner) {
        inputAddEndStationNameRequestMessage();
        String stationName = scanner.nextLine();
        validateStationNameIsContains(stationName);
        return parseStringToTrimString(stationName);
    }

    public String inputLineNameToAddSection(Scanner scanner) {
        inputLineNameToAddSectionRequestMessage();
        String lineName = scanner.nextLine();
        validateLineNameIsContains(lineName);
        return parseStringToTrimString(lineName);
    }

    public String inputStationNameToAddSection(Scanner scanner) {
        inputStationNameToAddSectionRequestMessage();
        String stationName = scanner.nextLine();
        validateStationNameIsContains(stationName);
        return parseStringToTrimString(stationName);
    }

    public String inputPositionToAddSection(Scanner scanner) {
        inputPositionToAddSectionRequestMessage();
        String position = scanner.nextLine();
        validatePositionIsDigit(position);
        return parseStringToTrimString(position);
    }

    public String inputLineNameToDeleteSection(Scanner scanner, LineStationRepository lineStation) {
        inputLineNameToDeleteSectionRequestMessage();
        String lineName = scanner.nextLine();
        validateLineNameIsContains(lineName);
        validateStationSizeOfLineIsMoreThan2(lineName, lineStation);
        return parseStringToTrimString(lineName);
    }

    public String inputStationNameToDeleteSection(Scanner scanner) {
        inputStationNameToDeleteSectionRequestMessage();
        String stationName = scanner.nextLine();
        validateStationNameIsContains(stationName);
        return parseStringToTrimString(stationName);
    }
}