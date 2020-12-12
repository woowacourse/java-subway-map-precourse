package subway.view;

import java.util.Arrays;
import java.util.List;
import subway.message.Output;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class SectionView {
    private static final List<String> SECTION_PAGE = Arrays.asList(
            "\n## 구간 관리 화면",
            "1. 구간 등록",
            "2. 구간 삭제",
            "B. 돌아가기",
            "\n## 원하는 기능을 선택하세요.");

    private final Input input;

    public SectionView(final Input input) {
        this.input = input;
    }

    public void selectSectionPage() {
        Output.printPage(SECTION_PAGE);
        selectPage(input.nextSectionButton());
    }

    private void selectPage(final String button) {
        if (isBack(button)) {
            return;
        }
        registerSection(button);
        deleteSection(button);
    }

    private boolean isBack(String button) {
        return button.equals(Button.BACK);
    }

    private void registerSection(String button) {
        if (button.equals(Button.ONE)) {
        }
    }

    private void deleteSection(String button) {
        if (button.equals(Button.TWO)) {
        }
    }
}
