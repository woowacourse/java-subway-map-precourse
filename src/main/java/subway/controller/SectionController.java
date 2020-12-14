package subway.controller;

import subway.domain.Line.Line;
import subway.domain.Line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.menu.SectionMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController implements SubwayController {

    private final InputView inputView = InputView.getInstance();
    private final StationRepository stationRepository = new StationRepository();
    private final LineRepository lineRepository = new LineRepository();

    private String DELETE_STATION_MESSAGE = "## 삭제할 구간의 역이름을 입력하세요";
    private String DELETE_LINE_MESSAGE = "## 삭제할 구간의 노선 이름을 입력하세요";
    private String INPUT_ORDER_MESSAGE = "## 순서를 입력하세요";
    private String INPUT_STATION_MESSAGE = "## 역이름을 입력하세요";
    private String INPUT_LINE_MESSAGE = "## 노선을 입력하세요.";


    @Override
    public void save() {

        Line line = inputRegisterLine();
        Station station = inputRegisterStation();
        int order = inputOrder();

        line.addTo(order, station);

        OutputView.printResultMessage(SectionMenu.REGISTER);
    }

    private int inputOrder() {
        System.out.println(INPUT_ORDER_MESSAGE);
        return inputView.inputNumber();
    }

    private Station inputRegisterStation() {
        System.out.println(INPUT_STATION_MESSAGE);
        String stationName = inputView.input();
        return stationRepository.findBy(stationName);
    }

    private Line inputRegisterLine() {
        System.out.println(INPUT_LINE_MESSAGE);
        String lineName = inputView.input();
        return lineRepository.findBy(lineName);
    }

    @Override
    public void delete() {

        Line line = inputDeleteLine();

        Station station = inputDeleteStation();
        line.removeStation(station);

        OutputView.printResultMessage(SectionMenu.DELETE);
    }

    private Station inputDeleteStation() {
        System.out.println(DELETE_STATION_MESSAGE);
        String stationName = inputView.input();
        return stationRepository.findBy(stationName);
    }

    private Line inputDeleteLine() {
        System.out.println(DELETE_LINE_MESSAGE);
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
