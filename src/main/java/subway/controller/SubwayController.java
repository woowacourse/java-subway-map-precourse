package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.StationOutputView;

public class SubwayController {
    private static final String function = "역";
    private final InputView inputView;

    public SubwayController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        initSetting();
        OutputView.printMain();
        if(MainFunctions.haveNumber(this.inputView.receiveFunction()).equals(MainFunctions.STATION)){
            stationFunction();
        }
    }

    private void stationFunction() {
        while (true) {
            OutputView.printDetailFunction(MainFunctions.STATION);
            DetailFunctions detailFunction = DetailFunctions.haveNumber(this.inputView.receiveFunction());
            if(detailFunction.equals(DetailFunctions.BACK)){
                break;
            }
            StationFunction.doFunction(detailFunction, this.inputView);
        }
    }
    private void initSetting(){
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));

        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));

        for (Line line : LineRepository.lines()) {
            if (line.getName().equals("2호선")) {
                SubwayRepository.addLine(LineRepository.findLineByName(line.getName()));
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("교대역"), 0);
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("강남역"), 1);
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("교대역"), 2);
            }
            if (line.getName().equals("3호선")) {
                SubwayRepository.addLine(LineRepository.findLineByName(line.getName()));
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("교대역"), 0);
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("남부터미널역"), 1);
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("양재역"), 2);
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("매봉역"), 3);
            }
            if (line.getName().equals("신분당선")) {
                SubwayRepository.addLine(LineRepository.findLineByName(line.getName()));
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("강남역"), 0);
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("양재역"), 1);
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("양재시민의숲역"), 2);
            }
        }
    }
}
