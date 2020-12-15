package subway.view;

import subway.Constant;
import subway.domain.menu.MainMenu;

public class OutputView {

    public OutputView() {
    }

    public static void printMainView(){
        System.out.print(Constant.VIEW_HEADER);
        System.out.println(Constant.MAIN_VIEW_HEADER);
        for(MainMenu menu : MainMenu.values()) {
            System.out.printf(Constant.VIEW_FORMAT, menu.getOrder(), menu.getMessage());
        }
        System.out.println();
    }

    public static void printManagementView(String menu){

    }

    public static void printSubwayMap(){

    }

    public static void printSelectFunction(String askingMessage){

    }

    public static void printFunctionResult(String resultMessage){

    }

    public static void printError(String errorMessage){

    }
}
