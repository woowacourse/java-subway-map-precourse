package subway.view;

import static subway.resource.TextResource.ERROR_INVALID_FUNCTION;
import static subway.resource.TextResource.FUNCTION_BACK;
import static subway.resource.TextResource.FUNCTION_STATION_ADD;
import static subway.resource.TextResource.FUNCTION_STATION_DELETE;
import static subway.resource.TextResource.FUNCTION_STATION_LIST_SHOW;
import static subway.resource.TextResource.HEADER_STATION_MANAGEMENT_VIEW;

import java.util.Scanner;
import subway.view.MainView.OnBackListener;

public class StationManagementView extends View {

    private static final String KEY_ADD_STATION = "1";
    private static final String KEY_DELETE_STATION = "2";
    private static final String KEY_SHOW_STATION_LIST = "3";

    private OnBackListener onBackListener;

    public StationManagementView(Scanner scanner, OnBackListener onBackListener) {
        super(scanner);
        this.onBackListener = onBackListener;
        initMenu();
    }

    @Override
    public void startView() {
        System.out.println(HEADER_STATION_MANAGEMENT_VIEW);
        printMenu();
        String selection = scanner.nextLine();
        try {
            doFunction(selection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            startView();
        }
    }

    private void doFunction(String selection) {
        checkKey(selection);
        if (KEY_BACK.equals(selection)) {
            onBackListener.onBack();
            return;
        }
        doStationManageFunction(selection);
    }

    private void doStationManageFunction(String selection) {
        if (KEY_ADD_STATION.equals(selection)) {
            return;
        }

        if (KEY_DELETE_STATION.equals(selection)) {
            return;
        }

        if (KEY_SHOW_STATION_LIST.equals(selection)) {
        }
    }

    private void initMenu() {
        menu.put(KEY_ADD_STATION, FUNCTION_STATION_ADD);
        menu.put(KEY_DELETE_STATION, FUNCTION_STATION_DELETE);
        menu.put(KEY_SHOW_STATION_LIST, FUNCTION_STATION_LIST_SHOW);
        menu.put(KEY_BACK, FUNCTION_BACK);
    }
}
