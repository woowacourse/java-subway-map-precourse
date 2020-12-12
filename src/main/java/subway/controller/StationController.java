package subway.controller;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.menu.StationMenu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class StationController implements SubwayController {

    private final StationRepository stationRepository = new StationRepository();
    private final InputView inputView = InputView.getInstance();

    @Override
    public void save() {
        OutputView.printInputMessage(StationMenu.REGISTER);
        String name = inputView.input();
        stationRepository.addStation(Station.of(name));
        OutputView.printResultMessage(StationMenu.REGISTER);
    }

    @Override
    public void delete() {
        OutputView.printInputMessage(StationMenu.DELETE);

        String name = inputView.input();
        stationRepository.deleteStation(name);
        OutputView.printResultMessage(StationMenu.DELETE);
    }

    @Override
    public void findAll() {
        List<Station> stations = stationRepository.stations();
        OutputView.printStations(stations, StationMenu.DELETE);
    }

    @Override
    public void findBy() {
        // 미구현
    }
}
