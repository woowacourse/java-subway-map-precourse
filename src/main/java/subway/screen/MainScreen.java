package subway.screen;

public class MainScreen implements Screen{
    private static final String MAIN_SCREEN_INFO = "메인 화면";
    private static final String[] MAIN_INFO = {"역 관리","노선 관리","구간 관리","지하철 노선도 출력"};

    @Override
    public void printScreen() {
        System.out.println();
        System.out.println(SHARP + MAIN_SCREEN_INFO);
        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + DOT + MAIN_INFO[i]);
        }
        System.out.println(QUIT);
        System.out.println();
    }
}
