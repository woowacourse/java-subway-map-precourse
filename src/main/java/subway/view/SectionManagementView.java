package subway.view;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import subway.Scene;
import subway.domain.LineRepository;
import subway.io.Request;
import subway.io.Response;

public class SectionManagementView extends View {
    private static final String VIEW_NAME = "구간 관리 화면";
    private static final LinkedHashMap<String, Command> MENUS =
            new LinkedHashMap<String, Command>();

    static {
        MENUS.put("1", new Command("구간 등록", SectionManagementView::registerSection));
        MENUS.put("2", new Command("구간 삭제", SectionManagementView::removeSection));
        MENUS.put("B", new Command("돌아가기", SectionManagementView::back));
    }

    private static void registerSection(Scene scene, Request request, Response response) {
        List<String> inputs = new ArrayList<>();
        if (!registerLineOfSection(request, response, inputs)) {
            return;
        }
        LineRepository.addSection(inputs.get(0), inputs.get(1), inputs.get(2));
        response.printInfoMessage(Response.SECTION_REGISTER_SUCCESS_MESSAGE);
        scene.back();
    }

    private static boolean registerLineOfSection(Request request, Response response,
            List<String> inputs) {
        response.printHeadlineMessage(Response.LINE_OF_SECTION_REGISTER_MESSAGE);
        String lineName = request.requestLineOfSection();
        if (lineName == null) {
            return false;
        }
        inputs.add(lineName);
        return registerStationOfSection(request, response, inputs);
    }

    private static boolean registerStationOfSection(Request request, Response response,
            List<String> inputs) {
        response.printHeadlineMessage(Response.STATION_OF_SECTION_REGISETER_MESSAGE);
        String lineName = inputs.get(0);
        String stationName = request.requestStationOfSection(lineName);
        if (stationName == null) {
            return false;
        }
        inputs.add(stationName);
        return registerIndexOfSection(request, response, inputs);
    }

    private static boolean registerIndexOfSection(Request request, Response response,
            List<String> inputs) {
        response.printHeadlineMessage(Response.INDEX_OF_SECTION_REGISTER_MESSAGE);
        String lineName = inputs.get(0);
        String index = request.requestIndexOfSection(lineName);
        if (index == null) {
            return false;
        }
        inputs.add(index);
        return true;
    }

    private static void removeSection(Scene scene, Request request, Response response) {
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
