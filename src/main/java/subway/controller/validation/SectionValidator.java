package subway.controller.validation;

import subway.controller.message.LineMessage;
import subway.controller.message.SectionMessage;
import subway.controller.message.StationMessage;
import subway.service.LineService;
import subway.service.SectionService;
import subway.view.SubwayView;

public class SectionValidator {
    private static final String SECTION_FUNCTION_REGULAR_EXPRESSION = "^([1-2B])$";
    private static final int MINIMUM_NUMBER_OF_STATIONS_ON_LINE = 0;

    public static boolean isValidSectionFunction(String functionCode) {
        if (functionCode.matches(SECTION_FUNCTION_REGULAR_EXPRESSION)) {
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String stringOrder) {
        try {
            int order = Integer.parseInt(stringOrder);
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
        return true;
    }

    public static boolean isValidOrder(String stringOrder) {
        if (!isNumeric(stringOrder)) {
            return false;
        }

        int order = Integer.parseInt(stringOrder);

        if (order >= MINIMUM_NUMBER_OF_STATIONS_ON_LINE
                && order <= SectionService.sections().size()) {
            return true;
        }
        return false;
    }

    public static String validateSectionFunction(String functionCode) {
        if (isValidSectionFunction(functionCode)) {
            return functionCode;
        }

        SubwayView.error(SectionMessage.ERROR_SELECT_FUNCTION);
        SubwayView.notice(SectionMessage.SELECT_FUNCTION);
        functionCode = SubwayView.userInput();
        functionCode = validateSectionFunction(functionCode);
        return functionCode;
    }

    public static String validateLineNameExist(String lineName) {
        if (LineValidator.hasLineName(lineName)) {
            return lineName;
        }

        SubwayView.error(LineMessage.ERROR_NOT_EXIST_LINE);
        SubwayView.notice(SectionMessage.ENTER_LINE_NAME);
        lineName = SubwayView.userInput();
        lineName = validateLineNameExist(lineName);
        return lineName;
    }

    public static String validateStationNameExist(String stationName) {
        if (StationValidator.hasStationName(stationName)) {
            return stationName;
        }

        SubwayView.error(StationMessage.ERROR_NOT_EXIST_STATION);
        SubwayView.notice(SectionMessage.ENTER_STATION_NAME);
        stationName = SubwayView.userInput();
        stationName = validateStationNameExist(stationName);
        return stationName;
    }

    public static int validateOrder(String stringOrder) {
        if (isValidOrder(stringOrder)) {
            int order = Integer.parseInt(stringOrder);
            return order;
        }

        SubwayView.error(SectionMessage.ERROR_INVALID_ORDER);
        SubwayView.notice(SectionMessage.ENTER_ORDER);
        stringOrder = SubwayView.userInput();
        int order = validateOrder(stringOrder);
        return order;
    }

    public static String validateSectionToBeDeleted(String lineName, String stationName) {

        stationName = validateStationNameExist(stationName);
        return stationName;
    }
}
