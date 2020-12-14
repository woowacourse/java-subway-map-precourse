package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.utils.ValidateUtils;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.TextCollection;

public class LineService {
    private static LineService lineService;

    public static LineService getInstance() {
        if (lineService == null) {
            lineService = new LineService();
        }
        return lineService;
    }

    public boolean insert() {
        OutputView.printQuestion(TextCollection.REGISTER_LINE_MESSAGE);
        Line line = new Line(InputView.inputValue());
        ValidateUtils.isDuplicatedUpDownStation(addUpwardSection(line), addDownSection(line));
        LineRepository.addLine(line);
        OutputView.printInformation(TextCollection.REGISTERED_LINE_MESSAGE);
        return true;
    }

    public boolean delete() {
        OutputView.printQuestion(TextCollection.DELETE_LINE_MESSAGE);
        LineRepository.deleteLineByName(InputView.inputValue());
        OutputView.printInformation(TextCollection.DELETED_LINE_MESSAGE);
        return true;
    }

    public boolean search() {
        OutputView.printQuestion(TextCollection.LINE_LIST_MESSAGE);
        LineRepository.printAllLine();
        return true;
    }

    public boolean backup() {
        return true;
    }

    private static Station addUpwardSection(Line line) {
        OutputView.printQuestion(TextCollection.REGISTER_UPWARD_STATION_MESSAGE);
        Station upwardStation = StationRepository.searchStation(InputView.inputValue());
        line.addSection(upwardStation);
        return upwardStation;
    }

    private static Station addDownSection(Line line) {
        OutputView.printQuestion(TextCollection.REGISTER_DOWN_STATION_MESSAGE);
        Station downStation = StationRepository.searchStation(InputView.inputValue());
        line.addSection(downStation);
        return downStation;
    }
}