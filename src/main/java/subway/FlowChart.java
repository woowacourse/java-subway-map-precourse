package subway;

import java.util.Scanner;

public class FlowChart {
    public static void main(Scanner scanner) {
        Menu mainPage = new Menu(Constant.MAIN_MENU_TITLE, Constant.mainMenuItemList());
        String mainInput = mainPage.load(scanner);
        while (true) {
            try {
                station(scanner, mainInput);
                line(scanner, mainInput);
                section(scanner, mainInput);
                map(scanner, mainInput);
                quit(mainInput);
            } catch (IllegalArgumentException e) {
                System.out.printf(e.getMessage() + "%n%n");
            }
        }
    }

    public static void station(Scanner scanner, String mainInput) {
        Menu stationPage = new Menu(Constant.STATION_MENU_TITLE, Constant.stationMenuItemList());
        if (mainInput.equals(Constant.ONE)) {
            String stationInput = stationPage.load(scanner);
            stationAdd(scanner, stationInput);
            stationDelete(scanner, stationInput);
            stationLookUp(scanner, stationInput);
            back(scanner, stationInput);
        }
    }

    public static void line(Scanner scanner, String mainInput) {
        Menu linePage = new Menu(Constant.LINE_MENU_TITLE, Constant.lineMenuItemList());
        if (mainInput.equals(Constant.TWO)) {
            String lineInput = linePage.load(scanner);
            lineAdd(scanner, lineInput);
            lineDelete(scanner, lineInput);
            lineLookUp(scanner, lineInput);
            back(scanner, lineInput);
        }
    }

    public static void section(Scanner scanner, String mainInput) {
        Menu sectionPage = new Menu(Constant.SECTION_MENU_TITLE, Constant.sectionMenuItemList());
        if (mainInput.equals(Constant.THREE)) {
            String sectionInput = sectionPage.load(scanner);
            sectionAdd(scanner, sectionInput);
            sectionDelete(scanner, sectionInput);
            back(scanner, sectionInput);
        }
    }

    public static void map(Scanner scanner, String mainInput) {
        if (mainInput.equals(Constant.FOUR)) {
            Map.lookUp();
            main(scanner);
        }
    }

    public static void quit(String mainInput) {
        if (mainInput.equals(Constant.Q)) {
            System.exit(0);
        }
    }

    public static void back(Scanner scanner, String input) {
        if (input.equals(Constant.B)) {
            main(scanner);
        }
    }

    public static void stationAdd(Scanner scanner, String stationInput) {
        if (stationInput.equals(Constant.ONE)) {
            StationSetting.add(scanner);
            System.out.println();
            main(scanner);
        }
    }

    public static void stationDelete(Scanner scanner, String stationInput) {
        if (stationInput.equals(Constant.TWO)) {
            StationSetting.delete(scanner);
            System.out.println();
            main(scanner);
        }
    }

    public static void stationLookUp(Scanner scanner, String stationInput) {
        if (stationInput.equals(Constant.THREE)) {
            StationSetting.lookUp();
            System.out.println();
            main(scanner);
        }
    }

    public static void lineAdd(Scanner scanner, String lineInput) {
        if (lineInput.equals(Constant.ONE)) {
            LineSetting.add(scanner);
            System.out.println();
            main(scanner);
        }
    }

    public static void lineDelete(Scanner scanner, String lineInput) {
        if (lineInput.equals(Constant.TWO)) {
            LineSetting.delete(scanner);
            System.out.println();
            main(scanner);
        }
    }

    public static void lineLookUp(Scanner scanner, String lineInput) {
        if (lineInput.equals(Constant.THREE)) {
            LineSetting.lookUp();
            System.out.println();
            main(scanner);
        }
    }

    public static void sectionAdd(Scanner scanner, String sectionInput) {
        if (sectionInput.equals(Constant.ONE)) {
            SectionSetting.add(scanner);
            System.out.println();
            main(scanner);
        }
    }

    public static void sectionDelete(Scanner scanner, String sectionInput) {
        if (sectionInput.equals(Constant.TWO)) {
            SectionSetting.delete(scanner);
            System.out.println();
            main(scanner);
        }
    }
}
