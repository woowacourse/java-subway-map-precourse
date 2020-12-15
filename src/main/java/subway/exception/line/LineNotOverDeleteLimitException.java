package subway.exception.line;

import subway.util.PrintUtils;

public class LineNotOverDeleteLimitException extends LineException{

    public void printError() {
        PrintUtils.printError(super.getHeader() + "노선은 최소 두 개 이상의 역을 가지고 있어야 합니다.");
    }
}
