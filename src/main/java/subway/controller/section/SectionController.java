package subway.controller.section;

import subway.controller.Controller;
import subway.domain.menu.SectionMenu;
import subway.view.InputView;
import subway.view.outputview.SectionOutputView;

public class SectionController implements Controller {
    @Override
    public void start() {
        SectionMenu sectionMenu;
        do {
            SectionOutputView.showMenu();
            String inputMenu = InputView.input();
            sectionMenu = selectMenu(inputMenu);
        } while (SectionMenu.isRunning(sectionMenu));
    }

    private SectionMenu selectMenu(String inputMenu) {
        return null;
    }
}
