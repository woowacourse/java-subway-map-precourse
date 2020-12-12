package subway.section;

import subway.common.exception.NotSupportedFunctionException;

import java.util.HashMap;
import java.util.Map;

public class SectionFunctionMapper {
    private static final Map<String, Runnable> mapper = new HashMap<>();
    private static final String REGISTRATION = "1";
    private static final String REMOVAL = "2";
    private static final String GO_BACK = "B";

    static {
        mapper.put(REGISTRATION, SectionController::register);
        mapper.put(REMOVAL, SectionController::remove);
        mapper.put(GO_BACK, () -> {
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
