package subway.view.stationoutput;

import subway.view.InfoView;

public class StationInfoView extends InfoView {
    private static final String INFO = "[INFO] ";
    private static final String REGISTER_INFO = "[INFO] 지하철 역이 등록되었습니다.";
    private static final String DELETE_INFO = "[INFO] 지하철 역이 삭제되었습니다.";

    public static void printRegisterInfo() {
        System.out.println(REGISTER_INFO);
    }

    public static void printDeleteInfo() {
        System.out.println(DELETE_INFO);
    }

    public static void printStation(String stationName) {
        System.out.println(INFO + stationName);
    }
}
