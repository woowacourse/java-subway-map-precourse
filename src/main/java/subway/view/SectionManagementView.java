package subway.view;

import static subway.resource.TextResource.ASK_LINE_NAME_WHEN_ADD_SECTION;
import static subway.resource.TextResource.ASK_LINE_NAME_WHEN_DELETE_SECTION;
import static subway.resource.TextResource.ASK_ORDER_WHEN_ADD_SECTION;
import static subway.resource.TextResource.ASK_STATION_NAME_WHEN_ADD_SECTION;
import static subway.resource.TextResource.ASK_STATION_NAME_WHEN_DELETE_SECTION;
import static subway.resource.TextResource.COMPLETE_SECTION_ADD;
import static subway.resource.TextResource.COMPLETE_SECTION_DELETE;
import static subway.resource.TextResource.FUNCTION_BACK;
import static subway.resource.TextResource.FUNCTION_SECTION_ADD;
import static subway.resource.TextResource.FUNCTION_SECTION_DELETE;
import static subway.resource.TextResource.HEADER_SECTION_MANAGEMENT_VIEW;

import java.util.Scanner;
import subway.controller.SectionManagementController;
import subway.view.MainView.OnBackListener;

public class SectionManagementView extends View {

    private static final String KEY_ADD_SECTION = "1";
    private static final String KEY_DELETE_SECTION = "2";

    private OnBackListener onBackListener;

    public SectionManagementView(Scanner scanner, OnBackListener onBackListener) {
        super(scanner);
        this.onBackListener = onBackListener;
        initMenu();

    }

    @Override
    public void startView() {
        System.out.println(HEADER_SECTION_MANAGEMENT_VIEW);
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
        doSectionManageFunction(selection);
    }

    private void doSectionManageFunction(String selection) {
        if (KEY_ADD_SECTION.equals(selection)) {
            addSection();
            return;
        }

        if (KEY_DELETE_SECTION.equals(selection)) {
            deleteSection();
        }
    }

    private void addSection() {
        System.out.println(ASK_LINE_NAME_WHEN_ADD_SECTION);
        String lineName = scanner.nextLine();
        System.out.println(ASK_STATION_NAME_WHEN_ADD_SECTION);
        String stationName = scanner.nextLine();
        System.out.println(ASK_ORDER_WHEN_ADD_SECTION);
        String position = scanner.nextLine();
        SectionManagementController.getInstance()
            .addStationInSections(lineName, stationName, position);
        System.out.println(COMPLETE_SECTION_ADD);
        onBackListener.onBack();
    }

    private void deleteSection() {
        System.out.println(ASK_LINE_NAME_WHEN_DELETE_SECTION);
        String lineName = scanner.nextLine();
        System.out.println(ASK_STATION_NAME_WHEN_DELETE_SECTION);
        String stationName = scanner.nextLine();
        SectionManagementController.getInstance().deleteStationInSection(lineName, stationName);
        System.out.println(COMPLETE_SECTION_DELETE);
        onBackListener.onBack();
    }

    private void initMenu() {
        menu.put(KEY_ADD_SECTION, FUNCTION_SECTION_ADD);
        menu.put(KEY_DELETE_SECTION, FUNCTION_SECTION_DELETE);
        menu.put(KEY_BACK, FUNCTION_BACK);
    }
}
