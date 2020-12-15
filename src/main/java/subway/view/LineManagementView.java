package subway.view;

import static subway.resource.TextResource.*;

import java.util.Scanner;
import subway.controller.LineManagementController;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.MainView.OnBackListener;

public class LineManagementView extends View {

    private static final String KEY_ADD_LINE = "1";
    private static final String KEY_DELETE_LINE = "2";
    private static final String KEY_SHOW_LINE_LIST = "3";

    private OnBackListener onBackListener;

    public LineManagementView(Scanner scanner, OnBackListener onBackListener) {
        super(scanner);
        this.onBackListener = onBackListener;
        initMenu();
    }

    @Override
    public void startView() {
        System.out.println(HEADER_LINE_MANAGEMENT_VIEW);
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
        if (KEY_ADD_LINE.equals(selection)) {
            addLine();
            return;
        }

        if (KEY_DELETE_LINE.equals(selection)) {
            deleteLine();
            return;
        }

        if (KEY_SHOW_LINE_LIST.equals(selection)) {
            showLineList();
        }
    }

    private void addLine() throws IllegalArgumentException {
        System.out.println(ASK_ADD_LINE_NAME);
        String name = scanner.nextLine();
        System.out.println(ASK_ADD_LINE_START);
        String start = scanner.nextLine();
        System.out.println(ASK_ADD_LINE_END);
        String end = scanner.nextLine();
        LineManagementController.getInstance().addLine(name, start, end);
        System.out.println(COMPLETE_LINE_ADD);
        onBackListener.onBack();
    }

    private void deleteLine() throws IllegalArgumentException {
        System.out.println(ASK_DELETE_LINE_NAME);
        String name = scanner.nextLine();
        LineManagementController.getInstance().deleteLine(name);
        System.out.println(COMPLETE_LINE_DELETE);
        onBackListener.onBack();
    }

    private void showLineList() {
        System.out.println(HEADER_LINE_LIST);
        for (Line line : LineRepository.lines()) {
            System.out.println(PREFIX_INFO + " " + line.getName());
        }
        onBackListener.onBack();
    }

    private void initMenu() {
        menu.put(KEY_ADD_LINE, FUNCTION_LINE_ADD);
        menu.put(KEY_DELETE_LINE, FUNCTION_LINE_DELETE);
        menu.put(KEY_SHOW_LINE_LIST, FUNCTION_LINE_LIST_SHOW);
        menu.put(KEY_BACK, FUNCTION_BACK);
    }
}
