package subway.domain;

import java.util.ArrayList;
import java.util.List;
import subway.domain.repository.PassingRouteRepository;

public class Line{

    private static final String CONTOUR = "---";
    private String name;
    public PassingRouteRepository passingRoutes = null;

    public Line(String name, PassingRouteRepository passingRoutes) {
        this.name = name;
        this.passingRoutes = passingRoutes;
    }

    public String getName() {
        return name;
    }

    public PassingRouteRepository getPassingRoutes() {
        return this.passingRoutes;
    }

    public boolean equalWith(String newName) {
        return name.equals(newName);
    }

    public List<String> inquiryStations() {
        List<String> stationNames = new ArrayList<>();

        stationNames.add(this.name);
        stationNames.add(CONTOUR);

        stationNames = this.passingRoutes.addStationNames(stationNames);
        return stationNames;
    }
}