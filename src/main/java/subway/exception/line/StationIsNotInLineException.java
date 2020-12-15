package subway.exception.line;

import subway.util.PrintUtils;

public class StationIsNotInLineException extends LineException {

    public void printError() {
        PrintUtils.printError(super.getHeader() + "입력한 역이 노선에 존재하지 않습니다.");
    }
}
