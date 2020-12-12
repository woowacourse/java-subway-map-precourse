package subway.utils;

public class InfoUtils {
    private static final String FORMAT = "[INFO] %s";
    private String msg;

    public void print(Object arg){
        System.out.println(String.format(FORMAT, arg));
    }

    public void printAddStation(){
        msg = "지하철 역이 등록되었습니다";
        print(msg);
    }
}
