package subway.controller;

import subway.LineManagementSign;
import subway.MainSign;
import subway.SectionManagementSign;
import subway.StationManagementSign;
import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;
import java.util.function.Consumer;

public class SubwayMap {
    private boolean isRun = true;
    private OutputView outputView;
    private InputView inputView;
    private Scanner scanner;

    public void Run(Scanner scanner) {
        this.scanner = scanner;
        while (isRun) {
            outputView = new OutputView();
            inputView = new InputView();
            startMain();
        }
    }

    private void startMain() {
        outputView.printMainScreen();
        inputView.scanData(scanner);
        validateSign(inputView.getInputData(),
                t -> MainSign.validateSign(t),
                () -> startMain());
        chooseFunctionInMain(inputView.getInputData());
    }

    private void chooseFunctionInMain(String inputData) {
        if (inputData.equals(MainSign.STATION_MANAGEMENT.getSign())) {
            startStationManagement();
        }
        if (inputData.equals(MainSign.LINE_MANAGEMENT.getSign())) {
            startLineManagement();
        }
        if (inputData.equals(MainSign.SECTION_MANAGEMENT.getSign())) {
            startSectionManagement();
        }
        if (inputData.equals(MainSign.PRINT_SUBWAY_ROUTE.getSign())) {
            outputView.printSubwaySections();
        }
        if (inputData.equalsIgnoreCase(MainSign.CLOSE_MAIN.getSign())) {
            isRun = false;
        }
    }


    private void startStationManagement() {
        outputView.printStationManagementScreen();
        inputView.scanData(scanner);
        validateSign(inputView.getInputData(),
                t -> StationManagementSign.validateSign(t),
                () -> startStationManagement());
        chooseFunctionInStationManagement(inputView.getInputData());

    }

    private void chooseFunctionInStationManagement(String inputData) {
        if (inputData.equals(StationManagementSign.ADD_STATION.getSign())) {
            addStation();
            System.out.println("addStation 끝");
            outputView.infoAddStation();
        }
        if (inputData.equals(StationManagementSign.DELETE_STATION.getSign())) {
            deleteStation();
            outputView.infoDeleteStation();
        }
        if (inputData.equals(StationManagementSign.SHOW_STATIONS.getSign())) {
            outputView.printAllStations();
        }
        if (inputData.equalsIgnoreCase(StationManagementSign.BACK_TO_MAIN.getSign())) {
            startMain();
        }
    }

    private void addStation() {
        outputView.guideAddStation();
        inputView.scanData(scanner);
        String name = inputView.getInputData();
        validateStationName(name, () -> addStation());
        validateStationDuplicate(name, () -> addStation());
        StationRepository.addStation(new Station(name));
    }

    private void validateSign(String inputData, Consumer<String> tryExpression, Runnable catchExpression) {
        try {
            tryExpression.accept(inputData);
        } catch (IllegalArgumentException E) {
            outputView.errorChooseFunction();
            catchExpression.run();
        }
    }

    private void validateStationName(String inputData, Runnable catchExpression) {
        try {
            ErrorHandler.validateStationNameFormat(inputData);
        } catch (IllegalArgumentException E) {
            outputView.errorStationFormat();
            catchExpression.run();
        }
    }

    private void validateStationDuplicate(String inputData, Runnable catchExpression) {
        try {
            ErrorHandler.validateStationDuplicate(inputData);
        } catch (IllegalArgumentException E) {
            outputView.errorStationDuplicate();
            catchExpression.run();
        }
    }

    private void validateStationRegistered(String inputData, Runnable catchExpression) {
        try {
            ErrorHandler.validateStationRegistered(inputData);
        } catch (IllegalArgumentException E) {
            outputView.errorDeleteStationNotRegistered();
            catchExpression.run();
        }
    }

    private void deleteStation() {
        outputView.guideDeleteStation();
        inputView.scanData(scanner);
        validateStationName(inputView.getInputData(), () -> deleteStation());
        validateStationRegistered(inputView.getInputData(), () -> deleteStation());
        StationRepository.deleteStation(inputView.getInputData());
        LineRepository.deleteStationInLine(inputView.getInputData());

    }

    private void startLineManagement() {
        outputView.printLineManagementScreen();
        inputView.scanData(scanner);
        validateSign(inputView.getInputData(),
                t -> LineManagementSign.validateSign(t),
                () -> startLineManagement());
        chooseFunctionInLineManagement(inputView.getInputData());
    }

    private void chooseFunctionInLineManagement(String inputData) {
        if (inputData.equals(LineManagementSign.ADD_LINE.getSign())) {
            addLine();
            addUpwardTerminal();
            addDownwardTerminal();
            outputView.infoAddLine();
        }
        if (inputData.equals(LineManagementSign.DELETE_LINE.getSign())) {
            deleteLine();
            outputView.infoDeleteLine();
        }
        if (inputData.equals(LineManagementSign.SHOW_LINES.getSign())) {
            outputView.printAllLines();
        }
        if (inputData.equalsIgnoreCase(LineManagementSign.BACK_TO_MAIN.getSign())) {
            startMain();
        }
    }

    private void addLine() {
        outputView.guideAddLineName();
        inputView.scanData(scanner);
        String name = inputView.getInputData();
        validateLineName(name, () -> addLine());
        validateLineDuplicate(name, () -> addLine());
        LineRepository.addLine(new Line(name));
    }

