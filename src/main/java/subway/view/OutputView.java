package subway.view;

import subway.domain.selector.menu.Menu;

public class OutputView {

    public void printScreen(Menu menu) {
        System.out.println("\n## " + menu + " 화면");
        printMenus(menu);
        printItems(menu);
        System.out.println();
    }

    private void printMenus(Menu menu) {
        for (String key : menu.getMenus().keySet()) {
            System.out.println(key + ". " + menu.getMenus().get(key));
        }
    }

    private void printItems(Menu menu) {
        for (String key : menu.getItems().keySet()) {
            System.out.println(key + ". " + menu.getItems().get(key));
        }
    }

}
