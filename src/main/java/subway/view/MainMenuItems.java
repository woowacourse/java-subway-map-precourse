package subway.view;

public enum MainMenuItems {

    TITLE("## 메인 화면"),STATION("1. 역 관리"), LINE("2. 노선 관리"), SECTION("3. 구간 관리"),
    MAP("4. 지하철 노선도 출력"), EXIT("Q. 종료");

    private final String menuItem;
    MainMenuItems(String menuItem){
        this.menuItem = menuItem;
    }
    public String getMenuItem(){
        return menuItem;
    }
}
