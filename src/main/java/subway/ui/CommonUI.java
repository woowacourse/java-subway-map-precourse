package subway.ui;

public class CommonUI {
    private final static String BEFORE_SELECT_MENU_VALUE = "## 원하는 기능을 선택하세요.";
    private final static String SUB_MENU_BACK = "B. 돌아가기\n";

    public static void printBeforeSelectMenu() {
        System.out.println(BEFORE_SELECT_MENU_VALUE);
    }
    public static void printSubMenuBack() {
        System.out.println(SUB_MENU_BACK);
    }
}
