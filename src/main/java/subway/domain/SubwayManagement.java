package subway.domain;

public class SubwayManagement {

    private User user;

    public void start() {
        createUserInstance();
        InitSetting.initSetting();

        while (true) {
            printScreen.printMainScreen();
            mainFunction(user.getInput());
        }
    }

    private void createUserInstance() {
        user = new User();
    }

    private void mainFunction(String select) {
        if (select.equals(Constants.FUNCTION_1)) {
            printScreen.printStationManagementScreen();
            stationManagementFunction(user.getInput());
            return;
        }
        if (select.equals(Constants.FUNCTION_2)) {
            printScreen.printLineManagementScreen();
            lineManagementFunction(user.getInput());
            return;
        }
        if (select.equals(Constants.FUNCTION_3)) {
            printScreen.printSectionManagementScreen();
            sectionManagementFunction(user.getInput());
            return;
        }
        if (select.equals(Constants.FUNCTION_4)) {
            printSubwayLine();
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
        printScreen.printAlarmAddStation();
    }

    private void deleteStation() {
        printScreen.printDeleteStation();
        StationRepository.deleteStation(user.getInput());
        printScreen.printAlarmDeleteStation();
    }

    private void getStationList() {
        printScreen.printStationList(StationRepository.retrieveStation());
    }

    private void lineManagementFunction(String select) {
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

    private void addLine() {
        printScreen.printAddLine();
        String lineName = user.getInput();
        printScreen.printFirstAddLine();
        String firstStation = user.getInput();
        printScreen.printLastAddLine();
        String lastStation = user.getInput();
        LineRepository.addLine(lineName, firstStation, lastStation);
        printScreen.printAlarmAddLine();
    }

    private void deleteLine() {
        printScreen.printDeleteLine();
        LineRepository.deleteLineByName(user.getInput());
        printScreen.printAlarmDeleteLine();
    }

    private void getLineList() {
        printScreen.printLineList(LineRepository.retrieveLine());
    }

    private void sectionManagementFunction(String select) {
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

    private void addSection() {
        printScreen.printInputAddLine();
        String line = user.getInput();
        printScreen.printInputAddStation();
        String name = user.getInput();
        printScreen.printInputOrder();
        String order = user.getInput();
        LineRepository.addSection(Integer.parseInt(order), line, name);
        printScreen.printAlarmAddSection();
    }

    private void deleteSection() {
        printScreen.printInputDeleteLine();
        String line = user.getInput();
        printScreen.printInputDeleteStation();
        String name = user.getInput();
        LineRepository.deleteSection(line, name);
        printScreen.printAlarmDeleteSection();
    }

    private void printSubwayLine() {
        printScreen.printAllSubwayLine();
    }


}
