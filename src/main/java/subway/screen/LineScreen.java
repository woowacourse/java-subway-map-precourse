package subway.screen;

public class LineScreen implements Screen{
    private static final String LINE_MANAGE_SCREEN_INFO = "노선 관리 화면";
    private static final String[] LINE_MANAGE_INFO = {"노선 등록", "노선 삭제", "노선 조회"};
    private static final String LINE_LIST_INFO = "노선 목록";
	
    private static final String INPUT_ADD_LINE_NAME = "등록할 노선 이름을 입력하세요.";
    private static final String INPUT_ADD_LINE_UP_TERMINAL_NAME = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_ADD_LINE_DOWN_TERMINAL_NAME = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String INPUT_DELETE_LINE_NAME = "삭제할 노선 이름을 입력하세요.";
	
    @Override
    public void printScreen() {
        System.out.println();
        System.out.println(SHARP + LINE_MANAGE_SCREEN_INFO);
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + DOT + LINE_MANAGE_INFO[i]);
        }
        System.out.println(BACK);
        System.out.println();
    }
    
    public static void printLineListInfoMessage() {
    	System.out.println();
    	System.out.println(SHARP + LINE_LIST_INFO);
    }
    
    public static void askAddLineName() {
        System.out.println(SHARP + INPUT_ADD_LINE_NAME);
    }
    
    public static void askAddLineUpTerminalName() {
        System.out.println(SHARP + INPUT_ADD_LINE_UP_TERMINAL_NAME);
    }
	
    public static void askAddLineDownTerminalName() {
        System.out.println(SHARP + INPUT_ADD_LINE_DOWN_TERMINAL_NAME);
    }

    public static void askDeleteLineName() {
        System.out.println(SHARP + INPUT_DELETE_LINE_NAME);
    }
}
