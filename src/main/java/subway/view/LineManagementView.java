package subway.view;

import java.util.LinkedHashMap;
import subway.Scene;

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

    private static void registerLine(Scene scene) {
        scene.back();
    }

    private static void removeLine(Scene scene) {
        scene.back();
    }

    private static void viewSections(Scene scene) {
        scene.back();
    }

    private static void back(Scene scene) {
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
