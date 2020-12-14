package subway.controller;

import View.IoView.InputView;
import View.IoView.OutputView;
import View.MainView;
import View.UserInteractionView;
import View.SubMenuView.LineView;
import View.SubMenuView.StationView;
import View.SubMenuView.PassingRouteView;
import java.util.HashMap;
import java.util.Map;

import Enum.SubMenuType;
import Enum.Operation;

public class TotalDirector {

    private Map<SubMenuType, Object> menuToView = new HashMap<SubMenuType, Object>(
        Map.of(SubMenuType.STATION, new StationView(),
               SubMenuType.LINE, new LineView(),
               SubMenuType.INTERVAL, new PassingRouteView(),
               SubMenuType.MAIN, new MainView())
    );
    SubMenuType menu;
    UserInteractionView curView;
    Operation operation;
    char command;
    InitialAdminister initialAdminister;

    public TotalDirector() {
        menu = SubMenuType.MAIN;
        curView = (UserInteractionView) menuToView.get(menu);
        initialAdminister = new InitialAdminister();
        initialAdminister.initConfigure();
    }

    public void run() {
        while (!menu.isExit()) {
            userInputProcess();
            if (operation.isGoBack()) {
                curView = (UserInteractionView) menuToView.get(SubMenuType.MAIN);
                continue;
            }
            curView.execute(operation);
            curView = (UserInteractionView) menuToView.get(menu);
        }
    }

    public void userInputProcess() {
        OutputView.printManual(curView.getManual());
        command = InputView.inputChoice();
        operation = Operation.fromCommand(command);
        if(menu.isMain()) {
            menu = SubMenuType.fromCommand(command);
        }
    }
}
