package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.utils.ValidateUtils;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.TextCollection;

public class SectionService {
    private static SectionService sectionService;

    public static SectionService getInstance() {
        if (sectionService == null) {
            sectionService = new SectionService();
        }
        return sectionService;
    }

    public boolean insert() {
        OutputView.printQuestion(TextCollection.INPUT_LINE_MESSAGE);
        Line line = LineRepository.searchLine(InputView.inputValue());
        OutputView.printQuestion(TextCollection.INPUT_STATION_MESSAGE);
        Station station = StationRepository.searchStation(InputView.inputValue());
        OutputView.printQuestion(TextCollection.INPUT_ORDER_MESSAGE);
        String number = InputView.inputValue();
        ValidateUtils.isNumber(number);
        int position = Integer.parseInt(number);
        line.addSectionWithPosition(position, station);
        OutputView.printInformation(TextCollection.REGISTERED_SECTION_MESSAGE);
        return true;
    }

    public boolean delete() {
        OutputView.printQuestion(TextCollection.DELETE_SECTION_LINE_MESSAGE);
        Line line = LineRepository.searchLine(InputView.inputValue());
        OutputView.printQuestion(TextCollection.DELETE_SECTION_STATION_MESSAGE);
        Station station = StationRepository.searchStation(InputView.inputValue());
        line.deleteSection(station);
        OutputView.printInformation(TextCollection.DELETED_SECTION_MESSAGE);
        return true;
    }

    public boolean backup() {
        return true;
    }
}
