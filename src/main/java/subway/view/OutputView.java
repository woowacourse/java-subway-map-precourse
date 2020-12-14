package subway.view;

import subway.message.CommonMessage;
import subway.message.LineMessage;
import subway.message.StationMessage;

public class OutputView {

    private static void spacePrint() {
        System.out.println();
    }

    public static void mainMenuPrint() {
        System.out.println(CommonMessage.MAIN_FUNCTION_LIST.getCommonMessage());
        spacePrint();
    }

    public static void OptionChoicePrint() {
        System.out.println(CommonMessage.CHOICE_OPTION_LIST.getCommonMessage());
    }

    public static void NotSelectableError() {
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

    public static void LineAddGuidePrint() {
        System.out.println(LineMessage.LINE_ADD_GUIDE.getLineMessage());
    }

    public static void LineAddSuccessPrint() {
        System.out.println(LineMessage.LINE_ADD_SUCCESS.getLineMessage());
    }

    public static void upTerminusAddGuidePrint() {
        System.out.println(LineMessage.LINE_UPTERMINUS_ADD_GUIDE.getLineMessage());
    }

    public static void LineNameDuplicationFailPrint() {
        System.out.println(LineMessage.LINE_NAME_DUPLICATION_ERROR.getLineMessage());
    }

    public static void downTerminusAddGuidePrint() {
        System.out.println(LineMessage.LINE_DOWNTERMINUS_ADD_GUIDE.getLineMessage());
    }

    public static void LineAddFailPrint() {
        System.out.println(LineMessage.LINE_ADD_STATION_NAME_FAIL.getLineMessage());
    }

    public static void LineNameCountLimitFailPrint() {
        System.out.println(LineMessage.LINE_ADD_LIMIT_FAIL.getLineMessage());
    }

    public static void twoNameSameErrorPrint() {
        System.out.println(LineMessage.LINE_TWO_NAME_SAME_ERROR.getLineMessage());
    }
}
