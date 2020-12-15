package subway.controller;

import subway.controller.function.StationFunction;
import subway.controller.message.StationMessage;
import subway.controller.screen.SubwayScreen;
import subway.controller.validation.StationValidator;
import subway.service.StationService;
import subway.view.SubwayView;

public class StationController {
    public static void run() {
        SubwayView.displayScreen(SubwayScreen.STATION_MANAGEMENT);
        SubwayView.notice(StationMessage.SELECT_FUNCTION);
        String functionCode = StationValidator.validateStationFunction(SubwayView.userInput());
        StationFunction.callBy(functionCode);
    }

    public static void stations() {
        SubwayView.notice(StationMessage.NOTICE_STATION_LIST);
        StationService.stations().stream()
                .forEach(station -> SubwayView.info(station.getName()));
        SubwayView.newLine();
    }

    public static void addStation() {
        SubwayView.notice(StationMessage.ENTER_STATION_NAME);
        String stationName = StationValidator.validateStationName(SubwayView.userInput());
        StationService.addStation(stationName);
        SubwayView.info(StationMessage.INFO_ADD_STATION);
    }

    public static void deleteStation() {
        SubwayView.notice(StationMessage.ENTER_STATION_NAME_TO_BE_DELETED);
        String stationName = StationValidator.validateStationNameToBeDeleted(SubwayView.userInput());
        StationService.deleteStationByName(stationName);
        SubwayView.info(StationMessage.INFO_DELETE_STATION);
    }
}
