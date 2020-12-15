package subway.domain;

public class LineManagementMenu {

    public static void selectLineManagementFunction(String select) {
        if (select.equals(Constants.FUNCTION_1)) {
            addLine();
            return;
        }
        if (select.equals(Constants.FUNCTION_2)) {
            deleteLine();
            return;
        }
        if (select.equals(Constants.FUNCTION_3)) {
            getLineList();
            return;
        }
        if (select.equals(Constants.FUNCTION_B)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private static void addLine() {
        printScreen.printAddLine();
        String lineName = User.getInput();
        printScreen.printFirstAddLine();
        String firstStation = User.getInput();
        printScreen.printLastAddLine();
        String lastStation = User.getInput();
        try {
            LineRepository.addLine(lineName, firstStation, lastStation);
            printScreen.printAlarmAddLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteLine() {
        printScreen.printDeleteLine();
        String lineName = User.getInput();
        try {
            LineRepository.deleteLineByName(lineName);
            printScreen.printAlarmDeleteLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getLineList() {
        printScreen.printLineList(LineRepository.retrieveLine());
    }
}
