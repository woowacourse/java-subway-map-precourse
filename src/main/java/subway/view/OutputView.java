package subway.view;

import subway.Constant;
import subway.domain.menu.MainMenu;
import subway.domain.menu.ManagementMenu;
import subway.domain.menu.DataList;

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

    public static void printManagementView(DataList data){
        System.out.print(Constant.VIEW_HEADER);
        System.out.printf(Constant.MANAGEMENT_VIEW_HEADER_FORMAT, data.getName());
        for(ManagementMenu managementMenu : ManagementMenu.values()) {
            if(data == DataList.SECTION && managementMenu == ManagementMenu.FIND ){          /*구간 관리 화면에는 조회 없음*/
                continue;
            }

            System.out.printf(Constant.MANAGEMENT_VIEW_BODY_FORMAT, managementMenu.getOrder()
                    , data.getName(), managementMenu.getMessage());
        }

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
