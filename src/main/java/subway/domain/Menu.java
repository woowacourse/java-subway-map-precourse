package subway.domain;

public class Menu {

    public enum MainMenu{
        STATION("1", "역 관리"), LINE("2", "노선 관리")
        , SECTION("3", "구간 관리"), MAP("4", "지하철 노선도 출력")
        , END("Q", "종료");

        final private String order;
        final private String message;

        MainMenu(String order, String message) {
            this.order = order;
            this.message = message;
        }

        public String getOrder() {
            return order;
        }

        public String getMessage() {
            return message;
        }
    }

}
