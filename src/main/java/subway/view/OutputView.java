package subway.view;

import subway.message.ErrorMessage;
import subway.message.GuideMessage;
import subway.message.StationMessage;

public class OutputView {

    private static void spacePrint() {
        System.out.println();
    }

    public static void mainMenuPrint() {
        System.out.println(GuideMessage.MAIN_FUNCTION_LIST.getGuideMessage());
        spacePrint();
    }

    public static void OptionChoicePrint() {
        System.out.println(GuideMessage.CHOICE_OPTION_LIST.getGuideMessage());
    }

    public static void NotSelectableError() {
        System.out.println(ErrorMessage.NOT_SELECTABLE_ERROR.getErrorMessage());
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

    public static void stationDuplcationFailPrint() {
        System.out.println(StationMessage.STATION_ADD_NAME_DUPLICATION_FAIL.getStationMessage());
    }

    public static void stationListPrint(String[] stationList) {
        System.out.println(StationMessage.STATION_LIST.getStationMessage());
        for (String station : stationList) {
            System.out.println(GuideMessage.INFO.getGuideMessage() + station);
        }
    }
}
