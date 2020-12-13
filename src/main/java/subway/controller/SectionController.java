package subway.controller;

import subway.domain.menu.MainMenuType;
import subway.domain.menu.SubMenuType;
import subway.service.SectionService;
import subway.view.InputView;

import java.util.Scanner;

public class SectionController {
    private final Scanner scanner;
    private final SectionService sectionService;

    public SectionController(Scanner scanner) {
        this.scanner = scanner;
        sectionService = new SectionService(scanner);
    }

    public void runSectionMenu(MainMenuType mainMenuType, String category) {
        SubMenuType subMenuType;
        do {
            subMenuType = InputView.inputSectionMenu(scanner, category, mainMenuType);
            selectSectionMenu(subMenuType, category);
        } while (!subMenuType.equals(SubMenuType.BACK));
    }

    private void selectSectionMenu(SubMenuType sectionMenuType, String category) {
        if (SubMenuType.ADD.equals(sectionMenuType)) {
            sectionService.addSection(category);
            return;
        }
        if (SubMenuType.DELETE.equals(sectionMenuType)) {
            sectionService.deleteSection(category);
        }
    }
}
