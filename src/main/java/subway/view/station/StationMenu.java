package subway.view.station;

import subway.service.StationService;

import java.util.Arrays;
import java.util.function.Supplier;

public enum StationMenu {
    REGISTER("1", "역 등록", () -> StationService.getInstance().insert()),
    DELETE("2", "역 삭제", () -> StationService.getInstance().delete()),
    SEARCH("3", "역 조회", () -> StationService.getInstance().search()),
    BACK("B", "돌아가기", () -> StationService.getInstance().backup());

    private String key;
    private String title;
    private Supplier<Boolean> expression;

    StationMenu(String key, String title, Supplier<Boolean> expression) {
        this.key = key;
        this.title = title;
        this.expression = expression;
    }

    public boolean request() {
        return expression.get();
    }

    public static StationMenu findMenuByKey(String key) {
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