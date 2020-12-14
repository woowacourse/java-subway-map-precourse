package subway.view;

import subway.Constants;
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

    @Override
    public String show() {
        System.out.println(Constants.MAIN_SCREEN_USER_PROMPT);
        String userInput = UserInputNumberSelection.createUserSelectionInput(
                Constants.COUNT_MAIN_USER_PROMPT);
        return userInput;
    }

    public void printTransitMap() {
        System.out.println("\n## 지하철 노선도");
        for (Line line : LineRepository.lines()) {
            System.out.println("[INFO] " + line.getName() + "\n[INFO] ---");
            for (Station station : line.getLineStations()) {
                System.out.println("[INFO] " + station.getName());
            }
            System.out.println();
        }
    }
}
