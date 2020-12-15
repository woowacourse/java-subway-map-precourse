package subway.controller.validation;

import subway.controller.message.StationMessage;
import subway.domain.Section;
import subway.service.SectionService;
import subway.service.StationService;
import subway.view.SubwayView;

import java.util.Objects;

public class StationValidator {
    private static final String STATION_FUNCTION_REGULAR_EXPRESSION = "^([1-3B])$";
    private static final int MINIMUM_STATION_NAME_LENGTH = 2;

    public static boolean isValidStationFunction(String functionCode) {
        if (functionCode.matches(STATION_FUNCTION_REGULAR_EXPRESSION)) {
            return true;
        }
        return false;
    }

    public static boolean isValidStationNameLength(String stationName) {
        if (stationName.length() >= MINIMUM_STATION_NAME_LENGTH) {
            return true;
        }
        return false;
    }

    public static Boolean hasStationName(String stationName) {
        return StationService.stations().stream()
                .anyMatch(station -> station.getName().equals(stationName));
    }

    public static String validateStationFunction(String functionCode) {
        if (isValidStationFunction(functionCode)) {
            return functionCode;
        }

        SubwayView.error(StationMessage.ERROR_SELECT_FUNCTION);
        SubwayView.notice(StationMessage.SELECT_FUNCTION);
        functionCode = SubwayView.userInput();
        functionCode = validateStationFunction(functionCode);
        return functionCode;
    }

    public static String validateStationNameLength(String stationName) {
        if (isValidStationNameLength(stationName)) {
            return stationName;
        }

        SubwayView.error(StationMessage.ERROR_INVALID_STATION_NAME_LENGTH);
        SubwayView.notice(StationMessage.ENTER_STATION_NAME);
        stationName = SubwayView.userInput();
        stationName = validateStationName(stationName);
        return stationName;
    }

    public static String validateDuplicateStationName(String stationName) {
        if (!hasStationName(stationName)) {
            return stationName;
        }

        SubwayView.error(StationMessage.ERROR_DUPLICATE_STATION_NAME);
        SubwayView.notice(StationMessage.ENTER_STATION_NAME);
        stationName = SubwayView.userInput();
        stationName = validateStationName(stationName);
        return stationName;
    }

    public static String validateStationName(String stationName) {
        stationName = validateStationNameLength(stationName);
        stationName = validateDuplicateStationName(stationName);
        return stationName;
    }

    public static String validateStationNameExist(String stationName) {
        if (hasStationName(stationName)) {
            return stationName;
        }

        SubwayView.error(StationMessage.ERROR_NOT_EXIST_STATION);
        SubwayView.notice(StationMessage.ENTER_STATION_NAME_TO_BE_DELETED);
        stationName = SubwayView.userInput();
        stationName = validateStationNameToBeDeleted(stationName);
        return stationName;
    }

    public static boolean findAddedToLine(String stationName, Section section) {
        return section.getStations().stream()
                .anyMatch(station -> Objects.equals(station.getName(), stationName));
    }

    public static boolean findAddedToLine(String stationName) {
        return SectionService.sections().stream()
                .anyMatch(section -> findAddedToLine(stationName, section));
    }

    public static String isAddedToLine(String stationName) {
        if (!findAddedToLine(stationName)) {
            return stationName;
        }

        SubwayView.error(StationMessage.ERROR_STATION_ADDED_TO_LINE);
        SubwayView.notice(StationMessage.ENTER_STATION_NAME_TO_BE_DELETED);
        stationName = SubwayView.userInput();
        stationName = validateStationNameToBeDeleted(stationName);
        return stationName;
    }

    public static String validateStationNameToBeDeleted(String stationName) {
        stationName = validateStationNameExist(stationName);
        stationName = isAddedToLine(stationName);
        return stationName;
    }
}
