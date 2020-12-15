package subway.exception;

public class IllegalFunctionException extends IllegalArgumentException {
    private static final String MESSAGE = "선택할 수 없는 기능입니다. (input: \"%s\")";
    
    public IllegalFunctionException(String inputKey) {
        super(String.format(MESSAGE, inputKey));
    }
}
