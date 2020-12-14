package subway.function.line.management;

import subway.domain.line.LineRepository;
import subway.function.line.printer.LineManagementPrinter;

public class PrintAllLinesList {
    public static void printAllLinesList() {
        LineManagementPrinter.printLineListTitle();
        LineRepository.printAllLines();
    }
}
