package subway.view;

public class ErrorMessage {

    private static final String ERROR_PREFIX= "[ERROR] ";
    private ErrorMessage(){
    }

    public static void printError(String message){
        System.out.println(ERROR_PREFIX+message);
    }

}
