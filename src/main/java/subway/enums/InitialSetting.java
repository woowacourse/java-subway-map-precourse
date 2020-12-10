package subway.enums;

import java.util.Arrays;
import java.util.List;

public enum InitialSetting {
    STATIONS(Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역")),
    LINES(Arrays.asList("2호선", "3호선", "신분당선"));

    private List<String> values;

    InitialSetting(List<String> values) {
        this.values = values;
    }

    public List<String> getValues() {
        return values;
    }
}
