package subway.view;

import subway.Constants;
import subway.Load;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class MainScreen implements Screen {
    static MainScreen instance;

    private MainScreen() {
    }

    public static MainScreen getInstance() {
        if (instance == null) {
            instance = new MainScreen();
        }
        return instance;
    }

    private void printTransitMap() {
        System.out.println("\n## 지하철 노선도");
        for (Line line : LineRepository.lines()) {
            System.out.println("[INFO] " + line.getName() + "\n[INFO] ---");
            for (Station station : line.getLineStations()) {
                System.out.println("[INFO] " + station.getName());
            }
            System.out.println();
        }
    }

    @Override
    public void start() {
        System.out.println(Constants.MAIN_SCREEN_USER_PROMPT);
        int userInput = UserInputNumberSelection.createUserSelectionInput(
                Constants.COUNT_MAIN_USER_PROMPT, Constants.QUIT);
        if (userInput == Constants.USER_ANSWER_STATION_MANAGEMENT_SCREEN) {
            Load.loadStationManagementScreen();
        }
        if (userInput == Constants.USER_ANSWER_LINE_MANAGEMENT_SCREEN) {
            Load.loadLineManagementScreen();
        }
        if (userInput == Constants.USER_ANSWER_SECTION_MANAGEMENT_SCREEN) {
            Load.loadSectionManagementScreen();
        }
        if (userInput == Constants.USER_ANSWER_PRINT_TRANSIT_MAP) {
            printTransitMap();
            start();
        }
        return;
    }
}
