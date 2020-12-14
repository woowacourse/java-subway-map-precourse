package subway.domain.line;

import java.util.Arrays;
import java.util.Scanner;
import subway.domain.menu.Menu;
import subway.domain.menu.MenuInputManager;
import subway.domain.SubwayRepository;
import subway.common.ErrorMessage;
import subway.domain.menu.MenuKeys;
import subway.domain.menu.MenuOutputManager;

public class LineService {
    private final MenuInputManager menuInputManager;
    private final LineInputManager lineInputManager;

    public LineService(Scanner scanner, MenuInputManager menuInputManager) {
        this.menuInputManager = menuInputManager;
        lineInputManager = new LineInputManager(scanner);

    }

    public void run() {
        while (true) {
            MenuOutputManager.printMenu(Menu.LINE);
            String input = menuInputManager.getLineInput();
            if (input.equals(MenuKeys.BACK.getKey())) {
                return;
            }
            runSystemByInput(input);
        }
    }

    private void runSystemByInput(String input) {
        if (input.equals(MenuKeys.ONE.getKey())) {
            addLine();
        }
        if (input.equals(MenuKeys.TWO.getKey())) {
            deleteLine();
        }
        if (input.equals(MenuKeys.THREE.getKey())) {
            lookupLines();
        }
    }

    private void addLine() {
        String[] lineInfo = lineInputManager.getLineInfoToAdd();
        if (Arrays.asList(lineInfo).contains(ErrorMessage.OUT)) {
            return;
        }
        SubwayRepository.createSubwayRealLine(lineInfo);
        LineOutputManager.printAddedInfo();
    }

    private void deleteLine() {
        String name = lineInputManager.getLineNameToDelete();
        if (name.contains(ErrorMessage.OUT)) {
            return;
        }
        LineRepository.deleteLineByName(name);
        LineOutputManager.printDeletedInfo();
    }

    private void lookupLines() {
        LineOutputManager.printLines();
    }

}
