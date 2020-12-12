package subway.domain.menu.submenu;

import subway.domain.menu.constant.ActionType;
import subway.domain.menu.constant.CommonMessage;

public class StationLineMenu extends SubMenu {
    public StationLineMenu(char order, String category) {
        super(order, category);
    }

    @Override
    public String getTitle() {
        String title = CommonMessage.SHARP + CommonMessage.SHARP + CommonMessage.SPACE + category;
        return title;
    }

    @Override
    public String getTitleActionMessage() {
        String titleActionMessage = order + CommonMessage.PUNCTUATION + CommonMessage.SPACE + category + CommonMessage.SPACE + ActionType.PRINT;

        return titleActionMessage;
    }
}
