package subway.view;

import static subway.resource.TextResource.HEADER_ROUTE_MAP_PRINT_VIEW;

import java.util.Scanner;
import subway.view.MainView.OnBackListener;

public class RouteMapPrintView extends View {

    private OnBackListener onBackListener;

    public RouteMapPrintView(Scanner scanner, OnBackListener onBackListener) {
        super(scanner);
        this.onBackListener = onBackListener;
    }

    @Override
    public void startView() {
        System.out.println(HEADER_ROUTE_MAP_PRINT_VIEW);
        onBackListener.onBack();
    }
}
