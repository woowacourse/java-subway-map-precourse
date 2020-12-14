package subway.Manager;

import subway.Service.SectionService;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class SectionManager {
    private static final String SECTION_MAIN = "\n## 구간 관리 화면";
    private static final String SECTION_FUNCTION = "1. 구간 등록\n" + "2. 구간 삭제\n" + "B. 돌아가기";
    private static final String SECTION_INSERT = "1";
    private static final String SECTION_DELETE = "2";

    private static SectionService sectionService;
    private static final Scanner scanner = new Scanner(System.in);

    static {
        sectionService = new SectionService();
    }

    public static void execute() {
        OutputView.functionView(SECTION_MAIN, SECTION_FUNCTION );
        String input = InputView.inputSectionFunction(scanner);

        if (input.equals(SECTION_INSERT)) {
            sectionService.addSectionOnTheLine(InputView.inputSection(scanner));
            OutputView.sectionInsertSuccess();
        }
        if (input.equals(SECTION_DELETE)) {
            sectionService.deleteSectionOnTheLine(InputView.inputDeleteSection(scanner));
            OutputView.sectionDeleteSuccess();
        }
    }
}