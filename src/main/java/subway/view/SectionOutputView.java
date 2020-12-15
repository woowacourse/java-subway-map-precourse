package subway.view;

public class SectionOutputView {
    private static final String MANAGE_SECTION_SCREEN = "## 구간 관리 화면";
    private static final String REGISTER_SECTION = "1. 구간 등록";
    private static final String REMOVE_SECTION = "2. 구간 삭제";
    private static final String BACK = "B. 돌아가기";

    private SectionOutputView() {
    }

    public static void printManageSectionScreen() {
        System.out.println();
        System.out.println(MANAGE_SECTION_SCREEN);
        System.out.println(REGISTER_SECTION);
        System.out.println(REMOVE_SECTION);
        System.out.println(BACK);
        System.out.println();
    }
}
