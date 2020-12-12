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

        }
        if (select.equals(Constants.FUNCTION_2)) {

        }
        if (select.equals(Constants.FUNCTION_3)) {

        }
        if (select.equals(Constants.FUNCTION_B)) {

        }
        throw new IllegalArgumentException();
    }

    private void addStation(){
        printScreen.printInputStationName();
        StationRepository.addStation(new Station(user.getInput()));
    }

    private void lineManagementFunction() {

    }

    private void sectionManagementFunction() {

    }

    private void printSubwayLineFunction() {

    }
}
