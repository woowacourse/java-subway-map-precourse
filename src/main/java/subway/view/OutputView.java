package subway.view;

import subway.Constant;
import subway.domain.data.Line;
import subway.domain.data.Station;
import subway.domain.menu.MainMenu;
import subway.domain.menu.ManagementMenu;
import subway.domain.menu.ServiceList;

import java.util.List;

public class OutputView {

    public OutputView() {
    }

    public static void printMainView(){
        System.out.println();
        System.out.print(Constant.VIEW_HEADER);
        System.out.println(Constant.MAIN_VIEW_HEADER);
        for(MainMenu menu : MainMenu.values()) {
            System.out.printf(Constant.VIEW_FORMAT, menu.getOrder(), menu.getMessage());
        }
    }

    public static void printManagementView(ServiceList service, List<ManagementMenu> menuList){
        System.out.println();
        System.out.print(Constant.VIEW_HEADER);
        System.out.printf(Constant.MANAGEMENT_VIEW_HEADER_FORMAT, service.getName());
        for(ManagementMenu menu : menuList) {
            System.out.printf(Constant.MANAGEMENT_VIEW_BODY_FORMAT, menu.getOrder(), service.getName(), menu.getMessage());
        }
    }

    public static void printSubwayMap(){

    }

    public static void printAskingFunction(String askingMessage){
        System.out.println();
        System.out.print(Constant.VIEW_HEADER);
        System.out.println(askingMessage);
    }

    public static void printInputData(String format, String service){
        System.out.println();
        System.out.print(Constant.VIEW_HEADER);
        System.out.printf(format, service);
    }

    public static void printFunctionResult(String resultMessageFormat, String service){
        System.out.println();
        System.out.print(Constant.RESULT_HEADER);
        System.out.printf(resultMessageFormat, service);
        System.out.println();
    }

    public static void printError(String errorMessage){
        System.out.println();
        System.out.print(Constant.ILLEGAL_ARGUMENT_EXCEPTION_HEADER);
        System.out.println(errorMessage);
        System.out.println();
    }

    public static void printErrorWithFormat(String errorFormat, String service){
        System.out.println();
        System.out.print(Constant.ILLEGAL_ARGUMENT_EXCEPTION_HEADER);
        System.out.printf(errorFormat, service);
        System.out.println();
    }

    public static void printStationList(List<Station> list, String service){
        System.out.println();
        if(list.isEmpty()){
            System.out.print(Constant.ILLEGAL_ARGUMENT_EXCEPTION_HEADER);
            System.out.printf(Constant.FIND_EMPTY_LIST + "\n", service);
            return;
        }

        System.out.print(Constant.VIEW_HEADER);
        System.out.println(Constant.STATION_LIST_HEADER);
        for(Station station : list) {
            System.out.println(Constant.RESULT_HEADER + station.getName());
        }
        System.out.println();
    }
    public static void printLineList(List<Line> list, String service){
        System.out.println();
        if(list.isEmpty()){
            System.out.print(Constant.ILLEGAL_ARGUMENT_EXCEPTION_HEADER);
            System.out.printf(Constant.FIND_EMPTY_LIST + "\n", service);
            return;
        }

        System.out.print(Constant.VIEW_HEADER);
        System.out.println(Constant.LINE_LIST_HEADER);
        for(Line line : list) {
            System.out.println(Constant.RESULT_HEADER + line.getName());
        }
        System.out.println();
    }
}
