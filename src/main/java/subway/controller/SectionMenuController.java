package subway.controller;

import subway.menus.SectionMenu;
import subway.service.SectionService;
import subway.views.sectionviews.SectionInputView;
import subway.views.sectionviews.SectionOutputView;

import java.util.Scanner;

public class SectionMenuController implements Controller{
    private static final SectionMenuController sectionMenuController = new SectionMenuController();
    private SectionService sectionService;

    private SectionMenuController() {
    }

    public static SectionMenuController getInstance() {
        return sectionMenuController;
    }

    public void mappingMenu(Scanner scanner) {
        SectionOutputView.printSectionManagePage();
        sectionService = new SectionService(scanner);
        branchBySelectedOption(SectionInputView.selectSectionMenu(scanner));
    }

    private void branchBySelectedOption(SectionMenu selectedOption) {
        if (selectedOption.equals(SectionMenu.GO_BACK_TO_MAIN_MENU)) {
            System.out.println();
            return;
        }
        if (selectedOption.equals(SectionMenu.SECTION_ADD)) {
            sectionService.sectionAddService();
        }
        if (selectedOption.equals(SectionMenu.SECTION_DELETE)) {
            sectionService.sectionDeleteService();
        }
    }
}
