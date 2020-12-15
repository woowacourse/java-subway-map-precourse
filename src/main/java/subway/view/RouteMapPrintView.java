package subway.view;

import static subway.resource.TextResource.*;

import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Sections;
import subway.view.MainView.OnBackListener;

public class RouteMapPrintView extends View {

    private static final String DIVISION_LINE = "---";

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
            System.out.println(PREFIX_INFO + " " + DIVISION_LINE);
            Sections sections = line.getSections();
            for (String station : sections.getSections()) {
                System.out.println(PREFIX_INFO + " " + station);
            }
            System.out.println();
        }
    }
}
