package subway.controller;

import subway.domain.Line;
import subway.domain.Station;
import subway.menus.SectionMenu;
import subway.repository.LineRepository;
import subway.service.SectionService;
import subway.views.sectionviews.SectionInputView;
import subway.views.sectionviews.SectionOutputView;

import java.util.Scanner;

public class SectionMenuController {
    private static SectionMenuController sectionMenuController = new SectionMenuController();
    private SectionService sectionService;

    private SectionMenuController() {
    }

    public static SectionMenuController getInstance() {
        return sectionMenuController;
    }

    public void mappingSectionMenu(Scanner scanner) {
        SectionOutputView.printSectionManagePage();
        sectionService = new SectionService(scanner);
        branchBySelectedOption(SectionInputView.selectSectionMenu(scanner));
    }

    private void branchBySelectedOption(SectionMenu selectedOption) {
        if (selectedOption.equals(SectionMenu.GO_BACK_TO_MAIN_MENU)) {
            System.out.println();
            return;
        }
        if (selectedOption.equals(SectionMenu.SECTION_INSERT)) {
            sectionService.sectionAddService();
        }
        if (selectedOption.equals(SectionMenu.SECTION_DELETE)) {

        }
    }
}
