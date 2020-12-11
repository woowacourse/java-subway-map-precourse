package subway.view;

public class ErrorMessage {
    private static final String ERROR_PREFIX= "[ERROR] ";
    private static final String INPUT_NEEDED= " 중에서 입력해 주세요.";
    private static final String OVER_TWO = "2글자 이상이어야 한다.";
    private static final String LAST_LETTER_STATION = "역이름 끝에는 역이라고 붙여주세요.";
    private static final String LAST_LETTER_LINE = "노선이름 끝에는 호선이라고 붙여주세요.";
    private static final String VALUE_EXIST = "이미 존재하는 이름입니다.";
    private ErrorMessage(){
    }

    public static void printMenu(String selections){
        System.out.println(ERROR_PREFIX+selections+INPUT_NEEDED);
    }

    public static void printNameLength(){
        System.out.println(ERROR_PREFIX+OVER_TWO);
    }

    public static void printLastLetterStation(){
        System.out.println(ERROR_PREFIX+LAST_LETTER_STATION);
    }
    public static void printLastLetterLine(){
        System.out.println(ERROR_PREFIX+LAST_LETTER_LINE);
    }



    public static void printValeAlreadyExist(){
        System.out.println(ERROR_PREFIX+VALUE_EXIST);
    }

}
