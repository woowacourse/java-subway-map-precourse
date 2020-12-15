package subway.domain;

public class StationManagementMenu {

    public static void selectStationManagementFunction(String select) {
        if (select.equals(Constants.FUNCTION_1)) {
            addStation();
            return;
        }
        if (select.equals(Constants.FUNCTION_2)) {
            deleteStation();
            return;
        }
        if (select.equals(Constants.FUNCTION_3)) {
            getStationList();
            return;
        }
        if (select.equals(Constants.FUNCTION_B)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private static void addStation() {
        printScreen.printAddStation();
        try {
            StationRepository.addStation(User.getInput());
            printScreen.printAlarmAddStation();
        } catch (IllegalArgumentException e) {
            printScreen.printErrorAddStation();
        }
    }

    private static void deleteStation() {
        printScreen.printDeleteStation();
        try {
            StationRepository.deleteStation(User.getInput());
            printScreen.printAlarmDeleteStation();
        } catch (IllegalArgumentException e) {
            printScreen.printErrorDeleteStation();
        }
    }

    private static void getStationList() {
        printScreen.printStationList(StationRepository.retrieveStation());
    }
}
