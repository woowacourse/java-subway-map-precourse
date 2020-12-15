package subway;

import java.util.Arrays;
import java.util.List;
import subway.service.LineService;
import subway.service.StationService;

public class SettingData {
    public static void load() {
        List<String> stations = Arrays.asList("교대역","강남역","역삼역","남부터미널역","양재역","양재시민의숲역","매봉역");
        saveStations(stations);
        LineService.register("2호선","교대역","역삼역");
        LineService.register("3호선","교대역","매봉역");
        LineService.register("신분당선","강남역","양재시민의숲역");
        LineService.join("2호선","강남역",2);
        LineService.join("3호선","남부터미널역",2);
        LineService.join("3호선","양재역",3);
        LineService.join("신분당선","양재역",2);
    }

    private static void saveStations(List<String> stationNames) {
        for (String stationName : stationNames) {
            StationService.register(stationName);
        }
    }
}
