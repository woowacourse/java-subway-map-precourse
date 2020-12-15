package subway.domain;

public class MainMenu {

    public static void executeMain() {
        while (true) {
            try {
                printScreen.printMainScreen();
                String input = User.getInput();
                checkMainSelect(input);
                if (input.equals(Constants.FUNCTION_Q)) {
                    break;
                }
                selectMainFunction(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void selectMainFunction(String select) {
        try {
            if (select.equals(Constants.FUNCTION_1)) {
                printScreen.printStationManagementScreen();
                String input = User.getInput();
                checkManagementSelect(input);
                StationManagementMenu.selectStationManagementFunction(input);
                return;
            }
            if (select.equals(Constants.FUNCTION_2)) {
                printScreen.printLineManagementScreen();
                String input = User.getInput();
                checkManagementSelect(input);
                LineManagementMenu.selectLineManagementFunction(input);
                return;
            }
            if (select.equals(Constants.FUNCTION_3)) {
                printScreen.printSectionManagementScreen();
                String input = User.getInput();
                checkManagementSelect(input);
                SectionManagementMenu.selectSectionManagementFunction(input);
                return;
            }
            if (select.equals(Constants.FUNCTION_4)) {
                printScreen.printAllSubwayLine();
                return;
            }
            if (select.equals(Constants.FUNCTION_Q)) {
                return;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void checkMainSelect(String select) {
        if (select.equals(Constants.FUNCTION_Q) ||
                select.equals(Constants.FUNCTION_1) ||
                select.equals(Constants.FUNCTION_2) ||
                select.equals(Constants.FUNCTION_3) ||
                select.equals(Constants.FUNCTION_4)) {
            return;
        }

        throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.\n");
    }

    private static void checkManagementSelect(String select) {
        if (select.equals(Constants.FUNCTION_B) ||
                select.equals(Constants.FUNCTION_1) ||
                select.equals(Constants.FUNCTION_2) ||
                select.equals(Constants.FUNCTION_3)) {
            return;
        }

        throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.\n");
    }
}
