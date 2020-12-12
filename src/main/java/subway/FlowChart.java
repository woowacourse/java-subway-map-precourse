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
            stationAdd(scanner, stationInput);
            stationDelete(scanner, stationInput);
            stationLookUp(scanner, stationInput);
            back(scanner, stationInput);
        }
    }

    public static void line(Scanner scanner, String mainInput) {
        Menu linePage = new Menu(Constant.LINE_MENU_TITLE, Constant.lineMenuItemList());
        if(mainInput.equals("2")){
            String lineInput = linePage.load(scanner);
            lineAdd(scanner, lineInput);
            lineDelete(scanner, lineInput);
            lineLookUp(scanner, lineInput);
            back(scanner, lineInput);
        }
    }

    public static void section(Scanner scanner, String mainInput) {
        Menu sectionPage = new Menu(Constant.SECTION_MENU_TITLE, Constant.sectionMenuItemList());
        if(mainInput.equals("3")){
            String sectionInput = sectionPage.load(scanner);
            sectionAdd(scanner, sectionInput);
            sectionDelete(scanner, sectionInput);
            back(scanner, sectionInput);
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

    public static void back(Scanner scanner, String input) {
        if(input.equals("B")){
            main(scanner);
        }
    }

    public static void stationAdd(Scanner scanner, String stationInput) {
        if(stationInput.equals("1")){
            System.out.println("stationAdd");
            System.out.println();
            main(scanner);
        }
    }

    public static void stationDelete(Scanner scanner, String stationInput) {
        if(stationInput.equals("2")){
            System.out.println("stationDelete");
            System.out.println();
            main(scanner);
        }
    }

    public static void stationLookUp(Scanner scanner, String stationInput) {
        if(stationInput.equals("3")){
            System.out.println("stationLookUp");
            System.out.println();
            main(scanner);
        }
    }

    public static void lineAdd(Scanner scanner, String lineInput) {
        if(lineInput.equals("1")){
            System.out.println("lineAdd");
            System.out.println();
            main(scanner);
        }
    }

    public static void lineDelete(Scanner scanner, String lineInput) {
        if(lineInput.equals("2")){
            System.out.println("lineDelete");
            System.out.println();
            main(scanner);
        }
    }

    public static void lineLookUp(Scanner scanner, String lineInput) {
        if(lineInput.equals("3")){
            System.out.println("lineLookUp");
            System.out.println();
            main(scanner);
        }
    }

    public static void sectionAdd(Scanner scanner, String sectionInput) {
        if(sectionInput.equals("1")){
            System.out.println("sectionAdd");
            System.out.println();
            main(scanner);
        }
    }

    public static void sectionDelete(Scanner scanner, String sectionInput) {
        if(sectionInput.equals("2")){
            System.out.println("sectionDelete");
            System.out.println();
            main(scanner);
        }
    }
}
