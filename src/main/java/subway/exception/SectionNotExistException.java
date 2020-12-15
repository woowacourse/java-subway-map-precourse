package subway.exception;

public class SectionNotExistException extends RuntimeException{
    private static final String message = "[ERROR] 입력하신 구간은 존재하지 않습니다.";
    public SectionNotExistException(){
        super(message);
    }
}
