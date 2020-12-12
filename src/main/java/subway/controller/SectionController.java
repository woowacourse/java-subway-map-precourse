package subway.controller;

import subway.domain.Line.Line;
import subway.domain.Line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.exception.CannotRemoveException;
import subway.menu.Menu;
import subway.menu.SectionMenu;
import subway.view.InputView;

public class SectionController implements SubwayController {

    private final InputView inputView = InputView.getInstance();
    private final StationRepository stationRepository = new StationRepository();
    private final LineRepository lineRepository = new LineRepository();

    private static final Menu STATE = SectionMenu.BACK;

    @Override
    public void save() {

        Line line = inputRegisterLine();
        Station station = inputRegisterStation();
        int order = inputOrder();

        line.addTo(order, station);
        station.addLine(line);
    }

    private int inputOrder() {
        System.out.println("## 순서를 입력하세요");
        return inputView.inputNumber();
    }

    private Station inputRegisterStation() {
        System.out.println("## 역이름을 입력하세요");
        String stationName = inputView.input();
        return stationRepository.findBy(stationName);
    }

    private Line inputRegisterLine() {
        System.out.println("노선을 입력하세요.");
        String lineName = inputView.input();
        return lineRepository.findBy(lineName);
    }

    @Override
    public void delete() {

        Line line = inputDeleteLine();

        if (!line.canRemoveStation()) {
            throw new CannotRemoveException(line);
        }

        lineRepository.deleteLineByName(line.toString());

    }

    private Station inputDeleteStation() {
        System.out.println("삭제할 구간의 역이름을 입력하세요");
        String stationName = inputView.input();
        return stationRepository.findBy(stationName);
    }

    private Line inputDeleteLine() {
        System.out.println("삭제할 구간의 노선을 입력하세요.");
        String lineName = inputView.input();
        return lineRepository.findBy(lineName);
    }

    @Override
    public void findAll() {
        // 미구현
    }

    @Override
    public void findBy() {
        // 미구현
    }
}
