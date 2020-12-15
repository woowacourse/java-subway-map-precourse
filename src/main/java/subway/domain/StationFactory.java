package subway.domain;

import subway.exception.SubwayException;
import subway.util.ValidateUtil;

import static subway.util.TextConstant.*;

public class StationFactory {
    public static Station makeStation(String name) {
        ValidateUtil.makeStationValidate(name);
        return new Station(name);
    }
}
