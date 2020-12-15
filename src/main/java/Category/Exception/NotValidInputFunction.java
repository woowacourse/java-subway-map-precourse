package Category.Exception;

public class NotValidInputFunction extends IllegalArgumentException {
    public static final String MESSAGE = "[ERROR] 선택할 수 없는 기능입니다";

    public NotValidInputFunction() {
        super(MESSAGE);
    }
}
