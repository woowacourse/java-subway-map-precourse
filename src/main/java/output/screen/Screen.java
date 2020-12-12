package output.screen;

import input.Input;

public interface Screen {
    public final static String HEAD = "## ";
    public final static String SPACE = " ";
    public final static String POINT = ".";
    public final static String ENTER = "\n";
    public final static String MANAGEMENT = "관리";
    public final static String SELECT_FUNCTION = "원하는 기능을 선택하세요.";

    void visualize();
    void logic(Input input);
}
