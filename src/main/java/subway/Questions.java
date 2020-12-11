package subway;

import subway.question.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Questions {
    private static final String ERROR_INVALID_CHOICE = "[ERROR], 선택할 수 없는 기능입니다.";
    private Map<String, BaseQuestion[]> Questions = new HashMap<>();

    public Questions() {
        Questions.put("Main", MainQuestion.values());
        Questions.put("Station", StationQuestion.values());
        Questions.put("Line", LineQuestion.values());
        Questions.put("Section", SectionQuestion.values());
    }

    public Stream<String> getQuestions(String questionType) {
        return Arrays.stream(Questions.get(questionType)).map(BaseQuestion::getQuestion);
    }

    public BaseQuestion findByAnswerCode(String questionType, String inputCode) {
        return Arrays.stream(Questions.get(questionType))
                .filter(question -> question.hasAnswerCode(inputCode))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_CHOICE));
    }
}
