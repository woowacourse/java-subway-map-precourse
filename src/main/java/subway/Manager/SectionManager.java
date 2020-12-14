package subway.Manager;

import subway.Service.SectionService;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class SectionManager {
    private static final String SECTION_INSERT = "1";
    private static final String SECTION_DELETE = "2";

    private static SectionService sectionService;
    private static final Scanner scanner = new Scanner(System.in);

    static {
        sectionService = new SectionService();
    }

    public static void execute(String input) {
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