package subway.validator;

public class IndexValidator extends Validator {

    public static final String NOT_NUMERIC_ERROR = "숫자만 입력해주세요.";

    @Override
    public void validate(String input) {
        super.validate(input);
        checkNumeric(input);
    }

    private void checkNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR);
        }
    }
}
