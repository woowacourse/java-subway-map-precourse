package subway.station;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StationFunctionMapper {
    private static final Map<String, Runnable> mapper = new HashMap<>();
    private static final String REGISTRATION = "1";
    private static final String REMOVAL = "2";
    private static final String INQUIRY = "3";
    private static final String GO_BACK = "B";

    static {
        mapper.put(REGISTRATION, StationController::register);
        mapper.put(REMOVAL, StationController::remove);
        mapper.put(INQUIRY, StationController::inquire);
        mapper.put(GO_BACK, () -> {
        });
    }

    public static Optional<Runnable> matchFunction(String command) {
        return Optional.ofNullable(mapper.get(command));
    }
}
