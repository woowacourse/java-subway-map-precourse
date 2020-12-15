package subway.views;


public class ErrorMessage {

    static final String error = "[ERROR] ";
    static final String wrongSelection = "선택할 수 없는 기능입니다.";
    static final String sameStationName = "이미 등록된 역 이름입니다.";
    static final String sameLineName = "이미 등록된 노선 이름입니다.";
    static final String nameLengthError = "이름은 2글자 이상이어야 합니다.";
    static final String stationNotFound = "등록된 역 이름이 아닙니다.";
    static final String lineNotFound = "등록된 역 이름이 아닙니다.";
    static final String wrongPosition = "존재하지 않는 위치입니다.";
    static final String stationInLine = "노선에 등록된 역은 삭제할 수 없습니다.";
    static final String sectionSizeError = "역이 2개 이하인 노선에서는 역을 삭제할 수 없습니다.";

    public static void showWrongSelectionMessage() {
        System.out.println(error + wrongSelection);
    }

    public static void showStationDeleteError() {
        System.out.println(error + stationNotFound);
    }

    public static void showLineDeleteError() {
        System.out.println(error + lineNotFound);
    }

    public static void showStationSameNameError() {
        System.out.println(error + sameStationName);
    }

    public static void showStationNameLengthError() {
        System.out.println(error + nameLengthError);
    }

    public static void showLineSameNameError() {
        System.out.println(error + sameLineName);
    }

    public static void showLineNameLengthError() {
        System.out.println(error + nameLengthError);
    }

    public static void showStationInLineError() {
        System.out.println(error + stationInLine);
    }

    public static void showSectionDeleteSizeError() {
        System.out.println(error + sectionSizeError);
    }
}
