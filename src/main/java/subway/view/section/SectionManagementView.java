package subway.view.section;

import subway.common.Prefix;

public class SectionManagementView {
    private static final String SECTION_MANAGEMENT_TITLE = Prefix.START.getPrefix() + "구간 관리 화면";
    private static final String ADD_SECTION = "1. 구간 등록";
    private static final String DELETE_SECTION = "2. 구간 삭제";
    private static final String GO_BACK = "B. 돌아가기";

    private static final String COMPLETE_ADD_SECTION = Prefix.INFO.getPrefix() + "구간이 등록되었습니다.";
    private static final String COMPLETE_DELETE_SECTION = Prefix.INFO.getPrefix() + "구간이 삭제되었습니다.";

    private static final String ENTER_DELETE_SECTION_LINE_NAME = Prefix.START.getPrefix() + "삭제할 구간의 노선을 입력하세요.";
    private static final String ENTER_DELETE_SECTION_STATION = Prefix.START.getPrefix() + "삭제할 구간의 역을 입력하세요.";
    private static final String ENTER_REGISTERED_STATION = Prefix.START.getPrefix() + "역이름을 입력하세요.";
    private static final String ENTER_LINE_NAME = Prefix.START.getPrefix() + "노선을 입력하세요.";
    private static final String ENTER_SECTION_NUMBER = Prefix.START.getPrefix() + "순서를 입력하세요.";

    public static void showSectionManagementMenu() {
        System.out.println();
        System.out.println(SECTION_MANAGEMENT_TITLE);
        System.out.println(ADD_SECTION);
        System.out.println(DELETE_SECTION);
        System.out.println(GO_BACK);
        System.out.println();
    }

    public static void askDeleteSectionLineName() {
        System.out.println(ENTER_DELETE_SECTION_LINE_NAME);
    }

    public static void addSectionComplete() {
        System.out.println(COMPLETE_ADD_SECTION);
        System.out.println();
    }

    public static void deleteSectionComplete() {
        System.out.println(COMPLETE_DELETE_SECTION);
        System.out.println();
    }

    public static void askAddSectionLineName() {
        System.out.println(ENTER_LINE_NAME);
    }

    public static void askDeleteSectionStation() {
        System.out.println(ENTER_DELETE_SECTION_STATION);
    }

    public static void askAddStationName() {
        System.out.println(ENTER_REGISTERED_STATION);
    }

    public static void askStationOrder() {
        System.out.println(ENTER_SECTION_NUMBER);
    }
}
