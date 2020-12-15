package subway.domain;

public class SubwayManagement {

    private User user;

    public void start() {
        createUserInstance();
        InitSetting.initSetting();

        executeMain();
    }


    private void executeMain() {
        while (true) {
            try {
                printScreen.printMainScreen();
                String input = user.getInput();
                checkMainSelect(input);
                if (input.equals(Constants.FUNCTION_Q)) {
                    break;
                }
                selectMainFunction(input);
            } catch (IllegalArgumentException e) {
                printScreen.printErrorMainSelect();
            }
        }
    }

    private void checkMainSelect(String select) {
        if (select.equals(Constants.FUNCTION_Q) ||
                select.equals(Constants.FUNCTION_1) ||
                select.equals(Constants.FUNCTION_2) ||
                select.equals(Constants.FUNCTION_3) ||
                select.equals(Constants.FUNCTION_4)) {
            return;
        }

        throw new IllegalArgumentException();
    }

    private void checkManagementSelect(String select) {
        if (select.equals(Constants.FUNCTION_B) ||
                select.equals(Constants.FUNCTION_1) ||
                select.equals(Constants.FUNCTION_2) ||
                select.equals(Constants.FUNCTION_3)) {
            return;
        }

        throw new IllegalArgumentException();
    }

    private void createUserInstance() {
        user = new User();
    }

    private void selectMainFunction(String select) {
        try {
            if (select.equals(Constants.FUNCTION_1)) {
                printScreen.printStationManagementScreen();
                String input = user.getInput();
                checkManagementSelect(input);
                selectStationManagementFunction(input);
                return;
            }
            if (select.equals(Constants.FUNCTION_2)) {
                printScreen.printLineManagementScreen();
                String input = user.getInput();
                checkManagementSelect(input);
                selectLineManagementFunction(input);
                return;
            }
            if (select.equals(Constants.FUNCTION_3)) {
                printScreen.printSectionManagementScreen();
                String input = user.getInput();
                checkManagementSelect(input);
                selectSectionManagementFunction(input);
                return;
            }
            if (select.equals(Constants.FUNCTION_4)) {
                printSubwayLine();
                return;
            }
            if (select.equals(Constants.FUNCTION_Q)) {
                return;
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private void selectStationManagementFunction(String select) {
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
        try {
            StationRepository.addStation(user.getInput());
            printScreen.printAlarmAddStation();
        } catch (IllegalArgumentException e) {
            printScreen.printErrorAddStation();
        }
    }

    private void deleteStation() {
        printScreen.printDeleteStation();
        try {
            StationRepository.deleteStation(user.getInput());
            printScreen.printAlarmDeleteStation();
        } catch (IllegalArgumentException e) {
            printScreen.printErrorDeleteStation();
        }
    }

    private void getStationList() {
        printScreen.printStationList(StationRepository.retrieveStation());
    }

    private void selectLineManagementFunction(String select) {
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
        try {
            LineRepository.addLine(lineName, firstStation, lastStation);
            printScreen.printAlarmAddLine();
        } catch (IllegalArgumentException e) {
            printScreen.printErrorAddLine();
        }
    }

    private void deleteLine() {
        printScreen.printDeleteLine();
        String lineName = user.getInput();
        try {
            LineRepository.deleteLineByName(lineName);
            printScreen.printAlarmDeleteLine();
        } catch (IllegalArgumentException e) {
            printScreen.printErrorDeleteLine();
        }
    }

    private void getLineList() {
        printScreen.printLineList(LineRepository.retrieveLine());
    }

    private void selectSectionManagementFunction(String select) {
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
        String lineName = user.getInput();
        printScreen.printInputAddStation();
        String name = user.getInput();
        printScreen.printInputOrder();
        String order = user.getInput();
        try {
            LineRepository.addSection(order, lineName, name);
            printScreen.printAlarmAddSection();
        } catch (IllegalArgumentException e) {
            printScreen.printErrorAddSection();
        }
    }

    private void deleteSection() {
        printScreen.printInputDeleteLine();
        String lineName = user.getInput();
        printScreen.printInputDeleteStation();
        String name = user.getInput();

        try {
            LineRepository.deleteSection(lineName, name);
            printScreen.printAlarmDeleteSection();
        } catch (IllegalArgumentException e) {
            printScreen.printErrorDeleteSection();
        }
    }

    private void printSubwayLine() {
        printScreen.printAllSubwayLine();
    }
}
