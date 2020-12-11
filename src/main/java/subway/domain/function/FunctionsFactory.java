package subway.domain.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import subway.domain.function.station.StationBackFunction;
import subway.domain.function.station.StationCreateFunction;
import subway.domain.function.station.StationDeleteFunction;
import subway.domain.function.station.StationReadFunction;

public class FunctionsFactory {

    public static Functions createStationFunctions() {
        HashMap<String, Function> functions = new HashMap<>();
        functions.put("1", new StationCreateFunction());
        functions.put("2", new StationDeleteFunction());
        functions.put("3", new StationReadFunction());
        functions.put("Q", new StationBackFunction());

        return new Functions(functions);
    }
}
