package subway.view;

public class StationOutputView {
    public static final String PRINT_INFO_HEAD = "[INFO] ";

    public static void printEnroll() {
        System.out.println();
        System.out.println("## 등록할 " + "역" + " 이름을 입력하세요.");
    }

    public static void printSuccessEnroll() {
        System.out.println();
        System.out.println(PRINT_INFO_HEAD +"지하철 역이 등록되었습니다.");
    }
}
