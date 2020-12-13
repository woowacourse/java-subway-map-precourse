package subway.view;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import subway.Scene;
import subway.domain.SectionRepository;
import subway.io.ExceptionManager;
import subway.io.Request;
import subway.io.Response;

public class SectionManagementView extends View {
    private static final String LINE_OF_SECTION_REGISTER_MESSAGE = "노선을 입력하세요.";
    private static final String STATION_OF_SECTION_REGISETER_MESSAGE = "역이름을 입력하세요.";
    private static final String INDEX_OF_SECTION_REGISTER_MESSAGE = "순서를 입력하세요.";
    private static final String SECTION_REGISTER_SUCCESS_MESSAGE = "구간이 등록되었습니다.\n";
    private static final String LINE_OF_SECTION_REMOVAL_MESSAGE = "삭제할 구간의 노선을 입력하세요.";
    private static final String STATION_OF_SECTION_REMOVAL_MESSAGE = "삭제할 구간의 역을 입력하세요.";
    private static final String SECTION_REMOVAL_SUCCESS_MESSAGE = "구간이 삭제되었습니다.\n";
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
        SectionRepository.addSection(inputs.get(0), inputs.get(1), inputs.get(2));
        response.printInfoMessage(SECTION_REGISTER_SUCCESS_MESSAGE);
        scene.back();
    }

    private static boolean registerLineOfSection(Request request, Response response,
            List<String> inputs) {
        response.printHeadlineMessage(LINE_OF_SECTION_REGISTER_MESSAGE);
        String lineName = request.requestInput(ExceptionManager::checkValidLineOfSectionRegister);
        if (lineName == null) {
            return false;
        }
        inputs.add(lineName);
        return registerStationOfSection(request, response, inputs);
    }

    private static boolean registerStationOfSection(Request request, Response response,
            List<String> inputs) {
        response.printHeadlineMessage(STATION_OF_SECTION_REGISETER_MESSAGE);
        String stationName = request.requestInputInLine(
                ExceptionManager::checkValidStationOfSectionRegister, inputs.get(0));
        if (stationName == null) {
            return false;
        }
        inputs.add(stationName);
        return registerIndexOfSection(request, response, inputs);
    }

    private static boolean registerIndexOfSection(Request request, Response response,
            List<String> inputs) {
        response.printHeadlineMessage(INDEX_OF_SECTION_REGISTER_MESSAGE);
        String index = request.requestInputInLine(
                ExceptionManager::checkValidIndexOfSectionRegister, inputs.get(0));
        if (index == null) {
            return false;
        }
        inputs.add(index);
        return true;
    }

    private static void removeSection(Scene scene, Request request, Response response) {
        List<String> inputs = new ArrayList<>();
        if (!removeLineOfSection(request, response, inputs)) {
            return;
        }
        SectionRepository.deleteStationInLine(inputs.get(1), inputs.get(0));
        response.printInfoMessage(SECTION_REMOVAL_SUCCESS_MESSAGE);
        scene.back();
    }

    private static boolean removeLineOfSection(Request request, Response response,
            List<String> inputs) {
        response.printHeadlineMessage(LINE_OF_SECTION_REMOVAL_MESSAGE);
        String lineName = request.requestInput(ExceptionManager::checkValidLineOfSectionRemoval);
        if (lineName == null) {
            return false;
        }
        inputs.add(lineName);
        return removeStationOfSection(request, response, inputs);
    }

    private static boolean removeStationOfSection(Request request, Response response,
            List<String> inputs) {
        response.printHeadlineMessage(STATION_OF_SECTION_REMOVAL_MESSAGE);
        String stationName = request.requestInputInLine(
                ExceptionManager::checkValidStationOfSectionRemoval, inputs.get(0));
        if (stationName == null) {
            return false;
        }
        inputs.add(stationName);
        return true;
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
