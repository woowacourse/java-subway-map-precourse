package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.OutputView;
import subway.domain.StationRepository;

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
}
