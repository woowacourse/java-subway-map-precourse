package subway.view;

import static subway.resource.TextResource.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainView extends View {
    private static final String KEY_STATION_MANAGEMENT = "1";
    private static final String KEY_LINE_MANAGEMENT = "2";
    private static final String KEY_SECTION_MANAGEMENT = "3";
    private static final String KEY_ROUTE_MAP_PRINT = "4";

    private List<View> subViewList = new ArrayList<>();
    public interface OnBackListener {
        void onBack();
    }

    public MainView(Scanner scanner) {
        super(scanner);
        initSubView();
        initMenu();
    }

    @Override
    public void startView() {
        printMenu();
        String selection = scanner.nextLine();
        if (hasKey(selection)) {
            doFunction(selection);
            return;
        }
        System.out.println(ERROR_INVALID_FUNCTION);
        startView();
    }

    private void doFunction(String selection) {
        if (KEY_QUIT.equals(selection)) {
            System.exit(0);
        }
        int index = Integer.parseInt(selection) - 1;
        subViewList.get(index).startView();
    }

    private void initSubView() {
        subViewList.add(new StationManagementView(scanner, onBackListener));
        subViewList.add(new LineManagementView(scanner, onBackListener));
        subViewList.add(new SectionManagementView(scanner, onBackListener));
        subViewList.add(new RouteMapPrintView(scanner, onBackListener));
    }

    private void initMenu() {
        menu.put(KEY_STATION_MANAGEMENT, FUNCTION_STATION_MANAGEMENT);
        menu.put(KEY_LINE_MANAGEMENT, FUNCTION_LINE_MANAGEMENT);
        menu.put(KEY_SECTION_MANAGEMENT, FUNCTION_SECTION_MANAGEMENT);
        menu.put(KEY_ROUTE_MAP_PRINT, FUNCTION_ROUTE_MAP_PRINT);
        menu.put(KEY_QUIT, FUNCTION_QUIT);
    }

    private OnBackListener onBackListener = new OnBackListener() {
        @Override
        public void onBack() {
            startView();
        }
    };
}
