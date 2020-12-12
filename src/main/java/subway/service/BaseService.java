package subway.service;

import subway.question.BaseQuestion;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class BaseService {
    private static final String ERROR_INVALID_CHOICE = "선택할 수 없는 기능입니다.";

    public static void view(List<BaseQuestion> questionList, String header) {
        try {
            OutputView.printQuestionHeader(header);
            OutputView.printQuestions(questionList.stream().map(BaseQuestion::getQuestion));
            selectedQuestion(questionList, InputView.getAnswer()).nextAction();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            view(questionList, header);
        }
    }

    private static BaseQuestion selectedQuestion(List<BaseQuestion> questionList, String inputCode) {
        return findByAnswerCode(questionList, inputCode);
    }

    private static BaseQuestion findByAnswerCode(List<BaseQuestion> questionList, String inputCode) {
        return questionList.stream()
                .filter(question -> question.hasAnswerCode(inputCode))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_CHOICE));
    }
}
