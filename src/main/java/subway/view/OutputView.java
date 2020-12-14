package subway.view;

import subway.domain.Line;
import subway.exception.SubwayException;
import subway.repository.LineRepository;

public class OutputView {

    public static void printQuestion(String message) {
        System.out.println();
        System.out.printf("%s %s\n", TextCollection.PREFIX, message);
    }

    public static void printInformation(String information) {
        System.out.println();
        System.out.println(TextCollection.INFO_TAG + information);
    }

    public static void printStationOrLine(String name) {
        System.out.println(TextCollection.INFO_TAG + name);
    }

    public static void printErrorMessage(SubwayException exception) {
        System.out.println();
        System.out.println(exception.getMessage());
    }

    public static void printSection(Line line) {
        printStationOrLine(line.getName());
        printStationOrLine(TextCollection.SEPARATOR);
        line.getSections().forEach(section -> printStationOrLine(section.getName()));
        System.out.println();
    }

    public static void printSubwayLineMap() {
        OutputView.printQuestion(TextCollection.SUBWAY_LINE_MAP_MESSAGE);
        LineRepository.lines().forEach(OutputView::printSection);
    }
}
