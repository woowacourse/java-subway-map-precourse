package subway.view.outputview;

public class OutputView {
    public static final StringBuilder stringBuilder = new StringBuilder();
    static final String MENU_SYMBOL = "\n## ";
    static final String INFO_SYMBOL = "\n[INFO] ";
    static final String SELECT_MENU = "원하는 기능을 선택하세요.\n";

    static void print() {
        System.out.print(stringBuilder.toString());
        reset();
    }

    private static void reset() {
        stringBuilder.setLength(0);
    }

    public static void selectMenu() {
        stringBuilder.append(MENU_SYMBOL);
        stringBuilder.append(SELECT_MENU);
        print();
    }
}
