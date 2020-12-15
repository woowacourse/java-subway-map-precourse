package subway.view.output;

public class ScreenView {

    private static final String CHOOSE_FUNCTION = "\n## 원하는 기능을 선택하세요";
    private static final String REGISTER_FUNCTION = "\n## 등록할 %s %s 이름을 입력하세요";
    private static final String REGISTER_FUNCTION_SINGLE = "\n## 등록할 %s 이름을 입력하세요";
    private static final String DELETE_FUNCTION = "\n## 삭제할 %s을 입력하세요";

    public static void chooseFunction() {
        System.out.println(CHOOSE_FUNCTION);
    }

    protected static String registerFunction(String function, String name) {
        return String.format(REGISTER_FUNCTION, function, name);
    }

    protected static String registerFunction(String function) {
        return String.format(REGISTER_FUNCTION_SINGLE, function);
    }

    protected static String deleteFunction(String function) {
        return String.format(DELETE_FUNCTION, function);
    }

}
