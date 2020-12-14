package subway.view;

import static subway.console.Output.print;
import static subway.console.Output.printPage;

import java.util.Arrays;
import java.util.List;
import subway.console.Button;
import subway.console.Input;
import subway.console.Message;
import subway.controller.SectionController;

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
    private static final List<String> SECTION_BUTTONS = Arrays.asList("1", "2", "B");

    private final Input input;
    private final SectionController sectionController;

    public SectionView(final Input input) {
        this.input = input;
        this.sectionController = new SectionController();
    }

    public void selectSectionPage() {
        String button = inputButton();
        while (isEndSectionPage(button)) {
            button = inputButton();
        }
    }

    private String inputButton() {
        printPage(SECTION_PAGE);
        return input.nextButton(SECTION_BUTTONS);
    }

    private boolean isEndSectionPage(final String button) {
        return !isCreate(button)
                && !isDelete(button)
                && !isBack(button);
    }

    private boolean isCreate(String button) {
        if (button.equals(Button.ONE)) {

            print(Message.INPUT_CREATE_SECTION);
            if (createSection(input.nextLine())) {
                print(Message.INFO_CREATE_SECTION);
                return true;
            }
        }
        return false;
    }

    private boolean createSection(String line) {
        if (!sectionController.existLine(line)) {
            return false;
        }

        print(Message.INPUT_STATION_SECTION);
        String station = input.nextLine();

        print(Message.INPUT_ORDER_SECTION);
        String order = input.nextLine();

        return sectionController.createSection(line, station, order);
    }


    private boolean isDelete(String button) {
        if (button.equals(Button.TWO)) {
            print(Message.INPUT_DELETE_SECTION);
            if (deleteSection(input.nextLine())) {
                print(Message.INFO_DELETE_SECTION);
                return true;
            }
        }
        return false;
    }

    private boolean deleteSection(String line) {
        if (!sectionController.existLine(line)) {
            return false;
        }

        print(Message.INPUT_DELETE_ORDER_SECTION);
        String station = input.nextLine();

        return sectionController.deleteSection(line, station);
    }

    private boolean isBack(String button) {
        return button.equals(Button.BACK);
    }
}
