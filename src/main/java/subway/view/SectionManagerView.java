package subway.view;

public class SectionManagerView {

    public static final String SECTION_MAIN_TITLE = "## 구간 관리 화면";
    public static final String SECTION_ENROLLMENT = "1. 구간 등록";
    public static final String SECTION_DELETION = "2. 구간 삭제";
    static final String B_QUIT_OPTION = "B. 종료";

    public static void printSectionManagerMainScreen() {
        System.out.println(SECTION_MAIN_TITLE);
        System.out.println(SECTION_ENROLLMENT);
        System.out.println(SECTION_DELETION);
        System.out.println(B_QUIT_OPTION);
        System.out.println();
    }
}
