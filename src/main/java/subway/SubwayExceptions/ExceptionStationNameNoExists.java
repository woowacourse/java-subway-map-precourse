package subway.SubwayExceptions;

import static subway.dashboard.DashboardWords.ERROR_STATION_NAME_NO_EXISTS;

public class ExceptionStationNameNoExists extends Exception {
    public ExceptionStationNameNoExists() {
        super(ERROR_STATION_NAME_NO_EXISTS);
    }
}
