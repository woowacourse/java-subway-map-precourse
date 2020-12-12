package subway.menu;

import subway.Action;
import subway.controller.ControllerFactory;
import subway.controller.SubwayController;
import subway.exception.MenuNotFountException;

import java.util.Arrays;

public enum LineMenu implements Menu {

    REGISTER("1", "노선 등록", Action.REGISTER),
    DELETE("2", "노선 삭제", Action.DELETE),
    SEARCH("3", "노선 조회", Action.SEARCH),
    BACK("B", "돌아가기", Action.BACK);

    final String order;
    final String menu;
    final Action action;

    private static final String title = "노선 관리 ";
    private static SubwayController controller = ControllerFactory.of(LineMenu.BACK);

    LineMenu(String order, String menu, Action action) {
        this.order = order;
        this.menu = menu;
        this.action = action;
    }

    @Override
    public Menu run() {

        try {
            action.action(controller);
            return MainMenu.QUIT;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return LineMenu.BACK;
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
        return title;
    }

    @Override
    public Menu change(String command) {
        return Arrays
                .stream(values())
                .filter(menu -> menu.order.equals(command))
                .findFirst().orElseThrow(() ->
                        new MenuNotFountException(command)
                );
    }
}
