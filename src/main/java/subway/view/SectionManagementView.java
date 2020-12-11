package subway.view;

import java.util.LinkedHashMap;
import subway.Scene;

public class SectionManagementView extends View {
    private static final String VIEW_NAME = "구간 관리 화면";
    private static final LinkedHashMap<String, Command> MENUS =
            new LinkedHashMap<String, Command>();

    static {
        MENUS.put("1", new Command("구간 등록", SectionManagementView::registerSection));
        MENUS.put("2", new Command("구간 삭제", SectionManagementView::removeSection));
        MENUS.put("B", new Command("돌아가기", SectionManagementView::back));
    }

    private static void registerSection(Scene scene) {
        scene.back();
    }

    private static void removeSection(Scene scene) {
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
