package subway.controller;

import static subway.util.TextConstant.*;

import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionMenuHandler {
    public static void addSection() {
        OutputView.showRequestInputMessage(ROUTE_OF_SECTION);
        Line line = LineRepository.findLine(InputView.nextLine().trim());

        OutputView.showRequestInputMessage(STATION_OF_SECTION);
        Station lineStation = StationRepository.findStationByName(InputView.nextLine().trim());

        OutputView.showRequestInputMessage(SEQUENCE);
        OutputView.showValidSequence(line.size());
        int sequence = Integer.parseInt(InputView.nextLine());

        SectionRepository.addSection(line, lineStation, sequence);
        OutputView.showCompleteMessage(SECTION, ADD);
    }

    public static void deleteSection() {
        OutputView.showRequestInputForDeleteMessage(ROUTE_OF_SECTION);
        Line line = LineRepository.findLine(InputView.nextLine().trim());

        OutputView.showRequestInputForDeleteMessage(STATION_OF_SECTION);
        Station lineStation = StationRepository.findStationByName(InputView.nextLine().trim());

        SectionRepository.deleteSection(line.getName(), lineStation.getName());
        OutputView.showCompleteMessage(SECTION, DELETE);
    }

    public static void back() {
    }
}
