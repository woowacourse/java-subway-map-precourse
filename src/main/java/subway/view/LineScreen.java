package subway.view;

import subway.Constants;
import subway.domain.Line;
import subway.domain.LineRepository;

public class LineScreen implements Screen {
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
        System.out.println(Constants.LINE_MANAGEMENT_USER_PROMPT);
        String userInput = CategorySelection.createUserInput(
                Constants.COUNT_LINE_MANAGEMENT_USER_PROMPT);
        return userInput;
    }
    public String showPromptRegisterLine(){
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
        return CategorySelection.getUserInput();
    }

    public String showPromptUpstreamStation(){
        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        return CategorySelection.getUserInput();
    }

    public String showPromptDownstreamStation(){
        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        return CategorySelection.getUserInput();
    }

    public String showPromptDeleteLine(){
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
        return CategorySelection.getUserInput();
    }

    public void printRegistrationCompleted(){
        System.out.println("\n[INFO] 지하철 노선이 등록되었습니다.");
    }

    public void printDeletionCompleted(){
        System.out.println("\n[INFO] 지하철 노선이 삭제되었습니다.");
    }

    public void printError(Exception e){
        System.out.println(e);
    }

    public void printLines() {
        System.out.println("\n## 노선 목록");
        for (Line line : LineRepository.lines()) {
            System.out.println("[INFO] " + line.getName());
        }
    }
}
