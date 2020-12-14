package subway.view.navigationViews;

import subway.line.LineController;
import subway.line.LineRepositoryJava;
import subway.station.StationRepositoryJava;
import subway.view.ViewStrategy;
import subway.view.ViewsContainer;
import subway.view.executeViews.BackView;
import subway.view.executeViews.lineManage.CreateLineView;
import subway.view.executeViews.lineManage.DeleteLineView;
import subway.view.executeViews.lineManage.ShowLineView;

import java.util.Scanner;

public class LineManageView extends NavigationViewTemplate implements ViewStrategy {
    private static final String VIEW_NAME = "노선 관리";
    private static final String NAV_VIEW_NAME = "노선 관리 화면";

    public LineManageView(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected ViewsContainer setViewsContainer() {
        ViewsContainer viewsContainer = ViewsContainer.newInstance();

        LineController lineController = LineController.get(LineRepositoryJava.get(), StationRepositoryJava.get());

        viewsContainer.add("1", new CreateLineView(lineController, scanner));
        viewsContainer.add("2", new DeleteLineView(lineController, scanner));
        viewsContainer.add("3", new ShowLineView(lineController));
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
