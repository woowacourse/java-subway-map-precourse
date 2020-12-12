package subway.view.navigationViews;

import subway.line.LineController;
import subway.line.LineRepositoryJava;
import subway.station.StationController;
import subway.station.StationRepositoryJava;
import subway.view.ViewsContainer;
import subway.view.exit.ExitView;
import subway.view.lineManage.LineManageView;
import subway.view.lineMap.LineMapView;
import subway.view.lineStationManage.LineStationManageView;
import subway.view.stationManage.StationManageView;

import java.util.Scanner;

public class MainView extends NavigationViewTemplate {
    private static final String NAV_VIEW_NAME = "메인 화면";

    public MainView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void show() {
        super.show();
        if(!(viewStrategy instanceof ExitView)) {
            show();
        }
    }

    @Override
    protected ViewsContainer setViewsContainer() {
        ViewsContainer views = ViewsContainer.newInstance();

        StationController stationController = StationController.get(StationRepositoryJava.get());
        LineController lineController = LineController.get(LineRepositoryJava.get(), StationRepositoryJava.get());

        views.add("1", new StationManageView(scanner, stationController));
        views.add("2", new LineManageView(scanner, lineController));
        views.add("3", new LineStationManageView(scanner, lineController));
        views.add("4", new LineMapView(lineController));
        views.add("Q", new ExitView());
        return views;
    }

    @Override
    protected String navViewName() {
        return NAV_VIEW_NAME;
    }

}
