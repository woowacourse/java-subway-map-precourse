package subway.view.linesectionoutput;

import subway.view.InfoView;

public class LineSectionInfoView extends InfoView {
    private static final String LINE_SECTION_REGISTER_INFO = "구간이 등록되었습니다.";
    private static final String LINE_SECTION_DELETE_INFO = "구간이 삭제되었습니다.";

    public static void printRegisterInfo() {
        printInfo(LINE_SECTION_REGISTER_INFO);
    }

    public static void printDeleteInfo() {
        printInfo(LINE_SECTION_DELETE_INFO);
    }
}
