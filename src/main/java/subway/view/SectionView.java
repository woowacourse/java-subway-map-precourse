package subway.view;

import static subway.console.Output.print;
import static subway.console.Output.printPage;

import java.util.Arrays;
import java.util.List;
import subway.console.Button;
import subway.console.Input;
import subway.console.message.InfoMessage;
import subway.console.message.InputMessage;
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

    private boolean isEndSectionPage(final String button) {
        return !isCreate(button)
            && !isDelete(button)
            && !isBack(button);
    }

    private String inputButton() {
        printPage(SECTION_PAGE);
        return input.nextButton(SECTION_BUTTONS);
    }

    private boolean isCreate(String button) {
        if (button.equals(Button.ONE)) {

            if (createSection()) {
                print(InfoMessage.CREATE_SECTION);
            }
        }
        return false;
    }

    private boolean createSection() {
        String line = inputLine();
        if (sectionController.isNotExistLine(line)) {
            return false;
        }
        String station = inputStation();
        if (sectionController.isNotExistStation(station)) {
            return false;
        }
        String order = inputOrder();

        return sectionController.createSection(line, station, order);
    }

    private String inputLine() {
        print(InputMessage.LINE_SECTION);
        return input.nextLine();
    }

    private String inputStation() {
        print(InputMessage.STATION_SECTION);
        return input.nextLine();
    }

    private String inputOrder() {
        print(InputMessage.ORDER_SECTION);
        return input.nextInt();
    }

    private boolean isDelete(String button) {
        if (button.equals(Button.TWO)) {
            if (deleteSection()) {
                print(InfoMessage.DELETE_SECTION);
            }
        }
        return false;
    }

    private boolean deleteSection() {
        String line = inputDeleteSection();
        if (sectionController.isNotExistLine(line)) {
            return false;
        }

        String station = inputDeleteStation();
        if (sectionController.isNotExistStation(station)) {
            return false;
        }

        return sectionController.deleteSection(line, station);
    }

    private String inputDeleteSection() {
        print(InputMessage.DELETE_SECTION);
        return input.nextLine();
    }

    private String inputDeleteStation() {
        print(InputMessage.DELETE_ORDER_SECTION);
        return input.nextLine();
    }

    private boolean isBack(String button) {
        return button.equals(Button.BACK);
    }
}
