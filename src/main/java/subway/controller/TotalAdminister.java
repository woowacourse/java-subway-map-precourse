package subway.controller;

import View.IoView.OutputView;
import View.MainView;
import View.UserInteractionView;
import View.SubView.LineView;
import View.SubView.StationView;
import View.SubView.PassingRouteView;
import java.util.HashMap;
import java.util.Map;

import Enum.SubMenuType;

public class TotalAdminister {

    private Map<SubMenuType, Object> menuToView = new HashMap<SubMenuType, Object>(
        Map.of(SubMenuType.STATION, new StationView(),
               SubMenuType.LINE, new LineView(),
               SubMenuType.INTERVAL, new PassingRouteView(),
               SubMenuType.MAIN, new MainView())
    );

    public TotalAdminister() {

    }

    public void run() {
        SubMenuType type = SubMenuType.MAIN;
        UserInteractionView curView = (UserInteractionView) menuToView.get(type);

        while(true) {
            OutputView.printManual(curView.getManual());


        }
    }

}
