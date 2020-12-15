package subway.controller;

import subway.menus.SectionMenu;
import subway.service.sectionservice.SectionAddService;
import subway.service.sectionservice.SectionDeleteService;
import subway.views.sectionviews.SectionInputView;
import subway.views.sectionviews.SectionOutputView;

import java.util.Scanner;

public class SectionMenuController implements Controller{
    private static final SectionMenuController sectionMenuController = new SectionMenuController();

    private SectionMenuController() {
    }

    public static SectionMenuController getInstance() {
        return sectionMenuController;
    }

    public void mappingMenu(Scanner scanner) {
        SectionOutputView.printSectionManagePage();
        branchBySelectedOption(scanner, SectionInputView.selectSectionMenu(scanner));
    }

    private void branchBySelectedOption(Scanner scanner, SectionMenu selectedOption) {
        if (selectedOption.equals(SectionMenu.GO_BACK_TO_MAIN_MENU)) {
            System.out.println();
            return;
        }
        if (selectedOption.equals(SectionMenu.SECTION_ADD)) {
            SectionAddService sectionAddService = SectionAddService.getInstance();
            sectionAddService.sectionAddService(scanner);
        }
        if (selectedOption.equals(SectionMenu.SECTION_DELETE)) {
            SectionDeleteService sectionDeleteService = SectionDeleteService.getInstance();
            sectionDeleteService.sectionDeleteService(scanner);
        }
    }
}
