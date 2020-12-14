package subway.controller;

import subway.menus.SectionMenu;
import subway.views.InputView;
import subway.views.OutputView;

import java.util.Scanner;

public class SectionMenuController {
    private static SectionMenuController sectionMenuController = new SectionMenuController();

    private SectionMenuController() {
    }

    public static SectionMenuController getInstance() {
        return sectionMenuController;
    }

    public void mappingSectionMenu(Scanner scanner) {
        OutputView.printSectionManagePage();
        branchBySelectedOption(InputView.selectSectionMenu(scanner));
    }

    private void branchBySelectedOption(SectionMenu selectedOption) {
        if (selectedOption.equals(SectionMenu.GO_BACK_TO_MAIN_MENU)) {
            System.out.println();
            return;
        }
        if (selectedOption.equals(SectionMenu.SECTION_INSERT)) {

        }
        if (selectedOption.equals(SectionMenu.SECTION_DELETE)) {

        }
    }
}
