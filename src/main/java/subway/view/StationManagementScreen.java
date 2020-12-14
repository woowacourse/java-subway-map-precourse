package subway.view;

import subway.Constants;
import subway.Load;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationManagementScreen implements Screen {
    static StationManagementScreen instance;

    private StationManagementScreen() {
    }

    public static StationManagementScreen getInstance() {
        if (instance == null) {
            instance = new StationManagementScreen();
        }
        return instance;
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

    @Override
    public void start() {
        System.out.println(Constants.STATION_MANAGEMENT_USER_PROMPT);
        int userInput = UserInputNumberSelection.createUserSelectionInput(
                Constants.COUNT_STATION_MANAGEMENT_USER_PROMPT, Constants.BACK);
        if (userInput == Constants.USER_ANSWER_REGISTER) {
            registerNewStation();
        }
        if (userInput == Constants.USER_ANSWER_DELETE) {
            deleteStation();
        }
        if (userInput == Constants.USER_ANSWER_SHOW) {
            printStations();
        }
        Load.loadMainScreen();
        return;
    }
}
