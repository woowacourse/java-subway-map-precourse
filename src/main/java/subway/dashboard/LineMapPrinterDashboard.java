package subway.dashboard;

import static subway.dashboard.DashboardWords.*;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class LineMapPrinterDashboard {
    public LineMapPrinterDashboard() {
        System.out.println(LIST_OF_TOTAL);
        for (Line line : LineRepository.lines()) {
            showLineInfo(line);
        }
    }

    public void showLineInfo(Line line) {
        System.out.printf("%s %s\n",INFO,line);
        System.out.printf("%s %s\n",INFO,INFO_DASH);
        for (Station station : line.getStations()) {
            System.out.printf("%s %s\n",INFO, station);
        }
        System.out.println();
    }
}
