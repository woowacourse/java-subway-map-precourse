package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;

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

    private MainFunctions receiveMainFunction() {
        try {
            return MainFunctions.haveNumber(this.inputView.receiveFunction());
        } catch (IllegalArgumentException e) {
            System.out.println(PRINT_ERROR_HEAD + e.getMessage());
            System.out.println();
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
            StationFunctionController.doFunction(detailFunction, this.inputView);
        }
    }

    private DetailFunctions receiveDetailFunction() {
        try {
            return DetailFunctions.haveNumber(this.inputView.receiveFunction());
        } catch (IllegalArgumentException e) {
            System.out.println(PRINT_ERROR_HEAD + e.getMessage());
            System.out.println();
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
        List<String> initStations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        List<String> initLines = Arrays.asList("2호선", "3호선", "신분당선");

        addInitStations(initStations);
        addInitLines(initLines);
        for (Line line : LineRepository.lines()) {
            SubwayRepository.addLine(line);
            addInitSecondLine(initStations, line);
            addInitThirdLine(initStations, line);
            addInitSinLine(initStations, line);
        }
    }

    private void addInitStations(List<String> initStations) {
        for (String station : initStations) {
            StationRepository.addStation(new Station(station));
        }
    }

    private void addInitLines(List<String> initLines) {
        for (String line : initLines) {
            LineRepository.addLine(new Line(line));
        }
    }

    private void addInitSecondLine(List<String> initStations, Line line) {
        if (line.getName().equals("2호선")) {
            List<Integer> initSecondStations = Arrays.asList(0, 1, 2);
            for (Integer index : initSecondStations) {
                SubwayRepository.addLineStation(line, StationRepository.findStationByName(initStations.get(index)));
            }
        }
    }

    private void addInitThirdLine(List<String> initStations, Line line) {
        if (line.getName().equals("3호선")) {
            List<Integer> initSecondStations = Arrays.asList(0, 3, 4, 6);
            for (Integer index : initSecondStations) {
                SubwayRepository.addLineStation(line, StationRepository.findStationByName(initStations.get(index)));
            }
        }
    }

    private void addInitSinLine(List<String> initStations, Line line) {
        if (line.getName().equals("신분당선")) {
            List<Integer> initSecondStations = Arrays.asList(1, 4, 5);
            for (Integer index : initSecondStations) {
                SubwayRepository.addLineStation(line, StationRepository.findStationByName(initStations.get(index)));
            }
        }
    }
}
