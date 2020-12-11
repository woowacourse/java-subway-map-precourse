package subway.service;

import subway.constant.Information;
import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;

import static subway.constant.Constant.LINE;
import static subway.constant.Information.INFO_HEADER;

public class PrintService {

    public void run() {
        System.out.print(Information.PRINT_INFO);
        printLines();
    }

    private void printLines() {
        for (Line line : LineRepository.lines()) {
            printLine(line);
            System.out.println();
        }
    }

    private void printLine(Line line) {
        System.out.print(INFO_HEADER + line.getName());
        System.out.print(INFO_HEADER + LINE);
        for (Station station : line.getStations())
            System.out.print(INFO_HEADER + station.getName());
    }
}
