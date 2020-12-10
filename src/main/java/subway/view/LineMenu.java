package subway.view;

import subway.service.LineService;
import subway.service.StationService;

import java.util.Arrays;
import java.util.function.Supplier;

public enum LineMenu {
    LINE_INSERT("1","노선 등록", ()-> LineService.getInstance().insert()),
    LINE_DELETE("2","노선 삭제",()->LineService.getInstance().delete()),
    LINE_SELECT("3","노선 조회",()->LineService.getInstance().printAllStation()),
    BACK("B","돌아가기",()->LineService.getInstance().back());

    private String key;
    private String menuName;
    private Supplier<Boolean> expression;

    LineMenu(String key,String menuName,Supplier<Boolean> expression){
        this.key=key;
        this.menuName=menuName;
        this.expression=expression;
    }

    public boolean request(){
        return expression.get();
    }

    public static LineMenu findMenuByKey(String key){
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
