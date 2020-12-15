package subway.controller;

import subway.controller.function.SectionFunction;
import subway.controller.message.SectionMessage;
import subway.controller.screen.SubwayScreen;
import subway.controller.validation.SectionValidator;
import subway.service.SectionService;
import subway.view.SubwayView;

public class SectionController {
    public static void run() {
        SubwayView.displayScreen(SubwayScreen.SECTION_MANAGEMENT);
        SubwayView.notice(SectionMessage.SELECT_FUNCTION);
        String functionCode = SectionValidator.validateSectionFunction(SubwayView.userInput());
        SectionFunction.callBy(functionCode);
    }

    public static void sections() {
        SubwayView.notice(SectionMessage.NOTICE_SECTION_LIST);
        SectionService.sections().stream()
                .forEach(section -> SubwayView.printSubwayMap(section));
        SubwayView.newLine();
    }

    public static void addSection() {
        SubwayView.notice(SectionMessage.ENTER_LINE_NAME);
        String lineName = SectionValidator.validateLineNameExist(SubwayView.userInput());
        SubwayView.notice(SectionMessage.ENTER_STATION_NAME);
        String stationName = SectionValidator.validateStationNameExist(SubwayView.userInput());
        SubwayView.notice(SectionMessage.ENTER_ORDER);
        int order = SectionValidator.validateOrder(SubwayView.userInput());
        SectionService.addSection(lineName, stationName, order);
        SubwayView.info(SectionMessage.INFO_ADD_SECTION);
    }

    public static void deleteSection() {
        SubwayView.notice(SectionMessage.ENTER_LINE_NAME_TO_BE_DELETED);
        String lineName = SectionValidator.validateLineNameExist(SubwayView.userInput());
        SubwayView.notice(SectionMessage.ENTER_STATION_NAME_TO_BE_DELETED);
        String stationName = SectionValidator.validateLineNameToBeDeleted(SubwayView.userInput());
        SectionService.deleteSectionByName(lineName, stationName);
        SubwayView.info(SectionMessage.INFO_DELETE_SECTION);
    }
}
