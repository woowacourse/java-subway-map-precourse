package subway.subwaymap;

import subway.line.EachLineStations;
import subway.line.Line;
import subway.line.LineService;
import subway.view.subwaymap.SubwayMapView;

import java.util.List;

public class SubwayMapController {
    public static void showSubwayMap() {
        List<Line> lines = LineService.allLine();

        for (Line line : lines) {
            String lineName = line.getName();
            EachLineStations stations = line.getStations();
            SubwayMapView.showLineInformation(lineName, stations);
        }
    }
}
