package subway.controller;

import java.util.Arrays;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.SubwayRepository;
import subway.domain.LineRepository;
import subway.domain.PathRepository;
import subway.domain.MenuItemsRepository;
import subway.view.ErrorMessage;
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
        SubwayRepository.addSubwayRealLine(lineInfo);
        InfoMessage.printLineAdded();
      //  Line wantLine = LineRepository.findLine(lineInfo[0]);
//        PathRepository wantLinks = SubwayRepository.getStationLinksByLine(wantLine);
//        for (Station station : wantLinks.getPath()) {
//            System.out.println(station.getName());
//        }

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
