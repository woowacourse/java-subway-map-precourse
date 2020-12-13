package subway.view;

import static subway.resource.TextResource.HEADER_ROUTE_MAP_PRINT_VIEW;
import static subway.resource.TextResource.PREFIX_INFO;

import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Sections;
import subway.domain.Station;
import subway.view.MainView.OnBackListener;
import sun.swing.SwingUtilities2.Section;

public class RouteMapPrintView extends View {

    private static final String line = "---";

    private OnBackListener onBackListener;

    public RouteMapPrintView(Scanner scanner, OnBackListener onBackListener) {
        super(scanner);
        this.onBackListener = onBackListener;
    }

    @Override
    public void startView() {
        System.out.println(HEADER_ROUTE_MAP_PRINT_VIEW);
        printRouteMap();
        onBackListener.onBack();
    }

    private void printRouteMap() {
        for (Line line : LineRepository.lines()) {
            System.out.println(PREFIX_INFO + " " + line.getName());
            System.out.println(line);
            Sections sections = line.getSections();
            for (String station : sections.getSections()) {
                System.out.println(PREFIX_INFO + " " + station);
            }
        }
    }
}
