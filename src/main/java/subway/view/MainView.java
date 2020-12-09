package subway.view;

import subway.enums.MainMenu;

import java.util.Arrays;
import java.util.List;

public class MainView {

    public void printMainMenu() {
        MainMenu[] mainMenu = MainMenu.values();
//        for (MainMenu menu : mainMenu) {
//            System.out.println(menu.valueOf(menu.name()).getTitle());
//        }
        List<MainMenu> menu = Arrays.asList(mainMenu);
        menu.stream().map(MainMenu::getTitle).forEach(System.out::println);
        System.out.println();
        askInputMenu();
    }

    public void askInputMenu() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }
}
