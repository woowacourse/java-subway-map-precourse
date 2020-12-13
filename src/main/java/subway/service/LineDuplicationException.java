package subway.service;

public class LineDuplicationException extends RuntimeException {
    private static final String ERROR_MESSAGE = "이미 등록된 노선 이름입니다.";

    public LineDuplicationException() {
        super(ERROR_MESSAGE);
    }
}
