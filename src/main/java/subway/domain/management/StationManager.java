package subway.domain.management;

import subway.domain.menu.ManagementMenu;
import subway.domain.menu.ServiceList;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class StationManager extends ServiceManager {

    public StationManager() {
        super();
    }

    @Override
    public void doStationManagement(Scanner scanner) {
        OutputView.printManagementView(ServiceList.STATION, menuList);
        try{
            String inputData = InputView.inputManagementMenu(scanner, menuList);
        } catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            doStationManagement(scanner);
        }
    }

    @Override
    protected void initMenuList() {
        menuList.add(ManagementMenu.REGISTER);
        menuList.add(ManagementMenu.DELETE);
        menuList.add(ManagementMenu.FIND);
        menuList.add(ManagementMenu.BACK);
    }
}
