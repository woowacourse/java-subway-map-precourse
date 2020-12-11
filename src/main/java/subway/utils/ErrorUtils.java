package subway.utils;

public class ErrorUtils {
    private static final String FORMAT = "[ERROR] %s";
    private String msg;

    public void print(Object arg){
        System.out.println(String.format(FORMAT, arg));
    }

    public void printWrongInputError(){
        msg = "잘못된 입력입니다.";
        print(msg);
    }

    public void printEmptyError(){
        msg = "선택할 수 없는 기능입니다.";
        print(msg);
    }

    public void printDuplicateStationError(){
        msg = "이미 등록된 역 이름입니다.";
        print(msg);
    }

    public void printDuplicateLineError(){
        msg = "이미 등록된 노선 이름입니다.";
        print(msg);
    }
}
