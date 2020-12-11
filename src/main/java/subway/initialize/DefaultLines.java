package subway.initialize;

import java.util.ArrayList;
import java.util.Arrays;

public class DefaultLines {

    public static final String LINE_2 = "2호선";
    public static final String LINE_3 = "3호선";
    public static final String LINE_SHINBUNDANG = "신분당선";

    // 각 노선이 포함하는 역
    public static final String[] LINE_2_STATIONS = new String[]{
            DefaultStations.GYODAE, DefaultStations.GANGNAM, DefaultStations.YEOKSAM
    };
    public static final String[] LINE_3_STATIONS = new String[]{
            DefaultStations.GYODAE, DefaultStations.NAMBU_BUS_TERMINAL, DefaultStations.YANGJAE, DefaultStations.MAEBONG
    };
    public static final String[] LINE_SHINBUNDANG_STATIONS = new String[]{
            DefaultStations.GANGNAM, DefaultStations.YANGJAE, DefaultStations.YANGJAE_CITIZEN_FOREST
    };

    public static ArrayList<Pair> getTotalDefaultLines() {
        return new ArrayList<Pair>(
                Arrays.asList(
                        new Pair(LINE_2, LINE_2_STATIONS),
                        new Pair(LINE_3, LINE_3_STATIONS),
                        new Pair(LINE_SHINBUNDANG, LINE_SHINBUNDANG_STATIONS)
                )
        );
    }

}
