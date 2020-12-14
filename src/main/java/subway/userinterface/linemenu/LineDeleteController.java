package subway.userinterface.linemenu;

import subway.service.LineService;
import subway.userinterface.Menu;
import subway.userinterface.OutputController;

import java.util.Scanner;

public class LineDeleteController implements Menu {

    private static final String LINE_DELETED = "\n[INFO] 지하철 노선이 삭제되었습니다.";
    private static final String MENU_NAME = "2. 노선 삭제";
    private static final String MENU_KEY = "2";

    private static final LineService lineService = new LineService();
    private static final LineDeleteInputController lineDeleteInputController
            = new LineDeleteInputController();
    private static LineDeleteController lineDeleteController;

    public static Menu getInstance() {
        if (lineDeleteController == null) {
            lineDeleteController = new LineDeleteController();
        }

        return lineDeleteController;
    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    @Override
    public String getMenuKey() {
        return MENU_KEY;
    }

    @Override
    public void run(Scanner scanner) throws IllegalArgumentException {
        String deleteLine;
        deleteLine = lineDeleteInputController.getUserInput(scanner);

        lineService.deleteLine(deleteLine);

        OutputController.printInfo(LINE_DELETED);
    }
}
