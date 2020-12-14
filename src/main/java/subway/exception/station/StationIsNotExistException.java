package subway.exception.station;

import subway.util.PrintUtils;

public class  StationIsNotExistException extends StationException {

    @Override
    public void printError() {
        PrintUtils.printError(super.getHeader() + "역이 존재하지 않습니다.");
    }
}
