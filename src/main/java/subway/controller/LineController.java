package subway.controller;

import subway.Constants;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.LineManagementScreen;
import subway.view.Screen;
import subway.view.UserInputNumberSelection;

public class LineController implements Controller {
    static LineController instance;
    Screen screen;

    public LineController() {
        screen = LineManagementScreen.getInstance();
    }

    public static LineController getInstance() {
        if (instance == null) {
            instance = new LineController();
        }
        return instance;
    }

    @Override
    public void action() {
        String userInput = screen.show();
        if (userInput.equals(Constants.USER_ANSWER_REGISTER)) {
            registerNewLine();
        }
        if (userInput.equals(Constants.USER_ANSWER_DELETE)) {
            deleteLine();
        }
        if (userInput.equals(Constants.USER_ANSWER_SHOW)) {
            printLines();
        }
        MainController.getInstance().action();
    }

    private void deleteLine() {
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
        try {
            LineRepository.deleteLineByName(UserInputNumberSelection.getUserInput());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            return;
        }
        System.out.println("\n[INFO] 지하철 노선이 삭제되었습니다.");
    }

    private void registerNewLine() {
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
        try {
            Line line = new Line(UserInputNumberSelection.getUserInput());
            initiateLinetations(line);
            LineRepository.addLine(line);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            registerNewLine();
            return;
        }
        System.out.println("\n[INFO] 지하철 노선이 등록되었습니다.");
    }

    private void initiateLinetations(Line line) {
        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        Station firstStation = StationRepository.findStation(UserInputNumberSelection.getUserInput());

        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        Station secondStation = StationRepository.findStation(UserInputNumberSelection.getUserInput());

        line.initiateLineStations(firstStation, secondStation);
    }

    private void printLines() {
        System.out.println("\n## 노선 목록");
        for (Line line : LineRepository.lines()) {
            System.out.println("[INFO] " + line.getName());
        }
    }
}
