package subway.common;

public class ErrorMessage {
    public static final String OUT = "OUT";

    private ErrorMessage() {
    }

    public static void print(ErrorMessageException errorMessageException) {
        System.out.println(errorMessageException.getMessage());
    }
}
