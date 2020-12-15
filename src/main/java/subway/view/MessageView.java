package subway.view;

public class MessageView {

    public static final String ADD_STATION = "## 등록할 역 이름을 입력하세요.";
    public static final String ADD_STATION_SUCCESS = "[INFO] 지하철 역이 등록되었습니다.";
    public static final String GET_STATIONS_SUCCESS = "\n## 역 목록";
    public static final String SELECT_SELECTOR = "## 원하는 기능을 선택하세요.";

    public void printAddStationMessage() {
        System.out.println(ADD_STATION);
    }

    public void printAddSuccessMessage() {
        System.out.println(ADD_STATION_SUCCESS);
    }

    public void printGetStationsMessage() {
        System.out.println(GET_STATIONS_SUCCESS);
    }

    public void printSelectSelectorMessage() {
        System.out.println(SELECT_SELECTOR);
    }

}
