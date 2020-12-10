package subway.view;

import subway.domain.LineRepository;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public enum MainMenu  {
    STATION_MANAGEMENT("1","역 관리",(key)-> StationView.selectMenu()),
    LINE_MANAGEMENT("2","노선 관리",(key)-> LineView.selectMenu()),
    SECTION_MANAGEMENT("3","구간 관리",(key)-> SectionView.selectMenu()),
    LINES_VIEW_OUTPUT("4","지하철 노선도 출력",(key)-> LineRepository.printAllLinesAndStation()),
    QUIT("Q","종료");

    private String key;
    private String menuName;
    private Consumer<String> expression;

    MainMenu(String key,String menuName){
        this.key=key;
        this.menuName=menuName;
    }

    MainMenu(String key,String menuName,Consumer<String> expression){
        this.key=key;
        this.menuName=menuName;
        this.expression=expression;
    }

    public void request(String key){
        expression.accept(key);
    }

    public static MainMenu findMenuByKey(String key){
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
