package subway.view.section;

import subway.service.SectionService;

import java.util.Arrays;
import java.util.function.Supplier;

public enum SectionMenu {
    REGISTER("1", "구간 등록", () -> SectionService.getInstance().insert()),
    DELETE("2", "구간 삭제", () -> SectionService.getInstance().delete()),
    BACK("B", "돌아가기", () -> SectionService.getInstance().backup());

    private String key;
    private String title;
    private Supplier<Boolean> expression;

    SectionMenu(String key, String title, Supplier<Boolean> expression) {
        this.key = key;
        this.title = title;
        this.expression = expression;
    }

    public boolean request() {
        return expression.get();
    }

    public static SectionMenu findMenuByKey(String key) {
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
