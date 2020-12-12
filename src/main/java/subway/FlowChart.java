package subway;

import java.util.Scanner;

public class FlowChart {
    public static void start(Scanner scanner) {
        main(scanner);
    }

    public static void main(Scanner scanner) {
        Menu mainPage = new Menu(Constant.MAIN_MENU_TITLE, Constant.mainMenuItemList());
        String mainInput = mainPage.load(scanner);
        station(mainInput);
        line(mainInput);
        section(mainInput);
        map(mainInput);
        quit(mainInput);
    }

    public static void station(String mainInput) {
        Menu stationPage = new Menu(Constant.STATION_MENU_TITLE, Constant.stationMenuItemList());
        if(mainInput.equals("1")){
        }
    }

    public static void line(String mainInput) {
        Menu linePage = new Menu(Constant.LINE_MENU_TITLE, Constant.lineMenuItemList());
        if(mainInput.equals("2")){
        }
    }

    public static void section(String mainInput) {
        Menu sectionPage = new Menu(Constant.SECTION_MENU_TITLE, Constant.sectionMenuItemList());
        if(mainInput.equals("3")){
        }
    }

    public static void map(String mainInput) {
        if(mainInput.equals("4")){
        }
    }

    public static void quit(String mainInput) {
        if(mainInput.equals("Q")){
            System.exit(0);
        }
    }
}
