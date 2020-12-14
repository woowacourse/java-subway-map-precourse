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
        String userInput = InputView.createUserCategorySelection(
                Constants.COUNT_MAIN_USER_PROMPT);
        return userInput;
    }

    public void printTransitMap() {
        StringBuilder transitMap = new StringBuilder();
        transitMap.append("\n## 지하철 노선도");
        for (Line line : LineRepository.lines()) {
            transitMap.append("\n[INFO] " + line.getName() + "\n[INFO] ---");
            for (Station station : line.getLineStations()) {
                transitMap.append("\n[INFO] " + station.getName());
            }
            transitMap.append("\n");
        }
        transitMap.setLength(transitMap.length() - 1);
        System.out.println(transitMap.toString());
    }
}
