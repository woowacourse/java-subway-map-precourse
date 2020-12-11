package subway.exception;

public class InvalidInputException extends RuntimeException {

    private final String ERROR_HEADER = "\n[ERROR] ";
    private ExceptionCode exceptionCode;

    public InvalidInputException(ExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public enum ExceptionCode {
        INVALID_SERVICE_CODE,
        INVALID_FUNCTION_CODE,
        DUPLICATE_STATION,
        DUPLICATE_LINE,
        NO_SUCH_STATION,
        NO_SUCH_LINE,
        INVALID_NAME_LENGTH,
        NON_NUMBER_INPUT,
        OUT_OF_LINE_RANGE,
        NO_LINK_AVAILABLE,
        STATION_LINKED;

    }

    public String getMessage() {
        if (exceptionCode.equals(ExceptionCode.INVALID_SERVICE_CODE) || exceptionCode.equals(ExceptionCode.INVALID_FUNCTION_CODE))
            return ERROR_HEADER + "선택할 수 없는 기능입니다.";
        if (exceptionCode.equals(ExceptionCode.DUPLICATE_STATION))
            return ERROR_HEADER + "이미 등록된 역 이름입니다.";
        if (exceptionCode.equals(ExceptionCode.DUPLICATE_LINE))
            return ERROR_HEADER + "이미 등록된 노선 이름입니다.";
        if (exceptionCode.equals(ExceptionCode.NO_SUCH_STATION))
            return ERROR_HEADER + "존재하지 않는 역 이름입니다.";
        if (exceptionCode.equals(ExceptionCode.NO_SUCH_LINE))
            return ERROR_HEADER + "존재하지 않는 노선 이름입니다.";
        if (exceptionCode.equals(ExceptionCode.INVALID_NAME_LENGTH))
            return ERROR_HEADER + "이름은 두 글자 이상이어야 합니다.";
        if (exceptionCode.equals(ExceptionCode.NON_NUMBER_INPUT))
            return ERROR_HEADER + "순서는 숫자로 입력해야 합니다.";
        if (exceptionCode.equals(ExceptionCode.OUT_OF_LINE_RANGE))
            return ERROR_HEADER + "순서는 해당 노선의 범위 안에서 입력해야 합니다.";
        if (exceptionCode.equals(ExceptionCode.NO_LINK_AVAILABLE))
            return ERROR_HEADER + "역이 두 개 이하인 노선은 삭제할 수 없습니다";
        if (exceptionCode.equals(ExceptionCode.STATION_LINKED))
            return ERROR_HEADER + "노선에 연결된 역은 삭제할 수 없습니다";
        return "";
    }
}
