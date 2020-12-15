package subway.controller;

import java.util.LinkedHashMap;
import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;
import subway.domain.selector.menu.Menu;
import subway.domain.selector.menu.MenuRepository;
import subway.domain.selector.utilitem.BackWardItem;
import subway.domain.selector.utilitem.ExitItem;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayManageController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final String MAIN_MENU_ID = "0";
    private String previousMenuId = MAIN_MENU_ID;
    private String currentMenuId = MAIN_MENU_ID;
    private boolean isRun;

    public void run() {
        isRun = true;
        LinkedHashMap<String, Menu> menus = MenuRepository.menus();

        while (isRun) {
            Menu menu = menus.get(currentMenuId);
            outputView.printScreen(menu);

            Selector selector = inputView.getSelector(menu);
            if (isExitItem(selector)
                || isBackWardItem(selector)
                || isSubMenu(selector)) {
                continue;
            }
            executeItem(selector, menu);
            setMenuIdInformation(MAIN_MENU_ID, MAIN_MENU_ID);
        }
    }

    private boolean isExitItem(Selector selector) {
        if (selector instanceof ExitItem) {
            isRun = false;
            return true;
        }
        return false;
    }

    private boolean isBackWardItem(Selector selector) {
        if (selector instanceof BackWardItem) {
            this.currentMenuId = this.previousMenuId;
            return true;
        }
        return false;
    }

    private boolean isSubMenu(Selector selector) {
        if (selector instanceof Manipulable) {
            setMenuIdInformation(MAIN_MENU_ID, MAIN_MENU_ID);
            return false;
        }
        setMenuIdInformation(currentMenuId, selector.getId());
        return true;
    }

    private void setMenuIdInformation(String previousMenuId, String currentMenuId) {
        this.previousMenuId = previousMenuId;
        this.currentMenuId = currentMenuId;
    }

    private void executeItem(Selector selector, Menu menu) {
        try {
            Manipulable item = (Manipulable) selector;
            item.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            outputView.printScreen(menu);
            executeItem(selector, menu);
        }
    }

}
