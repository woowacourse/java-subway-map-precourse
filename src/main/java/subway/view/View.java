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
    Questions questions;

    public View() {
        questions = new Questions();
    }

    public void main() {
        try {
            nextView(MAIN_VIEW);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            main();
        }
    }

    public void station() {
        try {
            nextView(STATION_VIEW);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            station();
        }
    }

    public void line() {
        try {
            nextView(LINE_VIEW);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            line();
        }
    }

    public void section() {
        try {
            nextView(SECTION_VIEW);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            section();
        }
    }

    private void nextView(String questionType) {
        OutputView.printQuestionHeader(questions.getHeader(questionType));
        OutputView.printQuestions(questions.getQuestions(questionType));
        selectedQuestion(questionType).nextAction(this);
    }

    private BaseQuestion selectedQuestion(String questionType) {
        return questions.findByAnswerCode(questionType, InputView.getAnswer());
    }


    public void printStationList() {
        OutputView.printStationList(StationRepository.stations());
    }

    public void printSubwayLineList() {
        OutputView.printSubwayLineList(LineRepository.lines());
    }

    public void registerStation() {
        OutputView.printRegisterStationQuestion();
        StationRepository.addStation(new Station(InputView.getStationName()));
        OutputView.printRegisterStationSuccess();
    }

    public void deleteStation() {
        OutputView.printDeleteStationQuestion();
        Station station = StationRepository.getStation(InputView.getStationName());
        if (station.isLinePassed()){
            throw new IllegalArgumentException(ERR_LINE_PASSED_STATION);
        }
        if (!StationRepository.deleteStation(station)) {
            throw new IllegalArgumentException(ERR_UNREGISTERED_STATION);
        }
        OutputView.printDeleteStationSuccess();
    }

    public void registerLine() {
        OutputView.printRegisterLineQuestion();
        String lineName = InputView.getLineName();
        OutputView.printLineStartStationQuestion();
        Station startStation = StationRepository.getStation(InputView.getStationName());
        OutputView.printLineEndStationQuestion();
        Station endStation = StationRepository.getStation(InputView.getStationName());
        LineRepository.addLine(new Line(lineName, startStation, endStation));
        OutputView.printRegisterLineSuccess();
    }

    public void deleteLine() {
        OutputView.printDeleteLineQuestion();
        if (!LineRepository.deleteLineByName(InputView.getLineName())) {
            throw new IllegalArgumentException(ERR_UNREGISTERED_LINE);
        }
        OutputView.printDeleteLineSuccess();
    }

    public void registerSection() {
        OutputView.printRegisterSectionLineNameQuestion();
        Line line = LineRepository.getLine(InputView.getLineName());
        OutputView.printRegisterSectionStationNameQuestion();
        Station station = StationRepository.getStation(InputView.getStationName());
        OutputView.printRegisterSectionOrderNumberQuestion();
        int order = InputView.getOrder();
        line.add(order-1, station);
        OutputView.printRegisterSectionSuccess();
    }

    public void deleteSection() {
        OutputView.printDeleteSectionLineNameQuestion();
        Line line = LineRepository.getLine(InputView.getLineName());
        OutputView.printDeleteSectionStationNameQuestion();
        Station station = StationRepository.getStation(InputView.getStationName());
        if (line.getLength() <= MIN_LINE_LENGTH) {
            throw new IllegalArgumentException(ERR_MIN_LINE_LENGTH);
        }
        if (!line.remove(station)) {
            throw new IllegalArgumentException(ERR_NO_STATION_ON_LINE);
        }
        OutputView.printDeleteSectionSuccess();
    }
}
