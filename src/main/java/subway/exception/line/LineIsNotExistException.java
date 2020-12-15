package subway.exception.line;

import subway.util.PrintUtils;

public class LineIsNotExistException extends LineException {

    public void printError() {
        PrintUtils.printError(super.getHeader() + "입력한 노선이 존재하지 않습니다.");
    }
}
