package subway.function.printsubwaymap.printer;

public class PrintSubwayMapPrinter {
    private static final String SUBWAY_MAP_TITLE
        = "\n## 지하철 노선도";
    public static final String SPLIT_LINE
        = "---";

    public static void printSubwayMapTitle() {
        System.out.println(SUBWAY_MAP_TITLE);
    }
}
