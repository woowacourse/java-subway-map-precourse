package subway.controller;

import subway.domain.menu.MainMenuType;
import subway.domain.menu.SubMenuType;
import subway.service.SectionService;
import subway.view.InputView;

import java.util.Scanner;

public class SectionController implements Controller {
    private final Scanner scanner;
    private final SectionService sectionService;

    public SectionController(Scanner scanner) {
        this.scanner = scanner;
        sectionService = new SectionService(scanner);
    }

    @Override
    public void runMenu(MainMenuType mainMenuType, String category) {
        SubMenuType subMenuType;
        do {
            subMenuType = InputView.inputSectionMenu(scanner, category, mainMenuType);
            selectMenu(subMenuType, category);
        } while (!subMenuType.equals(SubMenuType.BACK));
    }

    @Override
    public void selectMenu(SubMenuType subMenuType, String category) {
        if (SubMenuType.ADD.equals(subMenuType)) {
            sectionService.addSection(category);
            return;
        }
        if (SubMenuType.DELETE.equals(subMenuType)) {
            sectionService.deleteSection(category);
        }
    }
}
