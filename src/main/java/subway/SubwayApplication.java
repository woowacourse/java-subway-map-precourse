package subway;

import java.util.Scanner;
import subway.view.Button;
import subway.view.Input;
import subway.view.Message;

/**
 * @author yhh1056
 * @since 2020/12/10
 */
public class SubwayApplication {
    private final Input input;

    public SubwayApplication(Scanner scanner) {
        this.input = new Input(scanner);
    }

    public void run() {
        selectMainMenu(input.nextMainButton());
    }

    private void selectMainMenu(String button) {
        if (isEnd(button)) {
            return;
        }
        selectMenu(button);
        loopMainMenu();
    }

    private boolean isEnd(String button) {
        return button.equals(Button.END);
    }

    private void selectMenu(final String button) {
        selectStationMenu(button);
        selectLineMenu(button);
        selectSectionMenu(button);
        selectSubwayLineMenu(button);
    }

    private void loopMainMenu() {
        Message.printLine();
        selectMainMenu(input.nextMainButton());
    }

    private void selectStationMenu(final String button) {
    }

    private void selectLineMenu(final String button) {
    }

    private void selectSectionMenu(final String button) {
    }

    private void selectSubwayLineMenu(final String button) {
    }
}
