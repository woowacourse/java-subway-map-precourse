package subway.domain;

public class SubwayManagement {

    private User user;

    public SubwayManagement(User user) {
        this.user = user;
    }

    public void start() {
        printScreen.printMainScreen();
        mainFunction(user.getInput());
    }

    private void mainFunction(String select) {
        if (select.equals(Constants.FUNCTION_1)) {
            printScreen.printStationManagementScreen();
            stationManagementFunction(user.getInput());
            return;
        }
        if (select.equals(Constants.FUNCTION_2)) {
            return;
        }
        if (select.equals(Constants.FUNCTION_3)) {
            return;
        }
        if (select.equals(Constants.FUNCTION_4)) {
            return;
        }
        if (select.equals(Constants.FUNCTION_Q)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private void stationManagementFunction(String select) {
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

    private void addStation() {
        printScreen.printAddStation();
        StationRepository.addStation(new Station(user.getInput()));
    }

    private void deleteStation() {
        printScreen.printDeleteStation();
        StationRepository.deleteStation(user.getInput());
    }

    private void getStationList() {
        printScreen.printStationList(StationRepository.retrieveStation());
    }

    private void lineManagementFunction() {

    }

    private void sectionManagementFunction() {

    }

    private void printSubwayLineFunction() {

    }
}
