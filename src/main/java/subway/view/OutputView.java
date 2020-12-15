package subway.view;

import subway.Constant;
import subway.domain.menu.MainMenu;
import subway.domain.menu.ManagementMenu;
import subway.domain.menu.ServiceList;

import java.util.List;

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

    public static void printManagementView(ServiceList service, List<ManagementMenu> menuList){
        System.out.print(Constant.VIEW_HEADER);
        System.out.printf(Constant.MANAGEMENT_VIEW_HEADER_FORMAT, service.getName());
        for(ManagementMenu menu : menuList) {
            System.out.printf(Constant.MANAGEMENT_VIEW_BODY_FORMAT, menu.getOrder(), service.getName(), menu.getMessage());
        }
        System.out.println();
    }

    public static void printSubwayMap(){

    }

    public static void printSelectFunction(String askingMessage){

    }

    public static void printFunctionResult(String resultMessage){

    }

    public static void printError(String errorMessage){
        System.out.print(Constant.ILLEGAL_ARGUMENT_EXCEPTION_HEADER);
        System.out.println(errorMessage);
        System.out.println();
    }
}
