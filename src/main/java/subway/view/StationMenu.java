package subway.view;

import subway.domain.Station;
import subway.service.StationService;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

public enum StationMenu {
    STATION_INSERT("1","역 등록", ()->StationService.getInstance().insert()),
    STATION_DELETE("2","역 삭제",()->StationService.getInstance().delete()),
    STATION_SELECT("3","역 조회",()->StationService.getInstance().find()),
    BACK("B","돌아가기",()->StationService.getInstance().back());

    private String key;
    private String menuName;
    private Supplier<Boolean> expression;

    StationMenu(String key,String menuName,Supplier<Boolean> expression){
        this.key=key;
        this.menuName=menuName;
        this.expression=expression;
    }

    public boolean request(){
        return expression.get();
    }

    public static StationMenu findMenuByKey(String key){
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
