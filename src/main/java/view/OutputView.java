package view;

public class OutputView {
    private static final String MAIN_MENU_TITLE ="## 메인 화면";
    public static void printMainMenu(String value) {
        print(MAIN_MENU_TITLE);
        print(value);
    }

    private static void print(String value) {
        System.out.println(value);
    }
}
