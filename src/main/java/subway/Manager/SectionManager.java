package subway.Manager;

import Category.Category;
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

    public static void execute() {
        OutputView.functionView(Category.SECTION.getName(), Category.SECTION.getActionOrder());
        String input = InputView.inputSectionFunction(scanner);

        if (input.equals(SECTION_INSERT)) {
            sectionService.addSectionOnTheLine(InputView.inputSectionInfo(scanner));
            OutputView.sectionInsertSuccess();
        }
        if (input.equals(SECTION_DELETE)) {
            sectionService.deleteSectionOnTheLine(InputView.inputDeleteSectionInfo(scanner));
            OutputView.sectionDeleteSuccess();
        }
    }
}