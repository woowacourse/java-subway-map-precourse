package subway.view.mapprintoutput;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.view.InfoView;
import subway.view.OutputView;

public class MapPrintInfoView extends InfoView {
    private static String BORDER_LINE = "---";

    public static void printMap() {
        for (Line line : LineRepository.lines()) {
            System.out.println(INFO + line.getName());
            System.out.println(INFO + BORDER_LINE);
            for (Station station : line.getStationsInLine()) {
                System.out.println(INFO + station.getName());
            }
            OutputView.printNewLine();
        }
    }
}
