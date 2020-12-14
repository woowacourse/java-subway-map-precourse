package subway.errors;

public class NotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "존재하지 않는 입력 값입니다.";
    }
}
