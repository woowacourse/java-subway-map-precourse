package subway;

import java.util.Scanner;

public class FlowChart {
    public static void flowChart(Scanner scanner){
        Menu mainPage = new Menu(Constant.MAIN_MENU_TITLE, Constant.mainMenuItemList());
        Menu stationPage = new Menu(Constant.STATION_LIST_TITLE, Constant.stationMenuItemList());
        Menu linePage = new Menu(Constant.LINE_MENU_TITLE, Constant.lineMenuItemList());
        Menu sectionPage = new Menu(Constant.SECTION_MENU_TITLE, Constant.sectionMenuItemList());

        while (true) {
            String mainInput = mainPage.load(scanner);
            if(mainInput.equals(Constant.mainMenuItemList().get(0).substring(0, 1))){
                stationPage.load(scanner);
            }
            if(mainInput.equals(Constant.mainMenuItemList().get(1).substring(0, 1))){
                linePage.load(scanner);
            }
            if(mainInput.equals(Constant.mainMenuItemList().get(2).substring(0, 1))){
                sectionPage.load(scanner);
            }
            if(mainInput.equals(Constant.mainMenuItemList().get(3).substring(0, 1))){
                System.out.println("지하철 노선도가 들어갈 자리");
            }
            if(mainInput.equals(Constant.mainMenuItemList().get(4).substring(0, 1))){
                break;
            }
        }
    }
}
