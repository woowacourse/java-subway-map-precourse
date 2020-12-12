package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.controller.LineFunctionController.PRINT_ERROR_HEAD;

public class SubwayController {
    private final InputView inputView;

    public SubwayController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        initSetting();
        startSubway();
    }

    private void startSubway() {
        while (true) {
            OutputView.printMain();
            MainFunctions nowFunction = receiveMainFunction();
            OutputView.printOneLine();
            if (nowFunction.equals(MainFunctions.FINISH)) {
                break;
            }
            if (nowFunction.equals(MainFunctions.STATION)) {
                stationFunction();
            }
            if (nowFunction.equals(MainFunctions.LINE)) {
                lineFunction();
            }
            if (nowFunction.equals(MainFunctions.WAY)) {
                wayFunction();
            }
            if (nowFunction.equals(MainFunctions.SUBWAY)) {
                subwayFunction();
            }
        }
    }

    private MainFunctions receiveMainFunction(){
        try{
            return MainFunctions.haveNumber(this.inputView.receiveFunction());
        }catch (IllegalArgumentException e){
            System.out.println(PRINT_ERROR_HEAD+e.getMessage()+"\n");
            return receiveMainFunction();
        }
    }

    private void stationFunction() {
        while (true) {
            OutputView.printDetailFunction(MainFunctions.STATION);
            DetailFunctions detailFunction = receiveDetailFunction();
            if (detailFunction.equals(DetailFunctions.BACK)) {
                break;
            }
            StationFunction.doFunction(detailFunction, this.inputView);
        }
    }

    private DetailFunctions receiveDetailFunction(){
        try{
            return DetailFunctions.haveNumber(this.inputView.receiveFunction());
        }catch (IllegalArgumentException e){
            System.out.println(PRINT_ERROR_HEAD+e.getMessage()+"\n");
            return receiveDetailFunction();
        }
    }

    private void lineFunction() {
        while (true) {
            OutputView.printDetailFunction(MainFunctions.LINE);
            DetailFunctions detailFunction = receiveDetailFunction();
            if (detailFunction.equals(DetailFunctions.BACK)) {
                break;
            }
            LineFunctionController.doFunction(detailFunction, this.inputView);
        }
    }

    private void wayFunction() {
        while (true) {
            OutputView.printDetailFunction(MainFunctions.WAY);
            DetailFunctions detailFunction = receiveDetailFunction();
            if (detailFunction.equals(DetailFunctions.BACK)) {
                break;
            }
            WayFunctionController.doFunction(detailFunction, this.inputView);
        }
    }

    private void subwayFunction() {
        OutputView.printSubway(SubwayRepository.subway());
    }

    private void initSetting() {
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
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("교대역"));
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("강남역"));
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("역삼역"));
            }
            if (line.getName().equals("3호선")) {
                SubwayRepository.addLine(LineRepository.findLineByName(line.getName()));
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("교대역"));
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("남부터미널역"));
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("양재역"));
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("매봉역"));
            }
            if (line.getName().equals("신분당선")) {
                SubwayRepository.addLine(LineRepository.findLineByName(line.getName()));
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("강남역"));
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("양재역"));
                SubwayRepository.addLineStation(LineRepository.findLineByName(line.getName()), StationRepository.findStationByName("양재시민의숲역"));
            }
        }
    }
}
