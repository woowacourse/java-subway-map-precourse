package subway.controller;

import subway.Constants;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.Screen;
import subway.view.StationManagementScreen;
import subway.view.UserInputNumberSelection;

public class StationController implements Controller {
    static StationController instance;
    Screen screen;

    public StationController() {
        screen = StationManagementScreen.getInstance();
    }

    public static StationController getInstance() {
        if (instance == null) {
            instance = new StationController();
        }
        return instance;
    }

    @Override
    public void action() {
        String userInput = screen.show();
        if (userInput.equals(Constants.USER_ANSWER_REGISTER)) {
            registerNewStation();
        }
        if (userInput.equals(Constants.USER_ANSWER_DELETE)) {
            deleteStation();
        }
        if (userInput.equals(Constants.USER_ANSWER_SHOW)) {
            printStations();
        }
        MainController.getInstance().action();
    }

    private void registerNewStation() {
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
        try {
            StationRepository.addStation(new Station(UserInputNumberSelection.getUserInput()));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            registerNewStation();
            return;
        }
    }

    private void deleteStation() {
        System.out.println("\n## 삭제할 역 이름을 입력하세요.");
        try {
            StationRepository.deleteStation(UserInputNumberSelection.getUserInput());
        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERROR] 잘못된 입력입니다.");
            return;
        }
        System.out.println("\n[INFO] 지하철 역이 삭제되었습니다.");
    }

    private void printStations() {
        System.out.println("\n## 역 목록");
        for (Station station : StationRepository.stations()) {
            System.out.println("[INFO] " + station.getName());
        }
    }
}

