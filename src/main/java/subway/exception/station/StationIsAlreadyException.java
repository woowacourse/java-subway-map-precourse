package subway.exception.station;

import subway.util.PrintUtils;

public class StationIsAlreadyException extends StationException {

    @Override
    public void printError() {
        PrintUtils.printError(super.getHeader() + "역이 이미 존재합니다.");
    }
}
