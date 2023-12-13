package subway.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Route {
    private Map<Line, List<Station>> route;

    public Route() {
        this.route = new HashMap<>();
    }

    public void add(Line line, List<Station> stations) {
        route.put(line, stations);
    }

}
