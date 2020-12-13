package subway.view;

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
        onBackListener.onBack();
    }
}
