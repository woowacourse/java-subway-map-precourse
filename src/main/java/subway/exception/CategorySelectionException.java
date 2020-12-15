package subway.exception;

public class CategorySelectionException extends IllegalArgumentException{
    private static final String message = "[ERROR] 잘못된 입력입니다. 다시 입력해주세요.";
    public CategorySelectionException(){
        super(message);
    }
}
