package subway.Manager;

import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class SectionManger {
    private static final String SECTION_INSERT = "1";
    private static final String SECTION_DELETE = "2";

    private final Scanner scanner;

    public SectionManger(Scanner scanner) {
        this.scanner = scanner;
    }

    public void execute(String input) {
        if (input.equals(SECTION_INSERT)) {
            InputView.inputSection(scanner);
            OutputView.sectionInsertSuccess();
        }
        if (input.equals(SECTION_DELETE)) {
            InputView.inputDeleteSection(scanner);
            OutputView.sectionDeleteSuccess();
        }
    }
}