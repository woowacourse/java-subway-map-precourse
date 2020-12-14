package subway.view;

import subway.utils.ErrorUtils;
import subway.utils.InputValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * 이 클래스는 메뉴 선택용 뷰입니다.
 * 모든 메뉴 선택 뷰는 이 클래스를 상속받아 사용합니다.
 * 예 ) 메인 화면, 역 관리 화면, 노선 관리 화면 등등
 */
public abstract class SelectionView extends AbstractView {

    protected static final String MENU_TEXT_SUFFIX = " 화면";
    protected static final String DOT = ". ";
    protected static final String INPUT_MESSAGE = "## 원하는 기능을 선택하세요.";
    protected static final String GO_BACK_TEXT = "B. 돌아가기";
    protected static final String EXIT_TEXT = "Q. 종료";
    protected static final int GO_BACK_CODE = 0;

    protected List<View> visitableViews;
    protected String goBackText;

    public SelectionView() {
        super();
        this.visitableViews = new ArrayList<>();
        this.goBackText = GO_BACK_TEXT;
    }

    public void add(View view) {
        this.visitableViews.add(view);
    }

    @Override
    public void setVisible() {
        while (true) {
            try {
                printMenu();
                int input = inputMenuOption();
                if (input == GO_BACK_CODE) {
                    return;
                }
                visitView(input);
                return;
            } catch (Exception e) {
            }
        }
    }

    protected void printMenu() {
        println(VIEW_TEXT_PREFIX + getName() + MENU_TEXT_SUFFIX);
        printMenuOptions();
    }

    private void printMenuOptions() {
        int cnt = 1;
        for (View view : visitableViews) {
            println((cnt++) + DOT + view.getName());
        }
        println(this.goBackText);
        println();
    }

    protected int inputMenuOption() {
        int numOfMenu = this.visitableViews.size();
        return (int) ErrorUtils.repeatInputUntilNoException(() -> {
            println(INPUT_MESSAGE);
            String input = scanner.nextLine();
            if (isGoBack(input)) {
                return GO_BACK_CODE;
            }
            InputValidator.validateMenuInput(input, numOfMenu);
            return Integer.parseInt(input);
        });
    }

    private boolean isGoBack(String input) {
        if (input.equals(parseFirstWord(goBackText))) {
            return true;
        }
        return false;
    }

    private String parseFirstWord(String input) {
        return input.substring(0, 1);
    }

    protected void visitView(int input) {
        int visitIdx = input - 1;
        this.visitableViews.get(visitIdx).setVisible();
    }
}
