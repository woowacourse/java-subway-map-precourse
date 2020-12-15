package subway.screen;

public class StationScreen implements Screen{
    private static final String STATION_MANAGE_SCREEN_INFO = "역 관리 화면";
    private static final String[] STATION_MANAGE_INFO = {"역 등록","역 삭제","역 조회"};
    private static final String STATION_LIST_INFO = "역 목록";
    
    private static final String INPUT_ADD_STATION_NAME = "등록할 역 이름을 입력하세요.";
    private static final String INPUT_DELETE_STATION_NAME = "삭제할 역 이름을 입력하세요.";
	
    @Override
    public void printScreen() {
        System.out.println();
        System.out.println(SHARP + STATION_MANAGE_SCREEN_INFO);
        for (int i=0;i<3;i++) {
            System.out.println((i+1)+DOT+STATION_MANAGE_INFO[i]);
        }
        System.out.println(BACK);
        System.out.println();
    }
    
    public static void printStationListInfoMessage() {
    	System.out.println();
    	System.out.println(SHARP + STATION_LIST_INFO);
    }
    
    public static void askAddStationName() {
        System.out.println();
        System.out.println(SHARP + INPUT_ADD_STATION_NAME);
    }
	
    public static void askDeleteStationName() {
        System.out.println();
        System.out.println(SHARP + INPUT_DELETE_STATION_NAME);
    }
}
