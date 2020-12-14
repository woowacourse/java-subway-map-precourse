package subway.controller;

import subway.domain.menu.MainMenuType;
import subway.domain.menu.SubMenuType;

public interface Controller {
    void runMenu(MainMenuType mainMenuType, String category);
    void selectMenu(SubMenuType subMenuType, String category);
}
