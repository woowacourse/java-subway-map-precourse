package subway.Exception.SectionException;

public class DuplicateStationInLine extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 해당 노선에 역이 이미 존재합니다.";

    public DuplicateStationInLine() {
        super(MESSAGE);
    }
}