    private void addUpwardTerminal() {
        outputView.guideAddLineUpwardTerminal();
        inputView.scanData(scanner);
        String name = inputView.getInputData();
        validateStationName(name, () -> addUpwardTerminal());
        validateStationRegistered(name, () -> addUpwardTerminal());
        LineRepository.getNewLine().addSectionByStation(StationRepository.getStation(name));
    }

    private void addDownwardTerminal() {
        outputView.guideAddLineDownwardTerminal();
        inputView.scanData(scanner);
        String name = inputView.getInputData();
        validateStationName(name, () -> addDownwardTerminal());
        validateStationRegistered(name, () -> addDownwardTerminal());
        LineRepository.getNewLine().addSectionByStation(StationRepository.getStation(name));
    }

    private void deleteLine() {
        outputView.guideDeleteLine();
        inputView.scanData(scanner);
        String name = inputView.getInputData();
        validateLineName(name, () -> deleteLine());
        validateLineRegistered(name, () -> deleteLine());
        LineRepository.deleteLineByName(inputView.getInputData());
    }

    private void validateLineName(String inputData, Runnable catchExpression) {
        try {
            ErrorHandler.validateLineNameFormat(inputData);
        } catch (IllegalArgumentException E) {
            outputView.errorLineFormat();
            catchExpression.run();
        }
    }

    private void validateLineDuplicate(String inputData, Runnable catchExpression) {
        try {
            ErrorHandler.validateLineDuplicate(inputData);
        } catch (IllegalArgumentException E) {
            outputView.errorLineDuplicate();
            catchExpression.run();
        }
    }

    private void validateLineRegistered(String inputData, Runnable catchExpression) {
        try {
            ErrorHandler.validateLineRegistered(inputData);
        } catch (IllegalArgumentException E) {
            outputView.errorDeleteLineNotRegistered();
            catchExpression.run();
        }
    }

    private void startSectionManagement() {
        outputView.printSectionManagementScreen();
        inputView.scanData(scanner);
        validateSign(inputView.getInputData(),
                t -> SectionManagementSign.validateSign(t),
                () -> startSectionManagement());
        chooseFunctionInSectionManagement(inputView.getInputData());
    }

    private void chooseFunctionInSectionManagement(String inputData) {
        if (inputData.equals(SectionManagementSign.ADD_SECTION.getSign())) {
            addSection();
            outputView.infoAddSection();
        }
        if (inputData.equals(SectionManagementSign.DELETE_SECTION.getSign())) {
            deleteSection();
            outputView.infoDeleteSection();
        }
        if (inputData.equalsIgnoreCase(SectionManagementSign.BACK_TO_MAIN.getSign())) {
            startMain();
        }
    }

    private void addSection() {
        Line line;
        Station station;
        int order;
        line = addCheckLine();
        station = addCheckStation(line);
        order = addcheckOrder(line);
        line.addSectionByOrderAndStation(order, station);
    }

    private Line addCheckLine() {
        outputView.guideCheckLine();
        inputView.scanData(scanner);
        String name = inputView.getInputData();
        validateLineName(name, () -> addSection());
        validateLineRegistered(name, () -> addSection());
        return LineRepository.getLine(name);
    }

    private Station addCheckStation(Line line) {
        outputView.guideCheckSectionStation();
        inputView.scanData(scanner);
        String name = inputView.getInputData();
        validateStationName(name, () -> addSection());
        validateStationRegistered(name, () -> addSection());
        validateStationDuplicateInLine(StationRepository.getStation(name), line, () -> addSection());
        return StationRepository.getStation(name);
    }

    private int addcheckOrder(Line line) {
        outputView.guideCheckSectionOrder();
        inputView.scanData(scanner);
        String order = inputView.getInputData();
        validateOrder(order, line, () -> addSection());
        return Integer.parseInt(order);
    }

    private void validateStationDuplicateInLine(Station station, Line line, Runnable expression) {
        try {
            ErrorHandler.validateStationDuplicateInLine(station, line);
        } catch (IllegalArgumentException E) {
            outputView.errorStationDuplicate();
            expression.run();
        }
    }

    private void validateOrder(String order, Line line, Runnable expression) {
        try {
            ErrorHandler.validateOrder(order, line);
        } catch (NumberFormatException E) {
            outputView.errorParseIntOrder();
            expression.run();
        } catch (IllegalArgumentException E) {
            outputView.errorInBoundOrder();
            expression.run();
        }
    }

    private void deleteSection() {
        Line line = deleteCheckLine();
        Station station = deleteCheckStation(line);
        line.deleteSectionByName(station.getName());
    }

    private Line deleteCheckLine() {
        outputView.guideDeleteSectionLine();
        inputView.scanData(scanner);
        String name = inputView.getInputData();
        validateLineName(name, () -> deleteSection());
        validateLineRegistered(name, () -> deleteSection());
        return LineRepository.getLine(name);
    }

    private Station deleteCheckStation(Line line) {
        outputView.guideDeleteSectionStation();
        inputView.scanData(scanner);
        String name = inputView.getInputData();
        validateStationName(name, () -> deleteSection());
        validateStationRegistered(name, () -> deleteSection());
        validateStationRegisteredInLine(StationRepository.getStation(name), line, () -> deleteSection());
        return StationRepository.getStation(name);
    }

    private void validateStationRegisteredInLine(Station station, Line line, Runnable expression) {
        try {
            ErrorHandler.validateStationRegisteredInLine(station, line);
        } catch (IllegalArgumentException E) {
            outputView.errorStationDuplicate();
            expression.run();
        }
    }
}
