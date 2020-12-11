package subway.view;

import java.util.LinkedHashMap;
import subway.Scene;
import subway.io.Request;
import subway.io.Response;

public class StationManagementView extends View {
    private static final String VIEW_NAME = "역 관리 화면";
    private static final LinkedHashMap<String, Command> MENUS =
            new LinkedHashMap<String, Command>();

    static {
        MENUS.put("1", new Command("역 등록", StationManagementView::registerStaion));
        MENUS.put("2", new Command("역 삭제", StationManagementView::removeStation));
        MENUS.put("3", new Command("역 조회", StationManagementView::viewStations));
        MENUS.put("B", new Command("돌아가기", StationManagementView::back));
    }

    private static void registerStaion(Scene scene, Request request, Response response) {
        response.printStationToRegisterRequestMessage();
        boolean isSuccess = request.requestStationRegister();
        response.printEmptyMessage();
        if (isSuccess) {
            scene.back();
        }
    }

    private static void removeStation(Scene scene, Request request, Response response) {
        scene.back();
    }

    private static void viewStations(Scene scene, Request request, Response response) {
        scene.back();
    }

    private static void back(Scene scene, Request request, Response response) {
        scene.back();
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
