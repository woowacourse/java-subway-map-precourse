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
        if (!validateMenuRange(menuType.getKeys(), menu)) {
            return inputSelectMenu(scanner, menuType);
        }
        return menu;
    }

    public String inputAddStationName(Scanner scanner) {
        inputAddStationNameRequestMessage();
        String stationName = parseStringToTrimString(scanner.nextLine());
        if (!validateNameLengthIsMoreThan2(stationName) || !validateStationNameIsDuplicate(stationName)) {
            return inputAddStationName(scanner);
        }
        return stationName;
    }

    public String inputDeleteStationName(Scanner scanner, LineStationRepository lineStation) {
        inputDeleteStationNameRequestMessage();
        String stationName = parseStringToTrimString(scanner.nextLine());
        if (!validateStationNameIsContains(stationName) || !validateStationIsContainsLineStation(stationName, lineStation)) {
            return inputDeleteStationName(scanner, lineStation);
        }
        return stationName;
    }

    public String inputAddLineName(Scanner scanner) {
        inputAddLineNameRequestMessage();
        String lineName = parseStringToTrimString(scanner.nextLine());
        if (!validateNameLengthIsMoreThan2(lineName) || !validateLineNameIsDuplicate(lineName)) {
            return inputAddLineName(scanner);
        }
        return lineName;
    }

    public String inputDeleteLineName(Scanner scanner) {
        inputDeleteLineNameRequestMessage();
        String lineName = parseStringToTrimString(scanner.nextLine());
        if (!validateLineNameIsContains(lineName)) {
            return inputDeleteLineName(scanner);
        }
        return lineName;
    }

    public String inputAddStartStationName(Scanner scanner) {
        inputAddStartStationNameRequestMessage();
        String stationName = parseStringToTrimString(scanner.nextLine());
        if (!validateStationNameIsContains(stationName)) {
            return inputAddStartStationName(scanner);
        }
        return stationName;
    }

    public String inputAddEndStationName(Scanner scanner) {
        inputAddEndStationNameRequestMessage();
        String stationName = parseStringToTrimString(scanner.nextLine());
        if (!validateStationNameIsContains(stationName)) {
            return inputAddEndStationName(scanner);
        }
        return stationName;
    }

    public String inputLineNameToAddSection(Scanner scanner) {
        inputLineNameToAddSectionRequestMessage();
        String lineName = parseStringToTrimString(scanner.nextLine());
        if (!validateLineNameIsContains(lineName)) {
            return inputLineNameToAddSection(scanner);
        }
        return lineName;
    }

    public String inputStationNameToAddSection(Scanner scanner) {
        inputStationNameToAddSectionRequestMessage();
        String stationName = parseStringToTrimString(scanner.nextLine());
        if (!validateStationNameIsContains(stationName)) {
            return inputStationNameToAddSection(scanner);
        }
        return stationName;
    }

    public String inputPositionToAddSection(Scanner scanner) {
        inputPositionToAddSectionRequestMessage();
        String position = parseStringToTrimString(scanner.nextLine());
        if (!validatePositionIsDigit(position)) {
            return inputPositionToAddSection(scanner);
        }
        return position;
    }

    public String inputLineNameToDeleteSection(Scanner scanner, LineStationRepository lineStation) {
        inputLineNameToDeleteSectionRequestMessage();
        String lineName = parseStringToTrimString(scanner.nextLine());
        if (!validateLineNameIsContains(lineName) || !validateStationSizeOfLineIsMoreThan2(lineName, lineStation)) {
            return inputLineNameToDeleteSection(scanner, lineStation);
        }
        return lineName;
    }

    public String inputStationNameToDeleteSection(Scanner scanner) {
        inputStationNameToDeleteSectionRequestMessage();
        String stationName = parseStringToTrimString(scanner.nextLine());
        if (!validateStationNameIsContains(stationName)) {
            return inputStationNameToDeleteSection(scanner);
        }
        return stationName;
    }
}