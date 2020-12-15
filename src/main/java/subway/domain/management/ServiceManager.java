package subway.domain.management;

import subway.Constant;
import subway.domain.menu.ManagementMenu;
import subway.domain.menu.ServiceList;
import subway.view.InputView;
import subway.view.OutputView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class ServiceManager {
    protected List<ManagementMenu> menuList = new ArrayList<>();
    protected Scanner scanner;

    public ServiceManager(Scanner scanner) {
        initMenuList();
        this.scanner = scanner;
    }

    protected String getInputData(Scanner scanner){
        try{
            OutputView.printAskingFunction(Constant.ASKING_FUNCTION_INPUT_FUNCTION_ORDER);
            return InputView.inputManagementMenu(scanner, menuList);
        } catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            return getInputData(scanner);
        }
    }

    public abstract void doStationManagement();

    protected abstract void initMenuList();
}
