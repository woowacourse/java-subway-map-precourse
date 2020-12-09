package subway.view;

public class ErrorView {
    private static final String errorPrefix = "[ERRPR] ";
    private static final String invalidFunction = "선택할 수 없는 기능입니다.";

    public static void printInvalidFunction(){
        System.out.println(errorPrefix + invalidFunction);
    }
}
