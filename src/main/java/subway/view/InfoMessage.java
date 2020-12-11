package subway.view;

public class InfoMessage {
    private static final String INFO_PREFIX= "[INFO] ";
    private InfoMessage(){
    }

    public static void printInfo(String message){
        System.out.println(INFO_PREFIX+message);
    }


}
