package subway.view;

import java.util.Arrays;
import java.util.List;
import subway.message.Output;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class LineView {
    private static final List<String> LINE_PAGE = Arrays.asList(
            "\n## 노선 관리 화면",
            "1. 노선 등록",
            "2. 노선 삭제",
            "3. 노선 조회",
            "B. 돌아가기",
            "\n## 원하는 기능을 선택하세요.");
    private static final List<String> LINE_BUTTONS = Arrays.asList("1", "2", "3", "B");

    private final Input input;

    public LineView(final Input input) {
        this.input = input;
    }

    public void selectLinePage() {
        Output.printPage(LINE_PAGE);
        selectPage(input.nextButton(LINE_BUTTONS));
    }

    private void selectPage(final String button) {
        if (isBack(button)) {
            return;
        }
        registerLine(button);
        deleteLine(button);
        readLine(button);
    }

    private boolean isBack(final String button) {
        return button.equals(Button.BACK);
    }

    private void registerLine(String button) {
        if (button.equals(Button.ONE)) {
        }
    }

    private void deleteLine(String button) {
        if (button.equals(Button.TWO)) {
        }
    }

    private void readLine(String button) {
        if (button.equals(Button.THREE)) {
        }
    }
}
