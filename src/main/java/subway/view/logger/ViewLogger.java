package subway.view.logger;

import subway.view.component.CommonViewComponent;

public class ViewLogger {
    public static void printWhiteSpace(){
        System.out.println();
    }

    public static void printLog(String string){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        System.out.println(stringBuilder.toString());
    }

    public static void printLogWithWhiteSpace(String string){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        System.out.println(stringBuilder.toString());
    }
}
