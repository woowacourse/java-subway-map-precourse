package subway.controller;

import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.MenuItemsRepository;
import subway.view.InfoMessage;
import subway.view.Menu;

public class LineSystem {
    private MenuInputManager menuInputManager;
    private LineInputManager lineInputManager;

    public LineSystem(Scanner scanner, MenuInputManager menuInputManager) {
        this.menuInputManager = menuInputManager;
        lineInputManager = new LineInputManager(scanner);

    }

    public void run() {
        while (true) {
            Menu.printMenu(MenuItemsRepository.getLineItems());
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
            removeLine();
            System.out.println("노선 삭제");
        }
        if (input.equals("3")) {
            lookupLines();
        }
    }

    private void addLine() {
        String name = lineInputManager.getLineInput("등록할");
        Line line = new Line(name);
        LineRepository.addLine(line);

        InfoMessage.printLineAdded();
    }

    private void removeLine() {
    }

    private void lookupLines() {
        for (Line line : LineRepository.lines()) {
            InfoMessage.printName(line.getName());
        }
    }

}
