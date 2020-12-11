package subway.view;

import java.util.LinkedHashMap;
import subway.Scene;
import subway.io.Request;
import subway.io.Response;

public class MainView extends View {
    private static final String VIEW_NAME = "메인 화면";
    private static final LinkedHashMap<String, Command> MENUS =
            new LinkedHashMap<String, Command>();

    static {
        MENUS.put("1", new Command("역 관리", MainView::goStationManagementView));
        MENUS.put("2", new Command("노선 관리", MainView::goLineManagementView));
        MENUS.put("3", new Command("구간 관리", MainView::goSectionManagementView));
        MENUS.put("4", new Command("지하철 노선도 출력", MainView::printMap));
        MENUS.put("Q", new Command("종료", MainView::exitSubwayManager));
    }

    private static void goStationManagementView(Scene scene, Request request, Response response) {
        scene.go(new StationManagementView());
    }

    private static void goLineManagementView(Scene scene, Request request, Response response) {
        scene.go(new LineManagementView());
    }

    private static void goSectionManagementView(Scene scene, Request request, Response response) {
        scene.go(new SectionManagementView());
    }

    private static void printMap(Scene scene, Request request, Response response) {}

    private static void exitSubwayManager(Scene scene, Request request, Response response) {
        scene.exit();
    }

    @Override
    public String getTitle() {
        return VIEW_NAME;
    }

    @Override
    public LinkedHashMap<String, Command> getMenus() {
        return MENUS;
    }
}
