package subway.domain.line;

import java.util.Arrays;
import java.util.Scanner;
import subway.domain.menu.MenuInputManager;
import subway.domain.SubwayRepository;
import subway.domain.menu.MenuItemsRepository;
import subway.common.ErrorMessage;
import subway.common.InfoMessage;
import subway.common.Guide;

public class LineService {
    private MenuInputManager menuInputManager;
    private LineInputManager lineInputManager;

    public LineService(Scanner scanner, MenuInputManager menuInputManager) {
        this.menuInputManager = menuInputManager;
        lineInputManager = new LineInputManager(scanner);

    }

    public void run() {
        while (true) {
            Guide.printMenu(MenuItemsRepository.getLineItems());
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
            System.out.println("노선 삭제");
        }
        if (input.equals("3")) {
            lookupLines();
        }
    }

    private void addLine() {
        String[] lineInfo = lineInputManager.getAddLineInfo();
        if (Arrays.asList(lineInfo).contains(ErrorMessage.OUT)) {
            return;
        }
        SubwayRepository.createSubwayRealLine(lineInfo);
        InfoMessage.printLineAdded();
    }

    private void deleteLine() {
        String name = lineInputManager.getLineNameToDelete();
        if (name.contains(ErrorMessage.OUT)) {
            return;
        }
        LineRepository.deleteLineByName(name);
        InfoMessage.printLineDeleted();
    }

    private void lookupLines() {
        for (Line line : LineRepository.lines()) {
            InfoMessage.printName(line.getName());
        }
    }

}
