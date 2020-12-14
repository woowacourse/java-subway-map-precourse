package subway.console.message;

/**
 * @author yhh1056
 * @since 2020/12/14
 */
public class InfoMessage {
    public static final String STATIONS = "\n## 역목록";
    public static final String LINES = "\n## 노선목록";
    public static final String SUBWAY_LINE = "\n## 지하철 노선도";
    public static final String INFO = "[INFO] ";
    public static final String SUBWAY_INFO = "[INFO] ---";

    public static final String CREATE_STATION = "\n[INFO] 지하철 역이 등록되었습니다.";
    public static final String DELETE_STATION = "\n[INFO] 지하철 역이 삭제되었습니다.";

    public static final String CREATE_LINE = "\n[INFO] 지하철 노선이 등록되었습니다.";
    public static final String DELETE_LINE = "\n[INFO] 지하철 노선이 삭제되었습니다.";

    public static final String CREATE_SECTION = "\n[INFO] 구간이 등록되었습니다.";
    public static final String DELETE_SECTION = "\n[INFO] 구간이 삭제되었습니다.";

    private InfoMessage() {
    }
}
