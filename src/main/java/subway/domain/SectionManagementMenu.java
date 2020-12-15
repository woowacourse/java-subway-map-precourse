package subway.domain;

public class SectionManagementMenu {

    public static void selectSectionManagementFunction(String select) {
        if (select.equals(Constants.FUNCTION_1)) {
            addSection();
            return;
        }
        if (select.equals(Constants.FUNCTION_2)) {
            deleteSection();
            return;
        }
        if (select.equals(Constants.FUNCTION_B)) {
            return;
        }
    }

    private static void addSection() {
        printScreen.printInputAddLine();
        String lineName = User.getInput();
        printScreen.printInputAddStation();
        String name = User.getInput();
        printScreen.printInputOrder();
        String order = User.getInput();
        try {
            LineRepository.addSection(order, lineName, name);
            printScreen.printAlarmAddSection();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteSection() {
        printScreen.printInputDeleteLine();
        String lineName = User.getInput();
        printScreen.printInputDeleteStation();
        String name = User.getInput();

        try {
            LineRepository.deleteSection(lineName, name);
            printScreen.printAlarmDeleteSection();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
