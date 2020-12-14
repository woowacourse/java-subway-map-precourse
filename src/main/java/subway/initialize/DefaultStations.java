package subway.initialize;

import java.util.ArrayList;
import java.util.Arrays;

public class DefaultStations {

    public static final String GYODAE = "교대역";
    public static final String GANGNAM = "강남역";
    public static final String YEOKSAM = "역삼역";
    public static final String NAMBU_BUS_TERMINAL = "남부터미널역";
    public static final String YANGJAE = "양재역";
    public static final String YANGJAE_CITIZEN_FOREST = "양재시민의숲역";
    public static final String MAEBONG = "매봉역";

    // 각 역을 포함하는 노선
    public static final String[] GYODAE_LINES = new String[]{DefaultLines.LINE_2, DefaultLines.LINE_3};
    public static final String[] GANGNAM_LINES = new String[]{DefaultLines.LINE_2, DefaultLines.LINE_SHINBUNDANG};
    public static final String[] YEOKSAM_LINES = new String[]{DefaultLines.LINE_2};
    public static final String[] NAMBU_BUS_TERMINAL_LINES = new String[]{DefaultLines.LINE_3};
    public static final String[] YANGJAE_LINES = new String[]{DefaultLines.LINE_3, DefaultLines.LINE_SHINBUNDANG};
    public static final String[] YANGJAE_CITIZEN_FOREST_LINES = new String[]{DefaultLines.LINE_SHINBUNDANG};
    public static final String[] MAEBONG_LINES = new String[]{DefaultLines.LINE_3};

    public static ArrayList<Pair> getTotalDefaultStations() {
        return new ArrayList<Pair>(
                Arrays.asList(
                        new Pair(GYODAE, GYODAE_LINES),
                        new Pair(GANGNAM, GANGNAM_LINES),
                        new Pair(YEOKSAM, YEOKSAM_LINES),
                        new Pair(NAMBU_BUS_TERMINAL, NAMBU_BUS_TERMINAL_LINES),
                        new Pair(YANGJAE, YANGJAE_LINES),
                        new Pair(YANGJAE_CITIZEN_FOREST, YANGJAE_CITIZEN_FOREST_LINES),
                        new Pair(MAEBONG, MAEBONG_LINES)
                )
        );
    }

}
