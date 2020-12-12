package subway;

import subway.common.exception.NotSupportedFunctionException;
import subway.line.LineController;
import subway.section.SectionController;
import subway.station.StationController;

import java.util.HashMap;
import java.util.Map;

public class MainFunctionMapper {
    private static final Map<String, Runnable> mapper = new HashMap<>();
    private static final String STATION_MANAGEMENT = "1";
    private static final String LINE_MANAGEMENT = "2";
    private static final String SECTION_MANAGEMENT = "3";
    private static final String PRINT_SUBWAY_MAP = "4";
    private static final String TERMINATE = "Q";

    static {
        mapper.put(STATION_MANAGEMENT, StationController::execute);
        mapper.put(LINE_MANAGEMENT, LineController::execute);
        mapper.put(SECTION_MANAGEMENT, SectionController::execute);
        mapper.put(PRINT_SUBWAY_MAP, SubwayMapPrinter::print);
        mapper.put(TERMINATE, () -> {
        });
    }

    public static Runnable matchFunction(String command) {
        return mapper.entrySet().stream()
                .filter(entry -> entry.getKey().equals(command))
                .map(Map.Entry::getValue)
                .findAny()
                .orElseThrow(NotSupportedFunctionException::new);
    }
}
