package subway.view.text;

public enum Screen {
    MAIN("메인 화면"),
    STATION("역 관리 화면"),
    LINE("노선 관리 화면"),
    SECTION("구간 관리 화면"),
    MAP("지하철 노선도");

    private String title;

    Screen(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
}
