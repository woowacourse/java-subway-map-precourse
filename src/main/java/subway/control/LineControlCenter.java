package subway.control;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.enums.LineMenu;
import subway.view.LineView;
import subway.view.MainView;
import subway.view.StationView;

import java.util.Scanner;

public class LineControlCenter {

    public LineControlCenter() {

    }

    public void startLineControl(Scanner scanner) {
        LineView.printLineMenu();
        MainView.askInputMenu();
        String command = MainControlCenter.inputCommand(scanner);
        selectMenu(command, scanner);
    }

    private void selectMenu(String command, Scanner scanner) {
        if (command.equals(LineMenu.ENROLL.getCommand())) {
            enrollLine(scanner);
            return;
        }
        if (command.equals(LineMenu.DELETE.getCommand())) {
            removeLine(scanner);
            return;
        }
        if (command.equals(LineMenu.CHECK.getCommand())) {
//            LineView.printLineList();
            return;
        }
    }

    private void enrollLine(Scanner scanner) {
        LineView.printAskLineNameToEnroll();
        String nameOfLine = MainControlCenter.inputCommand(scanner);
        if (LineRepository.isNameDuplication(nameOfLine)) {
            LineView.informLineDuplicated();
            enrollLine(scanner);
            return;
        }
        if (LineRepository.isNameLengthUnder2(nameOfLine)) {
            LineView.informNameLengthUnder2();
            enrollLine(scanner);
            return;
        }

        LineView.printAskUpLastStation();
        String upLastStation = MainControlCenter.inputCommand(scanner);
        LineView.printAskDownLastStation();
        String downLastStation = MainControlCenter.inputCommand(scanner);
        Line line = new Line(nameOfLine);
        LineRepository.addLine(line);
        LineView.informLineEnrolled();
    }

    private void removeLine(Scanner scanner) {

    }
}
