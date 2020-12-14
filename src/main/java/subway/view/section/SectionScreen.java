package subway.view.section;

import subway.exception.SubwayException;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.TextCollection;

import java.util.Arrays;

public class SectionScreen {

    public static boolean selectMenu() {
        showMenu();
        String input = InputView.inputFunction();
        if (!SectionMenu.isValidInput(input)) {
            throw new SubwayException(TextCollection.WRONG_MENU_INPUT_MESSAGE);
        }
        SectionMenu.findMenuByKey(input).request();
        return true;
    }

    private static void showMenu() {
        OutputView.printQuestion(TextCollection.SECTION_MANAGEMENT_MESSAGE);
        Arrays.stream(SectionMenu.values()).forEach(menu -> {
            System.out.println(menu.getKey() + ". " + menu.getTitle());
        });
    }
}
