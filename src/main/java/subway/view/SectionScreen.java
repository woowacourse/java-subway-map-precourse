package subway.view;

import subway.Constants;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SectionScreen implements Screen {
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
        System.out.println(Constants.SECTION_MANAGEMENT_USER_PROMPT);
        String userInput = InputView.createUserCategorySelection(
                Constants.COUNT_SECTION_MANAGEMENT_USER_PROMPT);
        return userInput;
    }

    public String showPromptRegisterSection() {
        System.out.println("\n## 노선을 입력하세요.");
        return InputView.getUserInput();
    }

    public String showPromptDeleteSection() {
        System.out.println("\n## 삭제할 구간의 노선을 입력하세요.");
        return InputView.getUserInput();
    }

    public Station showPromptStationToDelete() {
        System.out.println("\n## 삭제할 구간의 역을 입력하세요.");
        return StationRepository.findStation(InputView.getUserInput());
    }

    public void printRegistrationCompleted() {
        System.out.println("\n[INFO] 구간이 등록되었습니다.");
    }

    public void printDeletionCompleted() {
        System.out.println("\n[INFO] 구간이 삭제되었습니다.");
    }

    public void printStationToAdd() {
        System.out.println("\n## 역이름을 입력하세요.");
    }

    public void printSectionToAdd() {
        System.out.println("\n## 순서를 입력하세요.");
    }

    public void printError(Exception e) {
        System.out.println(e);
    }
}
