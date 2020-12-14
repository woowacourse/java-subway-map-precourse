package subway.domain;

public class SubwayManagement {

    private User user;
    private static String[] initStation = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private static String[][] initLine = {{"2호선", "교대역", "역삼역"}, {"3호선", "교대역", "매봉역"}, {"신분당선", "강남역", "양재시민의숲역"}};
    private static String[][] initSection = {{"강남역"}, {"남부터미널역", "양재역"}, {"양재역"}};

    public void start() {

        initStats();

        user = new User();

        while (true) {
            printScreen.printMainScreen();
            mainFunction(user.getInput());
        }
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

    private static void initStats() {
        for (String name : initStation) {
            StationRepository.addStation(new Station(name));
        }

        for (int i = 0; i < initLine.length; i++) {
            LineRepository.addLine(initLine[i][0], initLine[i][1], initLine[i][2]);
            String[] sections = initSection[i];
            for (String section : sections) {
                int idx = 2;
                LineRepository.addSection(idx, initLine[i][0], section);
            }
        }
    }
}
