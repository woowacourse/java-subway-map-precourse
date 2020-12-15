package subway.controller.section;

import java.util.HashMap;
import java.util.LinkedHashMap;
import subway.controller.BackController;
import subway.controller.Controller;
import subway.util.InputUtils;
import subway.util.PrintUtils;

public class SectionController implements Controller {

    private final String TITLE = "구간 관리";
    private static final String TITLE_FOOTER = " 화면";
    private final static String BACK_CODE = "B";

    private static final HashMap<String, Controller> functionMap = new LinkedHashMap<>();

    public SectionController() {
        functionMap.put("1", new SectionInsertController());
        functionMap.put("2", new SectionDeleteController());
        functionMap.put(BACK_CODE, new BackController());
    }

    @Override
    public void run(InputUtils inputUtils) {
        while (true) {
            PrintUtils.printMenu(TITLE + TITLE_FOOTER, functionMap);

            String inputCommand = inputUtils.getNextLine();
            if (InputUtils.checkValidInput(inputCommand, functionMap.keySet())) {
                continue;
            }

            if (inputCommand.equals(BACK_CODE)) {
                return;
            }

            functionMap.get(inputCommand).run(inputUtils);
        }
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
