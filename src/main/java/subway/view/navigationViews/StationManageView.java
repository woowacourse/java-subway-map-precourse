package subway.view.navigationViews;

import subway.station.StationController;
import subway.station.StationRepositoryJava;
import subway.view.executeViews.BackView;
import subway.view.ViewStrategy;
import subway.view.ViewsContainer;
import subway.view.executeViews.stationManage.CreateStationView;
import subway.view.executeViews.stationManage.DeleteStationView;
import subway.view.executeViews.stationManage.ShowStationView;

import java.util.Scanner;

public class StationManageView extends NavigationViewTemplate implements ViewStrategy {
    private static final String VIEW_NAME = "역 관리";
    private static final String NAV_VIEW_NAME = "역 관리 화면";

    public StationManageView(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected ViewsContainer setViewsContainer() {
        StationController stationController = StationController.get(StationRepositoryJava.get());
        ViewsContainer viewsContainer = ViewsContainer.newInstance();
        viewsContainer.add("1", new CreateStationView(stationController, scanner));
        viewsContainer.add("2", new DeleteStationView(stationController, scanner));
        viewsContainer.add("3", new ShowStationView(stationController));
        viewsContainer.add("B", new BackView());
        return viewsContainer;
    }

    @Override
    public void execute() {
        super.show();
    }

    @Override
    public String viewName() {
        return VIEW_NAME;
    }

    @Override
    protected String navViewName() {
        return NAV_VIEW_NAME;
    }
}
