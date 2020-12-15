package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    public final String menuTitle;
    public final List<Action> actionList;

    public Menu(String title, List<Action> actionList) {
        this.menuTitle = title;
        this.actionList = actionList;
    }

    public boolean includeAction(String actionSign) {
        for (int i = 0; i < actionList.size(); i++) {
            if (actionList.get(i).sign.equals(actionSign)) {
                return true;
            }
        }
        return false;
    }
}
