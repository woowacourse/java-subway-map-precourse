package subway.view;

public class OutputView {
    public static final void printTitle(String title) {
        System.out.println(title);
    }

    public static final void printMenus(String menu) {
        System.out.println(menu);
    }

    public static final void print(String string){
        System.out.println(string);
    }

    public static final void printInvalidCommandExceptionErrorMessage(String command){
        System.out.println(String.format("메뉴에 제시된 기능만 선택할 수 있습니다. (입력 값: %s)", command));
    }
}
