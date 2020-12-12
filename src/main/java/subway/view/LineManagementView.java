package subway.view;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import subway.Scene;
import subway.domain.LineRepository;
import subway.io.ExceptionManager;
import subway.io.Request;
import subway.io.Response;

public class LineManagementView extends View {
    private static final String LINE_REGISTER_MESSAGE = "등록할 노선 이름을 입력하세요.";
    private static final String UPBOUND_STATION_REGISTER_MESSAGE = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String DOWNBOUND_STATION_REGISTER_MESSAGE = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String LINE_REGISTER_SUCCESS_MESSAGE = "지하철 노선이 등록되었습니다.\n";
    private static final String LINE_REMOVAL_MESSAGE = "삭제할 노선 이름을 입력하세요.";
    private static final String LINE_REMOVAL_SUCCESS_MESSAGE = "지하철 노선이 삭제되었습니다.\n";
    private static final String VIEW_NAME = "노선 관리 화면";
    private static final LinkedHashMap<String, Command> MENUS =
            new LinkedHashMap<String, Command>();

    static {
        MENUS.put("1", new Command("노선 등록", LineManagementView::registerLine));
        MENUS.put("2", new Command("노선 삭제", LineManagementView::removeLine));
        MENUS.put("3", new Command("노선 조회", LineManagementView::viewLines));
        MENUS.put("B", new Command("돌아가기", LineManagementView::back));
    }

    private static void registerLine(Scene scene, Request request, Response response) {
        List<String> inputs = new ArrayList<>();
        if (!registerLineName(request, response, inputs)) {
            return;
        }
        if (!request.isValidTerminatingStationPair(inputs.get(1), inputs.get(2))) {
            return;
        }
        LineRepository.addLine(inputs.get(0), inputs.get(1), inputs.get(2));
        response.printInfoMessage(LINE_REGISTER_SUCCESS_MESSAGE);
        scene.back();
    }

    private static boolean registerLineName(Request request, Response response,
            List<String> inputs) {
        response.printHeadlineMessage(LINE_REGISTER_MESSAGE);
        String lineName = request.requestInput(ExceptionManager::checkValidLineRegister);
        if (lineName == null) {
            return false;
        }
        inputs.add(lineName);
        return registerUpboundStationName(request, response, inputs);
    }

    private static boolean registerUpboundStationName(Request request, Response response,
            List<String> inputs) {
        response.printHeadlineMessage(UPBOUND_STATION_REGISTER_MESSAGE);
        String upboundStation =
                request.requestInput(ExceptionManager::checkValidTerminatingStation);
        if (upboundStation == null) {
            return false;
        }
        inputs.add(upboundStation);
        return registerDownboundStationName(request, response, inputs);
    }

    private static boolean registerDownboundStationName(Request request, Response response,
            List<String> inputs) {
        response.printHeadlineMessage(DOWNBOUND_STATION_REGISTER_MESSAGE);
        String downboundStation =
                request.requestInput(ExceptionManager::checkValidTerminatingStation);
        if (downboundStation == null) {
            return false;
        }
        inputs.add(downboundStation);
        return true;
    }

    private static void removeLine(Scene scene, Request request, Response response) {
        response.printHeadlineMessage(LINE_REMOVAL_MESSAGE);
        if (request.applyInput(ExceptionManager::checkValidLineRemoval,
                LineRepository::deleteLineByName)) {
            response.printInfoMessage(LINE_REMOVAL_SUCCESS_MESSAGE);
            scene.back();
        }
    }

    private static void viewLines(Scene scene, Request request, Response response) {
        response.printLines();
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
