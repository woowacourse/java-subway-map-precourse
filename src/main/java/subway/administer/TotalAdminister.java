package subway.administer;

import view.io.InputView;
import view.io.OutputView;
import view.MainView;
import view.UserInteractionView;
import view.submenu.LineView;
import view.submenu.StationView;
import view.submenu.PassingRouteView;
import java.util.HashMap;
import java.util.Map;

import enumerated.SubMenuType;
import enumerated.Operation;

public class TotalAdminister {

    private Map<SubMenuType, Object> menuToView = new HashMap<SubMenuType, Object>(
        Map.of(SubMenuType.STATION, new StationView(),
               SubMenuType.LINE, new LineView(),
               SubMenuType.INTERVAL, new PassingRouteView(),
               SubMenuType.GO_TO_MAIN, new MainView())
    );
    SubMenuType menu;
    UserInteractionView curView;
    Operation operation;
    char command;
    InitialConfiguration initialAdminister;

    public TotalAdminister() {
        menu = SubMenuType.GO_TO_MAIN;
        curView = (UserInteractionView) menuToView.get(menu);
        initialAdminister = new InitialConfiguration();
        initialAdminister.initConfigure();
    }

    public void run() {
        while (!menu.isExit()) {
            userInputProcess();
            if (operation.isGoBack()) {
                curView = (UserInteractionView) menuToView.get(SubMenuType.GO_TO_MAIN);
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
        if(menu.isExit()) {
            return;
        }
        if(this.isMenuUpdated()) {
            menu = SubMenuType.fromCommand(command);
        }
    }

    private boolean isMenuUpdated() {
        return (menu.isMain() && !operation.isPrintMap()) || operation.isGoBack();
    }
}
