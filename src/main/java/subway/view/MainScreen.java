package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class MainScreen implements Screen {
    private static final int COUNT_MAIN_USER_PROMPT = 4;
    private static final String MAIN_SCREEN_USER_PROMPT = "\n## 메인 화면 \n" +
            "1. 역 관리\n" +
            "2. 노선 관리\n" +
            "3. 구간 관리\n" +
            "4. 지하철 노선도 출력\n" +
            "Q. 종료\n";
    private static final String INFO = "\n[INFO] ";
    private static final String DASH = "---";
    private static final String TRANSIT_MAP = "\n## 지하철 노선도";
    private static final String NEW_LINE = "\n";

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
        System.out.println(MAIN_SCREEN_USER_PROMPT);
        String userInput = InputView.createUserCategorySelection(
                COUNT_MAIN_USER_PROMPT);
        return userInput;
    }

    public void printTransitMap() {
        StringBuilder transitMap = new StringBuilder();
        transitMap.append(TRANSIT_MAP);
        for (Line line : LineRepository.lines()) {
            transitMap.append(INFO + line.getName() + INFO + DASH);
            for (Station station : line.getLineStations()) {
                transitMap.append(INFO + station.getName());
            }
            transitMap.append(NEW_LINE);
        }
        transitMap.setLength(transitMap.length() - 1);
        System.out.println(transitMap.toString());
    }
}
