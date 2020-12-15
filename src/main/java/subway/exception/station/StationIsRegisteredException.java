package subway.exception.station;

import subway.util.PrintUtils;

public class StationIsRegisteredException extends StationException {

    @Override
    public void printError() {
        PrintUtils.printError(super.getHeader() + "노선에 등록된 역은 삭제할 수 없습니다.");
    }
}
