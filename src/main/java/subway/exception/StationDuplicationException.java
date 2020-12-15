package subway.exception;

import subway.domain.Station;

public class StationDuplicationException extends DuplicationException {

    public StationDuplicationException(Station station) {
        super(station);
    }

    @Override
    public String getMessage() {
        return ERROR + " " + obj.toString() + "은 이미 등록된 역입니다.";
    }
}
