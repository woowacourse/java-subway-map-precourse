package subway.exception.command;

import subway.util.PrintUtils;

public class InputIsNotInteger extends CommandException {

    @Override
    public void printError() {
        PrintUtils.printError(getHeader() + "정상적인 정수 입력이 아닙니다.");
    }
}
