package subway.view;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    // static이면 이 위에 지우고 아래를 static으로 만들면됨

    public void printMainScreen() {
        System.out.println(Message.OUTPUT_MAIN_OPTION.message);
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printStationOption() {
        System.out.println(Message.OUTPUT_STATION_MANAGEMENT_OPTION.message);
    }

    private enum Message {
        OUTPUT_MAIN_OPTION("## 메인 화면\n"
                + "1. 역 관리\n"
                + "2. 노선 관리\n"
                + "3. 구간 관리\n"
                + "4. 지하철 노선도 출력\n"
                + "Q. 종료\n"
                + "\n"),
        OUTPUT_STATION_MANAGEMENT_OPTION("## 역 관리 화면\n"
                + "1. 역 등록\n"
                + "2. 역 삭제\n"
                + "3. 역 조회\n"
                + "B. 돌아가기\n"
                + "\n"),
        OUTPUT_STATION_SEARCH("## 역 목록"),
        OUTPUT_LINE_MANAGEMENT_OPTION("## 노선 관리 화면\n"
                + "1. 노선 등록\n"
                + "2. 노선 삭제\n"
                + "3. 노선 조회\n"
                + "B. 돌아가기\n"
                + "\n"),
        OUTPUT_SECTION_MANAGEMENT_OPTION("## 구간 관리 화면\n"
                + "1. 구간 등록\n"
                + "2. 구간 삭제\n"
                + "B. 돌아가기\n"
                + "\n"),
        OUTPUT_SUBWAY_MAP("## 지하철 노선도"),
        OUTPUT_INFO("[INFO] %s");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }


}