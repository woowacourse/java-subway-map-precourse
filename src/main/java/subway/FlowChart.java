package subway;

import java.util.Scanner;

public class FlowChart {
    public static void start(Scanner scanner) {
        main(scanner);
    }

    public static void main(Scanner scanner) {
        Menu mainPage = new Menu(Constant.MAIN_MENU_TITLE, Constant.mainMenuItemList());
        String mainInput = mainPage.load(scanner);
        station(scanner, mainInput);
        line(scanner, mainInput);
        section(scanner, mainInput);
        map(scanner, mainInput);
        quit(mainInput);
    }

    public static void station(Scanner scanner, String mainInput) {
        Menu stationPage = new Menu(Constant.STATION_MENU_TITLE, Constant.stationMenuItemList());
        if(mainInput.equals("1")){
            String stationInput = stationPage.load(scanner);
        }
    }

    public static void line(Scanner scanner, String mainInput) {
        Menu linePage = new Menu(Constant.LINE_MENU_TITLE, Constant.lineMenuItemList());
        if(mainInput.equals("2")){
            String lineInput = linePage.load(scanner);
        }
    }

    public static void section(Scanner scanner, String mainInput) {
        Menu sectionPage = new Menu(Constant.SECTION_MENU_TITLE, Constant.sectionMenuItemList());
        if(mainInput.equals("3")){
            String sectionInput = sectionPage.load(scanner);
        }
    }

    public static void map(Scanner scanner, String mainInput) {
        if(mainInput.equals("4")){
            System.out.println("map");
            System.out.println();
            main(scanner);
        }
    }

    public static void quit(String mainInput) {
        if(mainInput.equals("Q")){
            System.exit(0);
        }
    }
}
