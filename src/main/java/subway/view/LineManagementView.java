package subway.view;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import subway.Scene;
import subway.domain.LineRepository;
import subway.io.Request;
import subway.io.Response;

public class LineManagementView extends View {
    private static final String VIEW_NAME = "노선 관리 화면";
    private static final LinkedHashMap<String, Command> MENUS =
            new LinkedHashMap<String, Command>();

    static {
        MENUS.put("1", new Command("노선 등록", LineManagementView::registerLine));
        MENUS.put("2", new Command("노선 삭제", LineManagementView::removeLine));
        MENUS.put("3", new Command("구간 조회", LineManagementView::viewSections));
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
        response.printInfoMessage(Response.LINE_REGISTER_SUCCESS_MESSAGE);
        scene.back();
    }

    private static boolean registerLineName(Request request, Response response,
            List<String> inputs) {
        response.printHeadlineMessage(Response.LINE_TO_REGISTER_REQUEST_MESSAGE);
        String lineName = request.requestLineRegister();
        if (lineName == null) {
            return false;
        }
        inputs.add(lineName);
        return registerUpboundStationName(request, response, inputs);
    }

    private static boolean registerUpboundStationName(Request request, Response response,
            List<String> inputs) {
        response.printHeadlineMessage(Response.UPBOUND_STATION_TO_REGISTER_REQUEST_MESSAGE);
        String upboundStation = request.requestTerminatingStation();
        if (upboundStation == null) {
            return false;
        }
        inputs.add(upboundStation);
        return registerDownboundStationName(request, response, inputs);
    }

    private static boolean registerDownboundStationName(Request request, Response response,
            List<String> inputs) {
        response.printHeadlineMessage(Response.DOWNBOUND_STATION_TO_REGISTER_REQUEST_MESSAGE);
        String downboundStation = request.requestTerminatingStation();
        if (downboundStation == null) {
            return false;
        }
        inputs.add(downboundStation);
        return true;
    }

    private static void removeLine(Scene scene, Request request, Response response) {
        response.printHeadlineMessage(Response.LINE_TO_REMOVE_REQUEST_MESSAGE);
        if (request.requestLineRemoval()) {
            response.printInfoMessage(Response.LINE_REMOVAL_SUCCESS_MESSAGE);
            scene.back();
        }
    }

    private static void viewSections(Scene scene, Request request, Response response) {
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
