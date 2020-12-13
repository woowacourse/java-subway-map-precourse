package subway.view;

import static subway.resource.TextResource.ASK_ADD_STATION_NAME;
import static subway.resource.TextResource.ASK_DELETE_STATION_NAME;
import static subway.resource.TextResource.FUNCTION_BACK;
import static subway.resource.TextResource.FUNCTION_STATION_ADD;
import static subway.resource.TextResource.FUNCTION_STATION_DELETE;
import static subway.resource.TextResource.FUNCTION_STATION_LIST_SHOW;
import static subway.resource.TextResource.HEADER_STATION_MANAGEMENT_VIEW;

import java.util.Scanner;
import subway.controller.StationManagementController;
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

    private void doStationManageFunction(String selection) throws IllegalArgumentException {
        if (KEY_ADD_STATION.equals(selection)) {
            addStation();
            return;
        }

        if (KEY_DELETE_STATION.equals(selection)) {
            deleteStation();
            return;
        }

        if (KEY_SHOW_STATION_LIST.equals(selection)) {
        }
    }

    private void addStation() throws IllegalArgumentException {
        System.out.println(ASK_ADD_STATION_NAME);
        String name = scanner.nextLine();
        StationManagementController.getInstance().addStation(name);
        onBackListener.onBack();
    }

    private void deleteStation() {
        System.out.println(ASK_DELETE_STATION_NAME);
        String name = scanner.nextLine();
        StationManagementController.getInstance().deleteStation(name);
        onBackListener.onBack();
    }

    private void initMenu() {
        menu.put(KEY_ADD_STATION, FUNCTION_STATION_ADD);
        menu.put(KEY_DELETE_STATION, FUNCTION_STATION_DELETE);
        menu.put(KEY_SHOW_STATION_LIST, FUNCTION_STATION_LIST_SHOW);
        menu.put(KEY_BACK, FUNCTION_BACK);
    }
}
