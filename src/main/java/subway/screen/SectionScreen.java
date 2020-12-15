package subway.screen;

public class SectionScreen implements Screen{
    private static final String SECTION_MANAGE_SCREEN_INFO = "구간 관리 화면";
    private static final String[] SECTION_MANAGE_INFO = { "구간 등록", "구간 삭제" };

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
}
