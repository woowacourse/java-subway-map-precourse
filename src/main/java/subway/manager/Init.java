package subway.manager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Init {
    private static final String GYODAE = "교대역";
    private static final String GANGNAM = "강남역";
    private static final String YEOKSAM = "역삼역";
    private static final String SOUTH_TERMINAL = "남부터미널역";
    private static final String YANGJAE = "양재역";
    private static final String YANGJAE_FOREST = "양재시민의숲역";
    private static final String MAEBONG = "매봉역";

    public static final List<String> INIT_LIST = Arrays.asList(GYODAE, GANGNAM, YEOKSAM, SOUTH_TERMINAL, YANGJAE,
            YANGJAE_FOREST, MAEBONG);

    private static final String TWO_LINE = "2호선";
    private static final List<String> TWO_LINE_LIST = Arrays.asList(GYODAE, GANGNAM, YEOKSAM);

    private static final String THREE_LINE = "3호선";
    private static final List<String> THREE_LINE_LIST = Arrays.asList(SOUTH_TERMINAL, YANGJAE, MAEBONG);

    private static final String SINBUNDANG_LINE = "신분당선";
    private static final List<String> SINBUNDANG_LINE_LIST = Arrays.asList(GANGNAM, YANGJAE, YANGJAE_FOREST);

    @SuppressWarnings("serial")
    public static final Map<String, List<String>> LINE_MAP = new HashMap<>() {
        {
            put(TWO_LINE, TWO_LINE_LIST);
            put(THREE_LINE, THREE_LINE_LIST);
            put(SINBUNDANG_LINE, SINBUNDANG_LINE_LIST);
        }
    };
}
