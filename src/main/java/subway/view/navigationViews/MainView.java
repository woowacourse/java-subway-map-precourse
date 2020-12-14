package subway.view.navigationViews;

import subway.view.ViewsContainer;
import subway.view.executeViews.exit.ExitView;
import subway.view.executeViews.lineMap.LineMapView;

import java.util.Scanner;

public class MainView extends NavigationViewTemplate {
    private static final String NAV_VIEW_NAME = "메인 화면";

    public MainView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void show() {
        //종료를 선택하지 않는다면 다시 메인화면을 띄워줄 수 있게 한다.
        while (!isExit()){
            super.show();
        }
    }

    @Override
    protected ViewsContainer setViewsContainer() {
        ViewsContainer views = ViewsContainer.newInstance();
        views.add("1", new StationManageView(scanner));
        views.add("2", new LineManageView(scanner));
        views.add("3", new LineStationManageView(scanner));
        views.add("4", new LineMapView());
        views.add("Q", new ExitView());
        return views;
    }

    @Override
    protected String navViewName() {
        return NAV_VIEW_NAME;
    }
}
