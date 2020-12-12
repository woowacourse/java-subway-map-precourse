package subway.view;

import subway.domain.*;
import subway.Questions;
import subway.question.BaseQuestion;

import java.util.Scanner;

public class View {
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






}
