package subway.exception;

public abstract class CustomException extends IllegalArgumentException {
    abstract public void printError();
}
