package subway.SubwayExceptions;

import static subway.dashboard.DashboardWords.ERROR_CANNOT_DELETE_STATION_ON_LINE;

public class ExceptionCannotDeleteStationOnLine extends Exception {
    public ExceptionCannotDeleteStationOnLine() {
        super(ERROR_CANNOT_DELETE_STATION_ON_LINE);
    }
}
