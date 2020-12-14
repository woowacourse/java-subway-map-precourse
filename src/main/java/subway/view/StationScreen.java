package subway.view;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationScreen implements Screen {
    private static final int COUNT_STATION_MANAGEMENT_USER_PROMPT = 3;
    private static final String STATION_MANAGEMENT_USER_PROMPT = "\n## 역 관리 화면\n" +
            "1. 역 등록\n" +
            "2. 역 삭제\n" +
            "3. 역 조회\n" +
            "B. 돌아가기\n";
    private static final String PROMPT_STATION_TO_REGISTER = "\n## 등록할 역 이름을 입력하세요.";
    private static final String PROMPT_STATION_TO_DELETE = "\n## 삭제할 역 이름을 입력하세요.";
    private static final String COMPLETE_MESSAGE_REGISTRATION = "지하철 역이 등록되었습니다.";
    private static final String COMPLETE_MESSAGE_DELETION = "지하철 역이 삭제되었습니다.";
    private static final String STATION_LIST = "\n## 역 목록";
    private static final String INFO = "[INFO] ";
    private static final String NEW_LINE = "[INFO] ";

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
        System.out.println(STATION_MANAGEMENT_USER_PROMPT);
        String userInput = InputView.createUserCategorySelection(
                COUNT_STATION_MANAGEMENT_USER_PROMPT);
        return userInput;
    }

    public String showPromptRegisterStation() {
        System.out.println(PROMPT_STATION_TO_REGISTER);
        return InputView.getUserInput();
    }

    public String showPromptDeleteStation() {
        System.out.println(PROMPT_STATION_TO_DELETE);
        return InputView.getUserInput();
    }

    public void printRegistrationCompleted() {
        System.out.println(NEW_LINE + INFO + COMPLETE_MESSAGE_REGISTRATION);
    }

    public void printDeletionCompleted() {
        System.out.println(NEW_LINE + INFO + COMPLETE_MESSAGE_DELETION);
    }

    public void printError(Exception e) {
        System.out.println(e);
    }

    public void printStationsList() {
        System.out.println(STATION_LIST);
        for (Station station : StationRepository.stations()) {
            System.out.println(INFO + station.getName());
        }
    }
}
