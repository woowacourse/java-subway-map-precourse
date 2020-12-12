package subway.view.lineMap;

import subway.line.LineController;
import subway.line.LineResponseDTO;
import subway.station.StationResponseDTO;
import subway.view.OutputView;
import subway.view.ViewStrategy;

import java.util.List;

public class LineMapView implements ViewStrategy {
    private static final String VIEW_NAME = "지하철 노선도 출력";
    private static final String MAP_VIEW = "지하철 노선도";
    private static final String DIVIDER = "----";
    private final LineController lineController;

    public LineMapView(LineController lineController) {
        this.lineController = lineController;
    }

    @Override
    public void execute() {
        List<LineResponseDTO> lines = lineController.findLines();
        printLines(lines);
        OutputView.enter();
    }

    private void printLines(List<LineResponseDTO> lines) {
        OutputView.selectView(MAP_VIEW);
        lines.forEach(lineResponseDTO -> {
            OutputView.infoView(lineResponseDTO.getName());
            OutputView.infoView(DIVIDER);
            printStations(lineResponseDTO.getStations());
        });
    }

    private void printStations(List<StationResponseDTO> stations) {
        stations.forEach(station -> OutputView.infoView(station.getName()));
        System.out.println();
    }

    @Override
    public String toString() {
        return VIEW_NAME;
    }
}
