package subway.domain.line;

import java.util.Arrays;
import java.util.Scanner;
import subway.domain.menu.MenuInputManager;
import subway.domain.SubwayRepository;
import subway.domain.menu.MenuItemsRepository;
import subway.common.ErrorMessage;
import subway.common.InfoMessage;
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
            MenuOutputManager.printMenu(MenuItemsRepository.getLineItems());
            String input = menuInputManager.getLineInput();
            if (input.equals("B")) {
                return;
            }
            runSystemByInput(input);
        }
    }

    private void runSystemByInput(String input) {
        if (input.equals("1")) {
            addLine();
        }
        if (input.equals("2")) {
            deleteLine();
        }
        if (input.equals("3")) {
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
