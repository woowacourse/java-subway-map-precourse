package subway.view.mapprintoutput;

import subway.view.OutputView;

public class MapPrintOutputView extends OutputView {
    private static final String PRINT_MAP_LIST = "지하철 노선도";

    public static void printMapList() {
        printOutput(PRINT_MAP_LIST);
    }
}
