package subway.view;

import java.util.LinkedHashMap;
import subway.Scene;
import subway.domain.StationRepository;
import subway.exception.StationExceptionManager;
import subway.io.Request;
import subway.io.Response;

public class StationManagementView extends View {
    private static final String STATION_REGISTER_MESSAGE = "등록할 역 이름을 입력하세요.";
    private static final String STATION_REMOVAL_MESSAGE = "삭제할 역 이름을 입력하세요.";
    private static final String STATION_REGISTER_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.\n";
    private static final String STATION_REMOVAL_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.\n";
    private static final String VIEW_NAME = "역 관리 화면";
    private static final LinkedHashMap<String, Command> MENUS =
            new LinkedHashMap<String, Command>();

    static {
        MENUS.put("1", new Command("역 등록", StationManagementView::registerStation));
        MENUS.put("2", new Command("역 삭제", StationManagementView::removeStation));
        MENUS.put("3", new Command("역 조회", StationManagementView::viewStations));
        MENUS.put("B", new Command("돌아가기", StationManagementView::back));
    }

    private static void registerStation(Scene scene, Request request, Response response) {
        response.printHeadlineMessage(STATION_REGISTER_MESSAGE);
        if (request.applyInput(StationExceptionManager::checkValidStationRegister,
                StationRepository::addStation)) {
            response.printInfoMessage(STATION_REGISTER_SUCCESS_MESSAGE);
            scene.back();
        }
    }

    private static void removeStation(Scene scene, Request request, Response response) {
        response.printHeadlineMessage(STATION_REMOVAL_MESSAGE);
        if (request.applyInput(StationExceptionManager::checkValidStationRemoval,
                StationRepository::deleteStation)) {
            response.printInfoMessage(STATION_REMOVAL_SUCCESS_MESSAGE);
            scene.back();
        }
    }

    private static void viewStations(Scene scene, Request request, Response response) {
        response.printStations();
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
