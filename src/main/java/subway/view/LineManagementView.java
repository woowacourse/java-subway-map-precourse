package subway.view;



import static subway.resource.TextResource.ERROR_INVALID_FUNCTION;
import static subway.resource.TextResource.FUNCTION_BACK;
import static subway.resource.TextResource.FUNCTION_LINE_ADD;
import static subway.resource.TextResource.FUNCTION_LINE_DELETE;
import static subway.resource.TextResource.FUNCTION_LINE_LIST_SHOW;

import java.util.Scanner;
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
        if (KEY_BACK.equals(selection)) {
            onBackListener.onBack();
            return;
        }
        doStationManageFunction(selection);
    }

    private void doStationManageFunction(String selection) {
        if (KEY_ADD_LINE.equals(selection)) {
            return;
        }

        if (KEY_DELETE_LINE.equals(selection)) {
            return;
        }

        if (KEY_SHOW_LINE_LIST.equals(selection)) {
        }
    }

    private void initMenu() {
        menu.put(KEY_ADD_LINE, FUNCTION_LINE_ADD);
        menu.put(KEY_DELETE_LINE, FUNCTION_LINE_DELETE);
        menu.put(KEY_SHOW_LINE_LIST, FUNCTION_LINE_LIST_SHOW);
        menu.put(KEY_BACK, FUNCTION_BACK);
    }
}
