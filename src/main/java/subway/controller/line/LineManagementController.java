package subway.controller.line;

import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.exception.InvalidFunctionException;
import subway.exception.SubwayApplicationException;
import subway.exception.line.LineNameFormatException;
import subway.exception.line.LineNameLengthException;
import subway.exception.line.LineNotFoundException;
import subway.repository.line.LineRepository;
import subway.repository.station.StationRepository;
import subway.service.LineDeleteService;
import subway.service.LineGenerateService;
import subway.service.LineListService;
import subway.service.LineRegisterService;
import subway.view.inputView.InputView;
import subway.view.output.LineManagementView;
import subway.view.output.MainMenuView;
import subway.view.output.OutputView;

import java.util.List;

public class LineManagementController implements Runnable {

    private StationRepository stationRepository;
    private LineRepository lineRepository;

    public LineManagementController(StationRepository stationRepository, LineRepository lineRepository) {
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
    }

    @Override
    public void run() {
        try {
            MainMenuView.printMenu(LineManagementMenu.toMenuString());
            Runnable function = selectFunction();
            if (function == null) {
                return;
            }
            function.run();
        } catch (SubwayApplicationException e) {
            run();
        }
    }

    private Runnable selectFunction() {
        LineManagementView.chooseFunction();
        String input = InputView.scan();

        Runnable function;
        try {
            function = LineManagementMenu.find(input);
        } catch (InvalidFunctionException e) {
            OutputView.print(e.getMessage());
            return selectFunction();
        }

        return function;
    }

    public void registerLine() {
        Line line = generateLine();
        new LineRegisterService(lineRepository).register(line);
    }

    private Line generateLine() {
        LineManagementView.printRegisterMessage();
        String name = InputView.scan();

        Station upline = getUpLineStation();
        Station downLine = getDownLineStation();

        return new LineGenerateService(stationRepository).generate(name, upline, downLine);
    }

    private Station getUpLineStation() {
        LineManagementView.printUpLineNameInputMessage();

        String upLineName = InputView.scan();
        StationName upLineStationName = StationName.of(upLineName);

        return Station.of(upLineStationName);
    }

    private Station getDownLineStation() {
        LineManagementView.printDownLineNameInputMessage();

        String downLineName = InputView.scan();
        StationName downLineStationName = StationName.of(downLineName);

        return Station.of(downLineStationName);
    }

    public void deleteLine() {
        LineManagementView.printDeleteMessage();

        String name = InputView.scan();
        LineName lineName = LineName.of(name);

        new LineDeleteService(lineRepository).delete(lineName);
    }

    public void viewLine() {
        List<Line> lines = new LineListService(lineRepository).get();
        LineManagementView.printLineList(lines);
    }
}
