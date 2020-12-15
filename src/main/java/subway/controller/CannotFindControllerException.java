package subway.controller;

public class CannotFindControllerException extends RuntimeException {
    private static final String ERROR_MESSAGE = "요청을 처리할 컨트롤러를 찾을 수 없습니다.";

    public CannotFindControllerException() {
        super(ERROR_MESSAGE);
    }
}
