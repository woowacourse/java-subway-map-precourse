package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayMap {
    private LineRepository lineRepository;
    private StationRepository stationRepository;
    private boolean isRun = true;
    private OutputView outputView;
    private InputView inputView;
    private Scanner scanner;
    private ErrorHandler errorHandler;

    public void Run(Scanner scanner) {
        // 에러시 무한 루프(일단 보류)
        this.scanner = scanner;
        while(isRun) {
            outputView = new OutputView();
            inputView = new InputView();
            errorHandler = new ErrorHandler();
            startMain(scanner);
        }
    }

    private void startMain(Scanner scanner) {
        outputView.printMainScreen();
        inputView.scanData(scanner);
        try{
            errorHandler.validateMainInput(inputView.getInputData());
        } catch(IllegalArgumentException E) {
            outputView.printStartMainError();
            startMain(scanner);
        }
        //
        chooseFunctionInMain(inputView.getInputData());
    }

    private void chooseFunctionInMain(String inputData) {
        if(inputData.equals("1")) {
            startStationManagement();
        }
        if(inputData.equals("2")) {
            startLineManagement();
        }
        if(inputData.equals("3")) {
            startSectionManagement();
        }
        if(inputData.equals("4")) {
            outputView.printSubwaySections();
        }
        if(inputData.equalsIgnoreCase("Q")) {
            isRun = false;
        }
    }



    private void startStationManagement() {
        outputView.printStationManagementScreen();
        inputView.scanData(scanner);
        chooseFunctionInStationManagement(inputView.getInputData());

    }

    private void chooseFunctionInStationManagement(String inputData) {
        if(inputData.equals("1")) {
            outputView.guideAddStation();
            inputView.scanData(scanner);
            StationRepository.addStation(new Station(inputView.getInputData()));
            System.out.println("결과창 출력 수정필요!");
            startMain(scanner);
        }
        if(inputData.equals("2")) {
            outputView.guideDeleteStation();
            inputView.scanData(scanner);
            StationRepository.deleteStation(inputView.getInputData());
            System.out.println("결과창 출력 수정필요!");
            startMain(scanner);
        }
        if(inputData.equals("3")) {
            outputView.printAllStations();
        }
        if(inputData.equalsIgnoreCase("B")) {
            startMain(scanner);
        }
    }

    private void startLineManagement() {
        outputView.printLineManagementScreen();
        inputView.scanData(scanner);
        chooseFunctionInLineManagement(inputView.getInputData());
    }

    private void chooseFunctionInLineManagement(String inputData) {
        if(inputData.equals("1")) {
            outputView.guideAddLineName();
            inputView.scanData(scanner);
            //검사
            LineRepository.addLine(new Line(inputData));
            System.out.println();

            outputView.guideAddLineUpwardTerminal();
            inputView.scanData(scanner);
            //검사
            LineRepository.getLine(inputData).setUpwardStation(StationRepository.getStation(inputData));
            System.out.println();

            outputView.guideAddLineDownwardTerminal();
            inputView.scanData(scanner);
            //검사
            LineRepository.getLine(inputData).setDownwardStation(StationRepository.getStation(inputData));
            System.out.println();
        }
        if(inputData.equals("2")) {
            outputView.guideDeleteLine();
            inputView.scanData(scanner);
            //검사
            LineRepository.deleteLineByName(inputView.getInputData());
            System.out.println();
        }
        if(inputData.equals("3")) {
            outputView.printAllLines();
        }
        if(inputData.equalsIgnoreCase("B")) {
            startMain(scanner);
        }

    }

    private void startSectionManagement() {
        outputView.printSectionManagementScreen();
        inputView.scanData(scanner);
        chooseFunctionInSectionManagement(inputView.getInputData());
    }

    private void chooseFunctionInSectionManagement(String inputData) {
        if(inputData.equals("1")) {
            outputView.guideAddRouteLine();
            inputView.scanData(scanner);
            //검사
            Line line = LineRepository.getLine(inputView.getInputData());
            System.out.println();

            outputView.guideAddRouteStation();
            inputView.scanData(scanner);
            //검사
            Station station = StationRepository.getStation(inputData);
            System.out.println();

            outputView.guideAddRouteOrder();
            inputView.scanData(scanner);
            // 검사 후 int로 형변환
            line.addSectionByOrderAndStation(Integer.parseInt(inputView.getInputData()), station);
            System.out.println("결과 출력 수정필요!");
        }
        if(inputData.equals("2")) {
            outputView.guideDeleteRouteLine();
            inputView.scanData(scanner);
            //검사
            Line line = LineRepository.getLine(inputData);
            System.out.println();

            outputView.guideDeleteRouteStation();
            inputView.scanData(scanner);
            //검사
            line.deleteSectionByName(inputView.getInputData());
        }
        if(inputData.equalsIgnoreCase("B")) {
            startMain(scanner);
        }
    }
}
