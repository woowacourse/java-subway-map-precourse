package subway.view;

import subway.domain.Station;
import subway.domain.StationRepository;

public class SectionScreen implements Screen {
    private static final int COUNT_SECTION_MANAGEMENT_USER_PROMPT = 2;
    private static final String SECTION_MANAGEMENT_USER_PROMPT = "\n## 구간 관리 화면\n" +
            "1. 구간 등록\n" +
            "2. 구간 삭제\n" +
            "B. 돌아가기\n";
    private static final String INFO = "\n[INFO] ";
    private static final String COMPLETE_MESSAGE_REGISTRATION = "구간이 등록되었습니다.";
    private static final String COMPLETE_MESSAGE_DELETION = "구간이 삭제되었습니다.";
    private static final String PROMPT_REGISTER_SECTION = "\n## 노선을 입력하세요.";
    private static final String PROMPT_DELETE_SECTION = "\n## 삭제할 구간의 노선을 입력하세요.";
    private static final String PROMPT_SELECT_STATION_TO_DELETE = "\n## 삭제할 구간의 역을 입력하세요.";
    private static final String PROMPT_STATION_TO_ADD = "\n## 역이름을 입력하세요.";
    private static final String PROMPT_SECTION_TO_ADD = "\n## 순서를 입력하세요.";

    static SectionScreen instance;

    private SectionScreen() {
    }

    public static SectionScreen getInstance() {
        if (instance == null) {
            instance = new SectionScreen();
        }
        return instance;
    }

    @Override
    public String show() {
        System.out.println(SECTION_MANAGEMENT_USER_PROMPT);
        String userInput = InputView.createUserCategorySelection(
                COUNT_SECTION_MANAGEMENT_USER_PROMPT);
        return userInput;
    }

    public String showPromptRegisterSection() {
        System.out.println(PROMPT_REGISTER_SECTION);
        return InputView.getUserInput();
    }

    public String showPromptDeleteSection() {
        System.out.println(PROMPT_DELETE_SECTION);
        return InputView.getUserInput();
    }

    public Station showPromptStationToDelete() {
        System.out.println(PROMPT_SELECT_STATION_TO_DELETE);
        return StationRepository.findStation(InputView.getUserInput());
    }

    public void printRegistrationCompleted() {
        System.out.println(INFO + COMPLETE_MESSAGE_REGISTRATION);
    }

    public void printDeletionCompleted() {
        System.out.println(INFO + COMPLETE_MESSAGE_DELETION);
    }

    public void printStationToAdd() {
        System.out.println(PROMPT_STATION_TO_ADD);
    }

    public void printSectionToAdd() {
        System.out.println(PROMPT_SECTION_TO_ADD);
    }

    public void printError(String e) {
        System.out.println(e);
    }
}
