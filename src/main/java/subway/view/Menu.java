package subway.view;

public class Menu {

    public static final String WHAT_MENU = "## 원하는 기능을 선택하세요.";

    private Menu() {
    }

    public static void printMain() {
        for (MainMenuItems item : MainMenuItems.values()) {
            System.out.println(item.getMenuItem());
        }
        System.out.println();
        System.out.println(WHAT_MENU);
    }
}
