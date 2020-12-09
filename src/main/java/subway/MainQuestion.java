package subway;

import java.util.Arrays;
import java.util.stream.Stream;

public enum MainQuestion {
    TO_STATION_VIEW("1. 역 관리", "1") {
        @Override
        public void nextAction(View view) {
            view.stationView();
        }
    },
    TO_LINE_VIEW("2. 노선 관리", "2") {
        @Override
        public void nextAction(View view) {
            view.lineView();
        }
    },
    TO_INTERVAL_VIEW("3. 구간 관리", "3") {
        @Override
        public void nextAction(View view) {
            view.sectionView();
        }
    },
    PRINT_SUBWAY_ROUTE("4. 지하철 노선도 출력", "4") {
        @Override
        public void nextAction(View view) {
            view.printEntireSubwayLine();
        }
    },
    QUIT("Q. 종료", "Q") {
        @Override
        public void nextAction(View view) {
        }
    };

    private static final String HEADER = "## 메인 화면";
    private static final String ERROR_INVALID_CHOICE = "[ERROR], 선택할 수 없는 기능입니다.";
    private String question;
    private String answerCode;

    public abstract void nextAction(View view);

    MainQuestion(String question, String answerCode) {
        this.question = question;
        this.answerCode = answerCode;
    }

    public static Stream<String> getQuestions() {
        return Arrays.stream(MainQuestion.values()).map(MainQuestion::getQuestion);
    }

    private String getQuestion() {
        return question;
    }

    public static void printQuestions() {
        System.out.println(HEADER);
        getQuestions().forEach(MainQuestion::printQuestion);
    }

    private static void printQuestion(String question) {
        System.out.println(question);
    }

    public static MainQuestion findByAnswerCode(String inputCode) {
        return Arrays.stream(MainQuestion.values())
                .filter(question -> question.hasAnswerCode(inputCode))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_CHOICE));
    }

    public boolean hasAnswerCode(String inputCode) {
        return this.answerCode.equals(inputCode);
    }
}
