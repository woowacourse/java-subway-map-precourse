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

    public List<String> getActionSigns() {
        List<String> signs = new ArrayList<String>();
        for (int i = 0; i < actionList.size(); i++) {
            String actionSign = actionList.get(i).sign;
            signs.add(actionSign);
        }
        return signs;
    }
}
