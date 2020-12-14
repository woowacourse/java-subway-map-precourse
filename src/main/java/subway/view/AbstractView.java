package subway.view;

import java.util.Map;
import java.util.Scanner;
import subway.Subway;
import subway.model.MenuGroup.Menu;
import subway.util.Constants;
import subway.util.MessageUtils;

public abstract class AbstractView {

    private boolean isRunning = true;

    protected final Scanner scanner;
    protected final Subway subway;

    public AbstractView(Subway subway, Scanner scanner) {
        this.scanner = scanner;
        this.subway = subway;

        initView();
    }

    public abstract void initView();

    public abstract Menu getMenu();

    public abstract Map<String, Runnable> getMenuActionMap();

    public void start() {
        isRunning = true;
        while (isRunning) {
            menuSelector();
        }
    }

    private void menuSelector() {
        MessageUtils.printMenu(getMenu());
        String input = scanner.next().toUpperCase();
        MessageUtils.printBlankLine();

        Runnable action = getMenuActionMap().get(input);
        if (action == null) {
            MessageUtils.printError(Constants.INVALID_ASK);
            return;
        }
        action.run();
    }

    public void goBackward() {
        isRunning = false;
    }
}
