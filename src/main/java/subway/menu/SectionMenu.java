package subway.menu;

import subway.controller.ControllerFactory;
import subway.controller.SubwayController;
import subway.exception.MenuNotFountException;
import subway.view.OutputView;

import java.util.Arrays;

public enum SectionMenu implements Menu {

    REGISTER("1", "구간 등록", Action.REGISTER),
    DELETE("2", "구간 삭제", Action.DELETE),
    BACK("B", "돌아가기", Action.BACK);

    final String order;
    final String menu;
    final Action action;

    private static final String MENU_TITLE = "구간 관리 ";
    private static SubwayController controller = ControllerFactory.of(SectionMenu.BACK);
    private static final String MENU_TYPE = "구간";

    SectionMenu(String order, String menu, Action action) {
        this.order = order;
        this.menu = menu;
        this.action = action;
    }

    @Override
    public Menu run() {

        try {
            action.action(this);

            return MainMenu.SECTION;
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
            return MainMenu.SECTION;
        }
    }

    @Override
    public String toString() {
        return order + ". " + menu;
    }

    @Override
    public Menu[] getValues() {
        return values();
    }

    @Override
    public String getTitle() {
        return MENU_TITLE;
    }

    @Override
    public String getType() {
        return MENU_TYPE;
    }

    @Override
    public Action getAction() {
        return action;
    }

    @Override
    public String getOrder() {
        return order;
    }
}
