package subway.view;

public interface Screen {
    public static final String DOUBLE_SHARP = "## ";
    public static final String SELECT_FUNCTION = "원하는 기능을 선택하세요.";
    public static final String INFORMATION_MARK = "[INFO] ";
    public static final String ERROR_MARK = "[ERROR] ";
    public static final String SEPARATER = "---";
    public static final String SPACE = " ";
    public static final String EXIT_MARK = "Q. ";
    public static final String BACK_MARK = "B. ";
    public static final String DOT = ". ";
    public static final String CHANGE_LINE = "\n";

    void show(); //화면을 출력하는 함수
    void getCommand(); //사용자의 커맨드를 받는 함수
    int getMaxMenuNumber();
    String getSpecialCommand();
    int parseSpecialCommandtoInt();
}
