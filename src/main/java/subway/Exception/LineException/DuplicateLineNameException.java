package subway.Exception.LineException;

public class DuplicateLineNameException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 이미 등록된 노선 이름입니다.";

    public DuplicateLineNameException() {
        super(MESSAGE);
    }
}
