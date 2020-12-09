package subway;

import subway.domain.*;

import java.util.Scanner;

public class View {
    InputView inputView;
    OutputView outputView;

    public View(Scanner scanner) {
        inputView = new InputView(scanner);
        outputView = new OutputView();
    }

    public void mainView() {
        MainQuestion.printQuestions();
        MainQuestion.findByAnswerCode(inputView.getAnswer()).nextAction(this);
    }

    public void stationView() {
        StationQuestion.printQuestions();
        StationQuestion.findByAnswerCode(inputView.getAnswer()).nextAction(this);
    }

    public void lineView() {
        LineQuestion.printQuestions();
        LineQuestion.findByAnswerCode(inputView.getAnswer()).nextAction(this);
    }

    public void sectionView() {
        SectionQuestion.printQuestions();
        SectionQuestion.findByAnswerCode(inputView.getAnswer()).nextAction(this);
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
}
