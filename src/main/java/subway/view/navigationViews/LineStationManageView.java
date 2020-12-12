package subway.view.navigationViews;

import subway.line.LineController;
import subway.line.LineRepositoryJava;
import subway.station.StationRepositoryJava;
import subway.view.OutputView;
import subway.view.executeViews.BackView;
import subway.view.ViewStrategy;
import subway.view.ViewsContainer;
import subway.view.executeViews.lineStationManage.AddStationOnLineView;
import subway.view.executeViews.lineStationManage.RemoveStationFromLineView;

import java.util.Scanner;

public class LineStationManageView extends NavigationViewTemplate implements ViewStrategy {
    private static final String VIEW_NAME = "구간 관리";
    private static final String NAV_VIEW_NAME = "구간 관리 화면";

    public LineStationManageView(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected ViewsContainer setViewsContainer() {
        ViewsContainer viewsContainer = ViewsContainer.newInstance();
        LineController lineController = LineController.get(LineRepositoryJava.get(), StationRepositoryJava.get());
        viewsContainer.add("1", new AddStationOnLineView(lineController, scanner));
        viewsContainer.add("2", new RemoveStationFromLineView(lineController, scanner));
        viewsContainer.add("B", new BackView());
        return viewsContainer;
    }

    @Override
    public void execute() {
        super.show();
    }

    @Override
    protected String navViewName() {
        return NAV_VIEW_NAME;
    }

    @Override
    public String viewName() {
        return VIEW_NAME;
    }

}
