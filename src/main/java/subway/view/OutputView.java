package subway.view;

import subway.message.CommonMessage;
import subway.message.LineMessage;
import subway.message.SectionMessage;
import subway.message.StationMessage;

public class OutputView {

    private static void spacePrint() {
        System.out.println();
    }

    public static void mainMenuPrint() {
        System.out.println(CommonMessage.MAIN_FUNCTION_LIST.getCommonMessage());
        spacePrint();
    }

    public static void optionChoicePrint() {
        System.out.println(CommonMessage.CHOICE_OPTION_LIST.getCommonMessage());
    }

    public static void notSelectableError() {
        System.out.println(CommonMessage.NOT_SELECTABLE_ERROR.getCommonMessage());
        spacePrint();
    }

    public static void stationMenuPrint() {
        System.out.println(StationMessage.STATION_FUNCTION_LIST.getStationMessage());
    }

    public static void stationAddGuidePrint() {
        System.out.println(StationMessage.STATION_ADD_GUIDE.getStationMessage());
    }

    public static void stationAddSuccessPrint() {
        System.out.println(StationMessage.STATION_ADD_SUCCESS.getStationMessage());
    }

    public static void stationAddFailPrint() {
        System.out.println(StationMessage.STATION_ADD_NAME_LIMIT_FAIL.getStationMessage());
    }

    public static void stationDuplicationFailPrint() {
        System.out.println(StationMessage.STATION_ADD_NAME_DUPLICATION_FAIL.getStationMessage());
    }

    public static void stationListPrint(String[] stationList) {
        System.out.println(StationMessage.STATION_LIST.getStationMessage());
        for (String station : stationList) {
            System.out.println(CommonMessage.INFO.getCommonMessage() + station);
        }
    }

    public static void zeroStationListErrorPrint() {
        System.out.println(StationMessage.STATION_LIST_FIND_FAIL.getStationMessage());
    }

    public static void stationDeleteSuccessPrint() {
        System.out.println(StationMessage.STATION_DELETE_SUCCESS.getStationMessage());
    }

    public static void stationDeleteGuidePrint() {
        System.out.println(StationMessage.STATION_DELETE_GUIDE.getStationMessage());
    }

    public static void stationNameDeleteErrorPrint() {
        System.out.println(StationMessage.STATION_NAME_DELETE_ERROR.getStationMessage());
    }

    public static void lineRegisteredStationErrorPrint() {
        System.out.println(StationMessage.NOTION_REGISTERED_STATION_ERROR.getStationMessage());
    }

    public static void lineMenuPrint() {
        System.out.println(LineMessage.LINE_FUNCTION_LIST.getLineMessage());
    }

    public static void lineAddSuccessPrint() {
        System.out.println(LineMessage.LINE_ADD_SUCCESS.getLineMessage());
    }

    public static void lineAddGuidePrint() {
        System.out.println(LineMessage.LINE_ADD_GUIDE.getLineMessage());
    }

    public static void upTerminusAddGuidePrint() {
        System.out.println(LineMessage.LINE_UPTERMINUS_ADD_GUIDE.getLineMessage());
    }

    public static void lineNameDuplicationFailPrint() {
        System.out.println(LineMessage.LINE_NAME_DUPLICATION_ERROR.getLineMessage());
    }

    public static void downTerminusAddGuidePrint() {
        System.out.println(LineMessage.LINE_DOWNTERMINUS_ADD_GUIDE.getLineMessage());
    }

    public static void lineAddFailPrint() {
        System.out.println(LineMessage.LINE_ADD_STATION_NAME_FAIL.getLineMessage());
    }

    public static void lineNameCountLimitFailPrint() {
        System.out.println(LineMessage.LINE_ADD_LIMIT_FAIL.getLineMessage());
    }

    public static void twoNameSameErrorPrint() {
        System.out.println(LineMessage.LINE_TWO_NAME_SAME_ERROR.getLineMessage());
    }

    public static void zeroLineListErrorPrint() {
        System.out.println(LineMessage.LINE_LIST_FIND_FAIL.getLineMessage());
    }

    public static void lineListPrint(String[] lineList) {
        System.out.println(LineMessage.LINE_LIST.getLineMessage());
        for (String line : lineList) {
            System.out.println(CommonMessage.INFO.getCommonMessage() + line);
        }
    }

    public static void lineDeleteGuidePrint() {
        System.out.println(LineMessage.LINE_DELETE_GUIDE.getLineMessage());
    }

    public static void sectionMenuPrint() {
        System.out.println(SectionMessage.SECTION_FUNCTION_LIST.getSectionMessage());
    }

    public static void sectionAddLineNamePrint() {
        System.out.println(SectionMessage.SECTION_GUIDE_TO_LINE.getSectionMessage());
    }

    public static void sectionAddStationNamePrint() {
        System.out.println(SectionMessage.SECTION_GUIDE_TO_STATION.getSectionMessage());
    }

    public static void sectionAddIndexPrint() {
        System.out.println(SectionMessage.SECTION_GUIDE_TO_INDEX.getSectionMessage());
    }

    public static void sectionNotFoundLineError() {
        System.out.println(SectionMessage.SECTION_NOT_FOUND_LINE_NAME_ERROR.getSectionMessage());
    }

    public static void sectionNotFoundStationError() {
        System.out.println(SectionMessage.SECTION_NOT_FOUND_STATION_NAME_ERROR.getSectionMessage());
    }

    public static void isNotDigitPrint() {
        System.out.println(SectionMessage.IS_NOT_DIGIT.getSectionMessage());
    }

    public static void outOfRange() {
        System.out.println(SectionMessage.OUT_OF_RANGE.getSectionMessage());
    }

    public static void sectionAddSuccess() {
        System.out.println(SectionMessage.SECTION_ADD_SUCCESS.getSectionMessage());
    }

    public static void sectionDeleteLineNamePrint() {
        System.out.println(SectionMessage.SECTION_DELETE_LINE_NAME.getSectionMessage());
    }

    public static void sectionDeleteStationNamePrint() {
        System.out.println(SectionMessage.SECTION_DELETE_STATION_NAME.getSectionMessage());
    }
}
