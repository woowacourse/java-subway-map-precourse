package subway.view.outputview;

import java.util.List;

public class StationManagementOutputView {
    public static final String STATION_LIST = "## 역 목록";
    public static final String INFO = "[INFO] ";
    public static final String ERROR = "[ERROR] ";

    public void printStations(List<String> stations) {
        System.out.println(STATION_LIST);
        stations.forEach(station -> System.out.println(INFO + station));
        System.out.println();
    }

    public void printActionComplete(String completeMessage) {
        System.out.println(INFO + completeMessage);
        System.out.println();
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR + errorMessage);
        System.out.println();
    }
}
