package subway.domain.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import subway.domain.function.line.LineBackFunction;
import subway.domain.function.line.LineCreateFunction;
import subway.domain.function.line.LineDeleteFunction;
import subway.domain.function.line.LineReadFunction;
import subway.domain.function.section.SectionBackFunction;
import subway.domain.function.section.SectionCreateFunction;
import subway.domain.function.section.SectionDeleteFunction;
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
        functions.put("B", new StationBackFunction());

        return new Functions(functions);
    }

    public static Functions createSectionFunctions() {
        HashMap<String, Function> functions = new HashMap<>();
        functions.put("1", new SectionCreateFunction());
        functions.put("2", new SectionDeleteFunction());
        functions.put("B", new SectionBackFunction());

        return new Functions(functions);
    }

    public static Functions createLineFunction() {
        HashMap<String, Function> functions = new HashMap<>();
        functions.put("1", new LineCreateFunction());
        functions.put("2", new LineDeleteFunction());
        functions.put("3", new LineReadFunction());
        functions.put("B", new LineBackFunction());

        return new Functions(functions);
    }
}
