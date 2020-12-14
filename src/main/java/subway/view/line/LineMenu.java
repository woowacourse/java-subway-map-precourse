package subway.view.line;

import subway.service.LineService;
import subway.service.StationService;
import subway.view.station.StationMenu;

import java.util.Arrays;
import java.util.function.Supplier;

public enum LineMenu {
    REGISTER("1", "노선 등록", () -> LineService.getInstance().insert()),
    DELETE("2", "노선 삭제", () -> LineService.getInstance().delete()),
    SEARCH("3", "노선 조회", () -> LineService.getInstance().search()),
    BACK("B", "돌아가기", () -> LineService.getInstance().backup());

    private String key;
    private String title;
    private Supplier<Boolean> expression;

    LineMenu(String key, String title, Supplier<Boolean> expression) {
        this.key = key;
        this.title = title;
        this.expression = expression;
    }

    public boolean request(){
        return expression.get();
    }

    public static LineMenu findMenuByKey(String key) {
        return Arrays.stream(values())
                .filter(menu -> menu.getKey().equals(key))
                .findAny()
                .get();
    }

    public static boolean isValidInput(String input) {
        return Arrays.stream(values())
                .anyMatch(menu -> menu.getKey().equals(input));
    }

    public String getKey() {
        return key;
    }

    public String getTitle() {
        return title;
    }

}
