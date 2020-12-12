package subway.line.validation;

import subway.line.Line;
import subway.line.LineRepository;

import java.util.List;

public class CheckStationRegisteredLine {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String REGISTERED_STATION = ERROR_PREFIX + "노선에 등록되어 있는 역입니다.";

    public static void validation(String name) {
        List<Line> lines = LineRepository.lines();

        for (Line line : lines) {
            checkRegistered(line, name);
        }
    }

    private static void checkRegistered(Line line, String name) {
        if (line.isRegistered(name)) {
            throw new IllegalArgumentException(REGISTERED_STATION);
        }
    }
}
