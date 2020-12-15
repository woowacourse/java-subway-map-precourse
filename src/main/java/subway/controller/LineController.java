package subway.controller;

import subway.controller.function.LineFunction;
import subway.controller.message.LineMessage;
import subway.controller.screen.SubwayScreen;
import subway.service.LineService;
import subway.controller.validation.LineValidator;
import subway.service.SectionService;
import subway.view.SubwayView;

public class LineController {
    public static void run() {
        SubwayView.displayScreen(SubwayScreen.LINE_MANAGEMENT);
        SubwayView.notice(LineMessage.SELECT_FUNCTION);
        String functionCode = LineValidator.validateLineFunction(SubwayView.userInput());
        LineFunction.callBy(functionCode);
    }

    public static void lines() {
        SubwayView.notice(LineMessage.NOTICE_LINE_LIST);
        LineService.lines().stream()
                .forEach(line -> SubwayView.info(line.getName()));
        SubwayView.newLine();
    }

    public static void addLine() {
        SubwayView.notice(LineMessage.ENTER_LINE_NAME);
        String lineName = LineValidator.validateLineName(SubwayView.userInput());
        SubwayView.notice(LineMessage.ENTER_UPWARD_STATION_NAME);
        String upwardStationName =
                LineValidator.validateUpwardStationName(SubwayView.userInput());
        SubwayView.notice(LineMessage.ENTER_DOWNWARD_STATION_NAME);
        String downwardStationName =
                LineValidator.validateDownwardStationName(upwardStationName, SubwayView.userInput());

        LineService.addLine(lineName);
        SectionService.createSection(lineName, upwardStationName, downwardStationName);
        SubwayView.info(LineMessage.INFO_ADD_LINE);
    }

    public static void deleteLineByName() {
        SubwayView.notice(LineMessage.ENTER_LINE_NAME_TO_BE_DELETED);
        String lineName = LineValidator.validateLineNameToBeDeleted(SubwayView.userInput());
        LineService.deleteLineByName(lineName);
        SubwayView.info(LineMessage.INFO_DELETE_LINE);
    }
}
