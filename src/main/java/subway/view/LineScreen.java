package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;

public class LineScreen implements Screen {
    private static final int COUNT_LINE_MANAGEMENT_USER_PROMPT = 3;
    private static final String LINE_MANAGEMENT_USER_PROMPT = "\n## 노선 관리 화면\n" +
            "1. 노선 등록\n" +
            "2. 노선 삭제\n" +
            "3. 노선 조회\n" +
            "B. 돌아가기\n";
    private static final String INFO = "\n[INFO] ";
    private static final String LINE_LIST = "\n## 노선 목록";
    private static final String COMPLETION_MESSAGE_REGISTRATION = "지하철 노선이 등록되었습니다.";
    private static final String COMPLETION_MESSAGE_DELETION = "지하철 노선이 삭제되었습니다.";
    private static final String PROMPT_LINE_TO_DELETE = "\n## 삭제할 노선 이름을 입력하세요.";
    private static final String PROMPT_LINE_TO_REGISTER = "\n## 등록할 노선 이름을 입력하세요.";
    private static final String PROMPT_UPSTREAM_STATION = "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String PROMPT_DOWNSTREAM_STATION = "\n## 등록할 노선의 하행 종점역 이름을 입력하세요.";

    static LineScreen instance;

    private LineScreen() {
    }

    public static LineScreen getInstance() {
        if (instance == null) {
            instance = new LineScreen();
        }
        return instance;
    }

    @Override
    public String show() {
        System.out.println(LINE_MANAGEMENT_USER_PROMPT);
        String userInput = InputView.createUserCategorySelection(
                COUNT_LINE_MANAGEMENT_USER_PROMPT);
        return userInput;
    }

    public String showPromptRegisterLine() {
        System.out.println(PROMPT_LINE_TO_REGISTER);
        return InputView.getUserInput();
    }

    public String showPromptUpstreamStation() {
        System.out.println(PROMPT_UPSTREAM_STATION);
        return InputView.getUserInput();
    }

    public String showPromptDownstreamStation() {
        System.out.println(PROMPT_DOWNSTREAM_STATION);
        return InputView.getUserInput();
    }

    public String showPromptDeleteLine() {
        System.out.println(PROMPT_LINE_TO_DELETE);
        return InputView.getUserInput();
    }

    public void printRegistrationCompleted() {
        System.out.println(INFO + COMPLETION_MESSAGE_REGISTRATION);
    }

    public void printDeletionCompleted() {
        System.out.println(INFO + COMPLETION_MESSAGE_DELETION);
    }

    public void printError(Exception e) {
        System.out.println(e);
    }

    public void printLines() {
        System.out.print(LINE_LIST);
        for (Line line : LineRepository.lines()) {
            System.out.print(INFO + line.getName());
        }
        System.out.println();
    }
}
