package subway;

import subway.question.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Questions {
    private static final String ERROR_INVALID_CHOICE = "선택할 수 없는 기능입니다.";
    private Map<String, BaseQuestion[]> questions = new HashMap<>();

    public Questions() {
        questions.put("Main", MainQuestion.values());
        questions.put("Station", StationQuestion.values());
        questions.put("Line", LineQuestion.values());
        questions.put("Section", SectionQuestion.values());
    }

    public String getHeader(String questionType) {
        return questions.get(questionType)[0].getHeader();
    }

    public Stream<String> getQuestions(String questionType) {
        return Arrays.stream(questions.get(questionType)).map(BaseQuestion::getQuestion);
    }

    public BaseQuestion findByAnswerCode(String questionType, String inputCode) {
        return Arrays.stream(questions.get(questionType))
                .filter(question -> question.hasAnswerCode(inputCode))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_CHOICE));
    }
}
