package subway.view;

import subway.service.LineService;

import java.util.Arrays;
import java.util.function.Supplier;

public enum SectionMenu {
    LINE_INSERT("1","구간 등록", ()-> LineService.getInstance().sectionInsert()),
    LINE_DELETE("2","구간 삭제",()->LineService.getInstance().sectionDelete()),
    BACK("B","돌아가기",()->LineService.getInstance().back());

    private String key;
    private String menuName;
    private Supplier<Boolean> expression;

    SectionMenu(String key,String menuName,Supplier<Boolean> expression){
        this.key=key;
        this.menuName=menuName;
        this.expression=expression;
    }

    public boolean request(){
        return expression.get();
    }

    public static SectionMenu findMenuByKey(String key){
        return Arrays.stream(values())
                .filter(menu->menu.getKey().equals(key))
                .findAny()
                .get();
    }

    public static boolean isValidInput(String input){
        return Arrays.stream(values())
                .anyMatch(menu->menu.getKey().equals(input));
    }

    public String getKey() {
        return key;
    }

    public String getMenuName() {
        return menuName;
    }
}
