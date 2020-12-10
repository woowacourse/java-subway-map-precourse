package subway.domain;

import java.util.List;
import java.util.Map;

public class LineStationRepository {
    private Map<Line, List<Station>> lineStation;

    public LineStationRepository(Map<Line, List<Station>> lineStation) {
        this.lineStation = lineStation;
    }
}