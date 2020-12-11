package subway.view;

public class ErrorMessage {
    private static final String ERROR_PREFIX= "[ERROR] ";
    private static final String INPUT_NEEDED= " 중에서 입력해 주세요.";

    private ErrorMessage(){
    }

    public static void printError(String selections){
        System.out.println(ERROR_PREFIX+selections+INPUT_NEEDED);
    }


}
