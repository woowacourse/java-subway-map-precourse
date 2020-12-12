package subway.controller;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.menu.MainMenu;
import subway.menu.Menu;
import subway.menu.StationMenu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class StationController implements SubwayController {

    private static final Menu STATE = StationMenu.BACK;
    private StationRepository stationRepository = new StationRepository();
    private final InputView inputView = InputView.getInstance();

    @Override
    public void save() {
        System.out.println("## 등록할 역 이름을 입력하세요");
        String name = inputView.inputName();
        stationRepository.addStation(Station.of(name));
    }

    @Override
    public void delete() {
        String name = inputView.inputName();
        stationRepository.deleteStation(name);
    }

    @Override
    public void findAll() {
        List<Station> stations = stationRepository.stations();
        OutputView.printStations(stations);
    }

    @Override
    public void findBy() {
        // 미구현
    }
}
