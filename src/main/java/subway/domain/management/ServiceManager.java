package subway.domain.management;

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

    public ServiceManager() {
        initMenuList();
    }

    public abstract void doStationManagement(Scanner scanner);

    protected abstract void initMenuList();
}
