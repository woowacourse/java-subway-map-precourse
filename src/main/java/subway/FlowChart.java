package subway;

import java.util.Scanner;

public class FlowChart {
    public static void start(Scanner scanner){
        Menu mainPage = new Menu(Constant.MAIN_MENU_TITLE, Constant.mainMenuItemList());

        while (true) {
            String mainInput = mainPage.load(scanner);
            if(mainInput.equals(Constant.mainMenuItemList().get(0).substring(0, 1))){
                loopStationPage(scanner);
            }
            if(mainInput.equals(Constant.mainMenuItemList().get(1).substring(0, 1))){
                loopLinePage(scanner);
            }
            if(mainInput.equals(Constant.mainMenuItemList().get(2).substring(0, 1))){
                loopSectionPage(scanner);
            }
            if(mainInput.equals(Constant.mainMenuItemList().get(3).substring(0, 1))){
                System.out.println("지하철 노선도가 들어갈 자리");
            }
            if(mainInput.equals(Constant.mainMenuItemList().get(4).substring(0, 1))){
                break;
            }
        }
    }

    public static void loopStationPage(Scanner scanner){
        Menu stationPage = new Menu(Constant.STATION_MENU_TITLE, Constant.stationMenuItemList());
        while (true){
            String stationInput = stationPage.load(scanner);
            if(stationInput.equals(Constant.stationMenuItemList().get(0).substring(0, 1))){
                // 역 등록.
            }
            if(stationInput.equals(Constant.stationMenuItemList().get(1).substring(0, 1))){
                // 역 삭제.
            }
            if(stationInput.equals(Constant.stationMenuItemList().get(2).substring(0, 1))){
                // 역 조회.
            }
            if(stationInput.equals(Constant.stationMenuItemList().get(3).substring(0, 1))){
                break;
            }
        }
    }

    public static void loopLinePage(Scanner scanner){
        Menu linePage = new Menu(Constant.LINE_MENU_TITLE, Constant.lineMenuItemList());
        while (true){
            String lineInput = linePage.load(scanner);
            if(lineInput.equals(Constant.lineMenuItemList().get(0).substring(0, 1))){
                // 노선 등록.
            }
            if(lineInput.equals(Constant.lineMenuItemList().get(1).substring(0, 1))){
                // 노선 삭제.
            }
            if(lineInput.equals(Constant.lineMenuItemList().get(2).substring(0, 1))){
                // 노선 조회.
            }
            if(lineInput.equals(Constant.lineMenuItemList().get(3).substring(0, 1))){
                break;
            }
        }
    }

    public static void loopSectionPage(Scanner scanner){
        Menu sectionPage = new Menu(Constant.SECTION_MENU_TITLE, Constant.sectionMenuItemList());
        while (true){
            String sectionInput = sectionPage.load(scanner);
            if(sectionInput.equals(Constant.sectionMenuItemList().get(0).substring(0, 1))){
                // 구간 등록.
            }
            if(sectionInput.equals(Constant.sectionMenuItemList().get(1).substring(0, 1))){
                // 구간 삭제.
            }
            if(sectionInput.equals(Constant.sectionMenuItemList().get(2).substring(0, 1))){
                break;
            }
        }
    }

}
