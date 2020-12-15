package subway.exception.command;

import subway.exception.CustomException;

public abstract class CommandException extends CustomException {

    private final String HEADER = "명령 오류 - ";

    public String getHeader() {
        return HEADER;
    }

    abstract public void printError();
}
