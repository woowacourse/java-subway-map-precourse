package subway.view;

import subway.domain.*;
import subway.Questions;
import subway.question.BaseQuestion;

import java.util.Scanner;

public class View {
    private final String ERR_LINE_PASSED_STATION = "역을 지나는 노선이 있습니다.";
    private final String ERR_UNREGISTERED_STATION = "등록되지 않은 역입니다.";
    private final String ERR_UNREGISTERED_LINE = "등록되지 않은 노선입니다.";
    private final String ERR_NO_STATION_ON_LINE = "노선에 입력한 역이 없습니다.";
    private final String ERR_MIN_LINE_LENGTH = "노선의 길이가 짧습니다.";
    private final int MIN_LINE_LENGTH = 2;
    private final String MAIN_VIEW = "Main";
    private final String STATION_VIEW = "Station";
    private final String LINE_VIEW = "Line";
    private final String SECTION_VIEW = "Section";
    InputView inputView;
    OutputView outputView;
    Questions questions;

    public View(Scanner scanner) {
        inputView = new InputView(scanner);
        outputView = new OutputView();
        questions = new Questions();
    }

    public void main() {
        nextView(MAIN_VIEW);
    }

    public void station() {
        nextView(STATION_VIEW);
    }

    public void line() {
        nextView(LINE_VIEW);
    }

    public void section() {
        nextView(SECTION_VIEW);
    }

    private void nextView(String questionType) {
        try {
            outputView.printQuestionHeader(questions.getHeader(questionType));
            outputView.printQuestions(questions.getQuestions(questionType));
            selectedQuestion(questionType).nextAction(this);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            nextView(questionType);
        }
    }

    private BaseQuestion selectedQuestion(String questionType) {
        return questions.findByAnswerCode(questionType, inputView.getAnswer());
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
        StationRepository.addStation(new Station(inputView.getStationName()));
        outputView.printRegisterStationSuccess();
    }

    public void deleteStation() {
        outputView.printDeleteStationQuestion();
        Station station = StationRepository.getStation(inputView.getStationName());
        if (station.isLinePassed()){
            throw new IllegalArgumentException(ERR_LINE_PASSED_STATION);
        }
        if (!StationRepository.deleteStation(station)) {
            throw new IllegalArgumentException(ERR_UNREGISTERED_STATION);
        }
        outputView.printDeleteStationSuccess();
    }

    public void registerLine() {
        outputView.printRegisterLineQuestion();
        String lineName = inputView.getLineName();
        outputView.printLineStartStationQuestion();
        Station startStation = StationRepository.getStation(inputView.getStationName());
        outputView.printLineEndStationQuestion();
        Station endStation = StationRepository.getStation(inputView.getStationName());
        LineRepository.addLine(new Line(lineName, startStation, endStation));
        outputView.printRegisterLineSuccess();
    }

    public void deleteLine() {
        outputView.printDeleteLineQuestion();
        if (!LineRepository.deleteLineByName(inputView.getLineName())) {
            throw new IllegalArgumentException(ERR_UNREGISTERED_LINE);
        }
        outputView.printDeleteLineSuccess();
    }

    public void registerSection() {
        outputView.printRegisterSectionLineNameQuestion();
        Line line = LineRepository.getLine(inputView.getLineName());
        outputView.printRegisterSectionStationNameQuestion();
        Station station = StationRepository.getStation(inputView.getStationName());
        outputView.printRegisterSectionOrderNumberQuestion();
        int order = inputView.getOrder();
        line.add(order-1, station);
        outputView.printRegisterSectionSuccess();
    }

    public void deleteSection() {
        outputView.printDeleteSectionLineNameQuestion();
        Line line = LineRepository.getLine(inputView.getLineName());
        outputView.printDeleteSectionStationNameQuestion();
        Station station = StationRepository.getStation(inputView.getStationName());
        if (line.getLength() <= MIN_LINE_LENGTH) {
            throw new IllegalArgumentException(ERR_MIN_LINE_LENGTH);
        }
        if (!line.remove(station)) {
            throw new IllegalArgumentException(ERR_NO_STATION_ON_LINE);
        }
        outputView.printDeleteSectionSuccess();
    }
}
