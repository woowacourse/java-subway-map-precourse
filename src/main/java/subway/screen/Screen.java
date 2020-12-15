package subway.screen;

public interface Screen {
    public static final String SHARP = "## ";
    public static final String QUIT = "Q. 종료";
    public static final String BACK = "B. 돌아가기";
    public static final String DOT = ". ";
	
    public static final String ASK_CHOOSE_FUNCTION = "원하는 기능을 선택하세요.";
	
    public void printScreen();
	
    public static void chooseFunction() {
        System.out.println(SHARP + ASK_CHOOSE_FUNCTION);
    }
}
