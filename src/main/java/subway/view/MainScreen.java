package subway.view;

import java.util.Arrays;
import java.util.List;

public class MainScreen implements Screen {
    private static final String TITLE = "메인 화면";

    private static final List<Element> MAIN_MENU_ELEMENT = Arrays.asList(
            Element.STATION, Element.LINE, Element.PATH, Element.MAP
    );

    private static final List<Action> MAIN_MENU_ACTION = Arrays.asList(
            Action.MANAGE, Action.MANAGE, Action.MANAGE, Action.PRINT, Action.EXIT
    );

    @Override
    public void show() {
        OutputView.printTitle(DOUBLE_SHARP + TITLE);
        int i;
        for (i = 0; i < MAIN_MENU_ELEMENT.size(); i++) {
            OutputView.printMenus(Integer.toString(i + 1) + DOT + MAIN_MENU_ELEMENT.get(i).toString() + SPACE + MAIN_MENU_ACTION.get(i).toString());
        }
        OutputView.printMenus(EXIT_MARK + MAIN_MENU_ACTION.get(i).toString());
    }
}
