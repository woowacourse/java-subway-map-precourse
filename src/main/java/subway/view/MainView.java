package subway.view;

import subway.view.exit.ExitView;
import subway.view.lineManage.LineManageView;
import subway.view.lineMap.LineMapView;
import subway.view.lineStationManage.LineStationManageView;
import subway.view.stationManage.StationManageView;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {
    private static final Map<String, ViewStrategy> views = new LinkedHashMap<>();
    private static final String VIEW_NAME = "메인 화면";
    private static final String SELECT_FUNCTION = "원하는 기능을 선택하세요.";
    private Scanner scanner;
    private ViewStrategy viewStrategy;

    public MainView(Scanner scanner) {
        this.scanner = scanner;
        views.put("1", new StationManageView(scanner));
        views.put("2", new LineManageView());
        views.put("3", new LineStationManageView());
        views.put("4", new LineMapView());
        views.put("Q", new ExitView());
    }

    public void start() {
        mainView();
        OutputView.enter();
        manageView();
    }

    private void mainView() {
        OutputView.selectStrategy(views, VIEW_NAME);
        String viewKey = scanner.nextLine();
        viewStrategy = views.get(viewKey);
        if (viewStrategy == null) {
            OutputView.notExist();
            mainView();
        }
    }

    public void manageView() {
        viewStrategy.show();
        if (!(viewStrategy instanceof ExitView)) {
            start();
        }
    }
}
