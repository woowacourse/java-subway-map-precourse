package subway.screen;

public class SectionScreen implements Screen{
    private static final String SECTION_MANAGE_SCREEN_INFO = "구간 관리 화면";
    private static final String[] SECTION_MANAGE_INFO = { "구간 등록", "구간 삭제" };
	
    private static final String INPUT_LINE_NAME = "노선을 입력하세요.";
    private static final String INPUT_STATION_NAME = "역이름을 입력하세요.";
    private static final String INPUT_ORDER = "순서를 입력하세요.";
    private static final String INPUT_DELETE_LINE_NAME = "삭제할 구간의 노선을 입력하세요.";
    private static final String INPUT_DELETE_STATION_NAME = "삭제할 구간의 역을 입력하세요.";

    @Override
    public void printScreen() {
        System.out.println();
        System.out.println(SHARP + SECTION_MANAGE_SCREEN_INFO);
        for (int i = 0; i < 2; i++) {
            System.out.println((i+1) + DOT + SECTION_MANAGE_INFO[i]);
        }
        System.out.println(BACK);
        System.out.println();
    }
    
    public static void askAddSectionLineName() {
    	System.out.println(SHARP + INPUT_LINE_NAME);
    }
    
    public static void askAddSectionStationName() {
    	System.out.println(SHARP + INPUT_STATION_NAME);
    }
    
    public static void askAddSectionOrder() {
    	System.out.println(SHARP + INPUT_ORDER);
    }
    
    public static void askDeleteLineName() {
    	System.out.println(SHARP + INPUT_DELETE_LINE_NAME);
    }
    
    public static void askDeleteStationName() {
    	System.out.println(SHARP + INPUT_DELETE_STATION_NAME);
    }
}
