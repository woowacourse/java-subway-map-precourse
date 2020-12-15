package subway.controller.validation;

import subway.controller.message.LineMessage;
import subway.controller.message.StationMessage;
import subway.service.LineService;
import subway.view.SubwayView;

import java.util.Objects;

public class LineValidator {
    private static final String LINE_FUNCTION_REGULAR_EXPRESSION = "^([1-3B])$";
    private static final int MINIMUM_LINE_NAME_LENGTH = 2;

    public static boolean isValidLineFunction(String functionCode) {
        if (functionCode.matches(LINE_FUNCTION_REGULAR_EXPRESSION)) {
            return true;
        }
        return false;
    }

    public static boolean isValidLineNameLength(String lineName) {
        if (lineName.length() >= MINIMUM_LINE_NAME_LENGTH) {
            return true;
        }
        return false;
    }

    public static Boolean hasLineName(String lineName) {
        return LineService.lines().stream()
                .anyMatch(line -> line.getName().equals(lineName));
    }

    public static String validateLineFunction(String functionCode) {
        if (isValidLineFunction(functionCode)) {
            return functionCode;
        }

        SubwayView.error(LineMessage.ERROR_SELECT_FUNCTION);
        SubwayView.notice(LineMessage.SELECT_FUNCTION);
        functionCode = SubwayView.userInput();
        functionCode = validateLineFunction(functionCode);
        return functionCode;
    }

    public static String validateLineNameLength(String lineName) {
        if (isValidLineNameLength(lineName)) {
            return lineName;
        }

        SubwayView.error(LineMessage.ERROR_INVALID_LINE_NAME_LENGTH);
        SubwayView.notice(LineMessage.ENTER_LINE_NAME);
        lineName = SubwayView.userInput();
        lineName = validateLineName(lineName);
        return lineName;
    }

    public static String validateDuplicateLineName(String lineName) {
        if (!hasLineName(lineName)) {
            return lineName;
        }

        SubwayView.error(LineMessage.ERROR_DUPLICATE_LINE_NAME);
        SubwayView.notice(LineMessage.ENTER_LINE_NAME);
        lineName = SubwayView.userInput();
        lineName = validateLineName(lineName);
        return lineName;
    }

    public static String validateLineNameExist(String lineName) {
        if (hasLineName(lineName)) {
            return lineName;
        }

        SubwayView.error(LineMessage.ERROR_NOT_EXIST_LINE);
        SubwayView.notice(LineMessage.ENTER_LINE_NAME_TO_BE_DELETED);
        lineName = SubwayView.userInput();
        lineName = validateLineNameToBeDeleted(lineName);
        return lineName;
    }

    public static String validateLineNameToBeDeleted(String lineName) {
        lineName = validateLineNameExist(lineName);
        return lineName;
    }

    public static String validateLineName(String lineName) {
        lineName = validateLineNameLength(lineName);
        lineName = validateDuplicateLineName(lineName);
        return lineName;
    }

    public static String validateUpwardStationName(String upwardStationName) {
        if (StationValidator.hasStationName(upwardStationName)) {
            return upwardStationName;
        }

        SubwayView.error(StationMessage.ERROR_NOT_EXIST_STATION);
        SubwayView.notice(LineMessage.ENTER_UPWARD_STATION_NAME);
        upwardStationName = SubwayView.userInput();
        upwardStationName = validateUpwardStationName(upwardStationName);
        return upwardStationName;
    }

    public static String validateDuplicateDownwardStationName(String upwardStationName,
                                                              String downwardStationName) {
        if (!Objects.equals(upwardStationName, downwardStationName)) {
            return downwardStationName;
        }

        SubwayView.error(StationMessage.ERROR_DUPLICATE_STATION_NAME);
        SubwayView.notice(LineMessage.ENTER_DOWNWARD_STATION_NAME);
        downwardStationName = SubwayView.userInput();
        downwardStationName = validateDownwardStationName(upwardStationName, downwardStationName);
        return downwardStationName;
    }

    public static String validateDownwardStationNameExist(String upwardStationName,
                                                          String downwardStationName) {
        if (StationValidator.hasStationName(downwardStationName)) {
            return downwardStationName;
        }

        SubwayView.error(StationMessage.ERROR_NOT_EXIST_STATION);
        SubwayView.notice(LineMessage.ENTER_DOWNWARD_STATION_NAME);
        downwardStationName = SubwayView.userInput();
        downwardStationName = validateDownwardStationName(upwardStationName, downwardStationName);
        return downwardStationName;
    }

    public static String validateDownwardStationName(String upwardStationName,
                                                     String downwardStationName) {
        downwardStationName =
                validateDuplicateDownwardStationName(upwardStationName, downwardStationName);
        downwardStationName =
                validateDownwardStationNameExist(upwardStationName, downwardStationName);
        return downwardStationName;
    }
}
