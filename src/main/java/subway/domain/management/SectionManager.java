package subway.domain.management;

import subway.domain.menu.ManagementMenu;
import subway.domain.menu.ServiceList;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SectionManager extends ServiceManager {

    public SectionManager() {
        super();
    }

    @Override
    public void doStationManagement(Scanner scanner) {
        OutputView.printManagementView(ServiceList.SECTION, menuList);

    }

    @Override
    protected void initMenuList() {
        menuList.add(ManagementMenu.REGISTER);
        menuList.add(ManagementMenu.DELETE);
        menuList.add(ManagementMenu.BACK);
    }
}
