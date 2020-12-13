package subway.view;

import static subway.resource.TextResource.ERROR_INVALID_FUNCTION;
import static subway.resource.TextResource.FUNCTION_BACK;
import static subway.resource.TextResource.FUNCTION_SECTION_ADD;
import static subway.resource.TextResource.FUNCTION_SECTION_DELETE;

import java.util.Scanner;
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
        doSectionManageFunction(selection);
    }

    private void doSectionManageFunction(String selection) {
        if (KEY_ADD_SECTION.equals(selection)) {
            return;
        }

        if (KEY_DELETE_SECTION.equals(selection)) {

        }
    }

    private void initMenu() {
        menu.put(KEY_ADD_SECTION, FUNCTION_SECTION_ADD);
        menu.put(KEY_DELETE_SECTION, FUNCTION_SECTION_DELETE);
        menu.put(KEY_BACK, FUNCTION_BACK);
    }
}
