package subway.exception.line;

import subway.util.PrintUtils;

public class LineIsAlreadyExistException extends LineException {

    public void printError() {
        PrintUtils.printError(super.getHeader() + "입력한 노선이 이미 존재합니다.");
    }
}
