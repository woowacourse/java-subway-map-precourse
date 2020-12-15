package subway.exception.line;

import subway.util.PrintUtils;

public class LineNameNotOverLimit extends LineException {

    @Override
    public void printError() {
        PrintUtils.printError(super.getHeader() + "노선 이름은 두 글자 이상이어야 합니다.");
    }
}
