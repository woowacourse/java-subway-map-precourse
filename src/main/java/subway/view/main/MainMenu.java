package subway.view.main;

import subway.repository.InitialRepository;
import subway.repository.LineRepository;
import subway.view.line.LineScreen;
import subway.view.section.SectionView;
import subway.view.station.StationScreen;

import java.util.Arrays;
import java.util.function.Consumer;

public enum MainMenu {
    STATION("1", "역 관리", (key) -> StationScreen.selectMenu()),
    LINE("2", "노선 관리", (key) -> LineScreen.selectMenu()),
    SECTION("3", "구간 관리", (key) -> SectionView.selectMenu()),
    PRINT("4", "지하철 노선도 출력", (key) -> LineRepository.printAllLine()),
    QUIT("Q", "종료", (key) -> InitialRepository.end());

    private String key;
    private String title;
    private Consumer<String> expression;

    MainMenu(String key, String title, Consumer<String> expression) {
        this.key = key;
        this.title = title;
        this.expression = expression;
    }

    public void request(String key){
        expression.accept(key);
    }

    public static MainMenu findMenuByKey(String key) {
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
