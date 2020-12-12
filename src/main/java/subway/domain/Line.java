package subway.domain;

import java.util.ArrayList;
import java.util.List;
import subway.domain.subRepository.PassingRouteRepository;

public class Line implements Node{
    private static final String CONTOUR = "---";
    private String name;
    private PassingRouteRepository passingRoutes = null;

    public Line(String name, PassingRouteRepository passingRoutes) {
        this.name = name;
        this.passingRoutes = passingRoutes;
    }

    public String getName() {
        return name;
    }

    public boolean equalWith(String newName) {
        return name.equals(newName);
    }

    public boolean isContaining(Station station) {
        return passingRoutes.isContaining(station);
    }

    public List<String> inquiryStations() {
        List<String> stationNames = new ArrayList<>();

        stationNames.add(this.name);
        stationNames.add(CONTOUR);

        stationNames = this.passingRoutes.addStationNames(stationNames);
        return stationNames;
    }
}
