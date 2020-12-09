package subway;

import java.util.Arrays;
import java.util.stream.Stream;

public enum StationQuestion {
    REGISTER_STATION("1. 역 등록", "1") {
        @Override
        public void nextAction(View view) {
            view.mainView();
        }
    },
    DELETE_STATION("2. 역 삭제", "2") {
        @Override
        public void nextAction(View view) {
            view.mainView();
        }
    },
    SHOW_STATIONS("3. 역 조회", "3") {
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

    private static final String HEADER = "## 역 관리 화면";
    private static final String ERROR_INVALID_CHOICE = "[ERROR], 선택할 수 없는 기능입니다.";
    private String question;
    private String answerCode;

    public abstract void nextAction(View view);

    StationQuestion(String question, String answerCode) {
        this.question = question;
        this.answerCode = answerCode;
    }

    public static Stream<String> getQuestions() {
        return Arrays.stream(subway.StationQuestion.values()).map(StationQuestion::getQuestion);
    }

    private String getQuestion() {
        return question;
    }

    public static void printQuestions() {
        System.out.println(HEADER);
        getQuestions().forEach(StationQuestion::printQuestion);
    }

    private static void printQuestion(String question) {
        System.out.println(question);
    }

    public static StationQuestion findByAnswerCode(String inputCode) {
        return Arrays.stream(StationQuestion.values())
                .filter(question -> question.hasAnswerCode(inputCode))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_CHOICE));
    }

    public boolean hasAnswerCode(String inputCode) {
        return this.answerCode.equals(inputCode);
    }

}
