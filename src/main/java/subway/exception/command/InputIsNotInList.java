package subway.exception.command;

import subway.util.PrintUtils;

public class InputIsNotInList extends CommandException{

    @Override
    public void printError() {
        PrintUtils.printError(getHeader() + "실행할 수 있는 기능이 아닙니다.");
    }
}
