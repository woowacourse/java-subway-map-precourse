package subway.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class InitConstants {

    public final static List<String> STATION_LIST =
        Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    public final static List<String> LINE_LIST = Arrays.asList("2호선", "3호선", "신분당선");

    public final static Map<String, List<String>> SECTION_LIST = Map.of(
        "2호선", new ArrayList<>(Arrays.asList("교대역", "강남역", "역삼역")),
        "3호선", new ArrayList<>(Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역")),
        "신분당선", new ArrayList<>(Arrays.asList("강남역", "양재역", "양재시민의숲역"))
    );
}
