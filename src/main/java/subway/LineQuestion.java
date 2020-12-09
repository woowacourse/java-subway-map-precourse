package subway;

import java.util.Arrays;
import java.util.stream.Stream;

public enum LineQuestion {
    REGISTER_STATION("1. 노선 등록", "1") {
        @Override
        public void nextAction(View view) {
            view.mainView();
        }
    },
    DELETE_STATION("2. 노선 삭제", "2") {
        @Override
        public void nextAction(View view) {
            view.mainView();
        }
    },
    SHOW_STATIONS("3. 노선 조회", "3") {
        @Override
        public void nextAction(View view) {
            view.mainView();
        }
    },
    BACK("B. 돌아가기", "B") {
        @Override
        public void nextAction(View view) {
            view.mainView();
        }
    };

    private static final String HEADER = "## 노선 관리 화면";
    private static final String ERROR_INVALID_CHOICE = "[ERROR], 선택할 수 없는 기능입니다.";
    private String question;
    private String answerCode;

    public abstract void nextAction(View view);

    LineQuestion(String question, String answerCode) {
        this.question = question;
        this.answerCode = answerCode;
    }

    public static Stream<String> getQuestions() {
        return Arrays.stream(subway.LineQuestion.values()).map(LineQuestion::getQuestion);
    }

    private String getQuestion() {
        return question;
    }

    public static void printQuestions() {
        System.out.println(HEADER);
        getQuestions().forEach(LineQuestion::printQuestion);
    }

    private static void printQuestion(String question) {
        System.out.println(question);
    }

    public static LineQuestion findByAnswerCode(String inputCode) {
        return Arrays.stream(LineQuestion.values())
                .filter(question -> question.hasAnswerCode(inputCode))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_CHOICE));
    }

    public boolean hasAnswerCode(String inputCode) {
        return this.answerCode.equals(inputCode);
    }
}
