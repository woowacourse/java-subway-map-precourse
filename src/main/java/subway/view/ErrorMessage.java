package subway.view;

public class ErrorMessage {
    private static final String ERROR_PREFIX= "[ERROR] ";
    private static final String INPUT_NEEDED= " 중에서 입력해 주세요.";
    private static final String OVER_TWO = "2글자 이상이어야 한다.";

    private ErrorMessage(){
    }

    public static void printMenuError(String selections){
        System.out.println(ERROR_PREFIX+selections+INPUT_NEEDED);
    }

    public static void printNameLengthError(){
        System.out.println(ERROR_PREFIX+OVER_TWO);
    }

}
