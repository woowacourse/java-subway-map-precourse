package subway.domain.menu.submenu;

import java.util.Scanner;

import subway.domain.menu.constant.ActionType;
import subway.domain.menu.constant.CommonMessage;

public class StationLineMenu extends SubMenu {
    public StationLineMenu(char order, String category, Scanner scanner) {
        super(order, category, scanner);
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

    @Override
    public void printSubMenu() {
        System.out.println(CommonMessage.INFO + CommonMessage.SPACE);
    }
}
