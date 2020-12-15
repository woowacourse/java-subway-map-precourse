package subway.view;

import static subway.console.Button.BACK;
import static subway.console.Button.ONE;
import static subway.console.Button.TWO;
import static subway.console.Output.print;

import java.util.Arrays;
import java.util.List;
import subway.console.Input;
import subway.console.Output;
import subway.console.Page;
import subway.console.message.InfoMessage;
import subway.console.message.InputMessage;
import subway.controller.SectionController;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class SectionView {
    private static final List<String> SECTION_BUTTONS = Arrays.asList(ONE, TWO, BACK);

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
        Output.printPage(Page.SECTION.getPages());
        return input.nextButton(SECTION_BUTTONS);
    }

    private boolean isCreate(String button) {
        if (button.equals(ONE)) {

            if (createSection()) {
                print(InfoMessage.CREATE_SECTION.getMessage());
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

        return sectionController.insertStation(line, station, order);
    }

    private String inputLine() {
        print(InputMessage.LINE_SECTION.getMessage());
        return input.nextLine();
    }

    private String inputStation() {
        print(InputMessage.STATION_SECTION.getMessage());
        return input.nextLine();
    }

    private String inputOrder() {
        print(InputMessage.ORDER_SECTION.getMessage());
        return input.nextInt();
    }

    private boolean isDelete(String button) {
        if (button.equals(TWO)) {
            if (deleteSection()) {
                print(InfoMessage.DELETE_SECTION.getMessage());
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
        print(InputMessage.DELETE_SECTION.getMessage());
        return input.nextLine();
    }

    private String inputDeleteStation() {
        print(InputMessage.DELETE_ORDER_SECTION.getMessage());
        return input.nextLine();
    }

    private boolean isBack(String button) {
        return button.equals(BACK);
    }
}
