package subway.domain;

public class SubwayManagement {

    private final User user;
    private final StationRepository stationRepository;

    public SubwayManagement(User user, StationRepository stationRepository) {
        this.user = user;
        this.stationRepository = stationRepository;
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

    }

    private void lineManagementFunction() {

    }

    private void sectionManagementFunction() {

    }

    private void printSubwayLineFunction() {

    }
}
