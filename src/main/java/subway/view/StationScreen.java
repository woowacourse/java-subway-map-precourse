package subway.view;

import subway.Constants;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationScreen implements Screen {
    static StationScreen instance;

    private StationScreen() {
    }

    public static StationScreen getInstance() {
        if (instance == null) {
            instance = new StationScreen();
        }
        return instance;
    }

    @Override
    public String show() {
        System.out.println(Constants.STATION_MANAGEMENT_USER_PROMPT);
        String userInput = InputView.createUserCategorySelection(
                Constants.COUNT_STATION_MANAGEMENT_USER_PROMPT);
        return userInput;
    }

    public String showPromptRegisterStation() {
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
        return InputView.getUserInput();
    }

    public String showPromptDeleteStation() {
        System.out.println("\n## 삭제할 역 이름을 입력하세요.");
        return InputView.getUserInput();
    }

    public void printRegistrationCompleted() {
        System.out.println("\n[INFO] 지하철 역이 등록되었습니다.");
    }

    public void printDeletionCompleted() {
        System.out.println("\n[INFO] 지하철 역이 삭제되었습니다.");
    }

    public void printError(Exception e) {
        System.out.println(e);
    }

    public void printStationsList() {
        System.out.println("\n## 역 목록");
        for (Station station : StationRepository.stations()) {
            System.out.println("[INFO] " + station.getName());
        }
    }
}
