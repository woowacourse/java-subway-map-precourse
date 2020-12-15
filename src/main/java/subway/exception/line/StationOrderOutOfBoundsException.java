package subway.exception.line;

import subway.util.PrintUtils;

public class StationOrderOutOfBoundsException extends LineException {

    public void printError() {
        PrintUtils.printError(super.getHeader() + "입력한 순서에 역을 위치시킬 수 없습니다.");
    }
}
