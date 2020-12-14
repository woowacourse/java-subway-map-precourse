package subway.exception;

public class SectionSizeException extends RuntimeException{
    private static final String ERROR_MESSAGE = "[ERROR] 노선에는 최소 2개 이상의 역이 존재해야 합니다.";

    public SectionSizeException () {
        super(ERROR_MESSAGE);
    }
}
