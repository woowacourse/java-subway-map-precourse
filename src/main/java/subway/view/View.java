package subway.view;

import subway.domain.*;
import subway.Questions;

import java.util.Scanner;

public class View {
    InputView inputView;
    OutputView outputView;
    Questions questions;

    public View(Scanner scanner) {
        inputView = new InputView(scanner);
        outputView = new OutputView();
        questions = new Questions();
    }

    public void view(String questionType) {
        outputView.printQuestions(questions.getQuestions(questionType));
        questions.findByAnswerCode(questionType, inputView.getAnswer()).nextAction(this);
    }

    public void printEntireSubwayLine() {
        outputView.printEntireSubwayLine(LineRepository.lines());
    }

    public void printStationList() {
        outputView.printStationList(StationRepository.stations());
    }

    public void printSubwayLineList() {
        outputView.printSubwayLineList(LineRepository.lines());
    }

    public void registerStation() {
        outputView.printRegisterStationQuestion();
        StationRepository.addStation(new Station(inputView.getStation()));
        outputView.printRegisterStationSuccess();
    }

    public void deleteStation() {
        outputView.printDeleteStationQuestion();
        if (!StationRepository.deleteStation(inputView.getStation())) {
            throw new IllegalArgumentException("등록되지 않은 역입니다.");
        }
        outputView.printDeleteStationSuccess();
    }

    public void registerLine() {
        outputView.printRegisterLineQuestion();
        String lineName = inputView.getLine();
        outputView.printStartStationQuestion();
        Station startStation = StationRepository.getStation(inputView.getStation());
        outputView.printEndStationQuestion();
        Station endStation = StationRepository.getStation(inputView.getStation());
        LineRepository.addLine(new Line(lineName, startStation, endStation));
        outputView.printRegisterLineSuccess();
    }

    public void deleteLine() {
        outputView.printDeleteLineQuestion();
        if (!LineRepository.deleteLineByName(inputView.getLine())) {
            throw new IllegalArgumentException("등록되지 않은 노선입니다.");
        }
        outputView.printDeleteLineSuccess();
    }

    public void registerSection() {
        outputView.printRegisterSectionLineNameQuestion();
        Line line = LineRepository.getLine(inputView.getLine());
        outputView.printRegisterSectionStationNameQuestion();
        Station station = StationRepository.getStation(inputView.getStation());
        outputView.printRegisterSectionOrderNumberQuestion();
        int order = inputView.getInt();
        line.add(order, station);
        outputView.printRegisterSectionSuccess();
    }

    public void deleteSection() {
        outputView.printDeleteSectionLineNameQuestion();
        Line line = LineRepository.getLine(inputView.getLine());
        outputView.printDeleteSectionStationNameQuestion();
        Station station = StationRepository.getStation(inputView.getStation());
        if (!line.remove(station)) {
            throw new IllegalArgumentException("노선에 입력한 역이 없습니다.");
        }
        outputView.printDeleteSectionSuccess();
    }
}
