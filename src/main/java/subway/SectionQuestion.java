package subway;

import java.util.Arrays;
import java.util.stream.Stream;

public enum SectionQuestion {
    REGISTER_STATION("1. 구간 등록", "1") {
        @Override
        public void nextAction(View view) {
            view.mainView();
        }
    },
    DELETE_STATION("2. 구간 삭제", "2") {
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

    private String question;
    private String answerCode;

    public abstract void nextAction(View view);

    SectionQuestion(String question, String answerCode) {
        this.question = question;
        this.answerCode = answerCode;
    }

    public static Stream<String> getQuestions() {
        return Arrays.stream(subway.SectionQuestion.values()).map(SectionQuestion::getQuestion);
    }

    private String getQuestion(){
        return question;
    }

    public static void printQuestions() {
        System.out.println("## 구간 관리 화면");
        getQuestions().forEach(SectionQuestion::printQuestion);
    }

    private static void printQuestion(String question) {
        System.out.println(question);
    }

    public static SectionQuestion findByAnswerCode(String inputCode) {
        return Arrays.stream(SectionQuestion.values())
                .filter(question -> question.hasAnswerCode(inputCode))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR], 선택할 수 없는 기능입니다."));
    }

    public boolean hasAnswerCode(String inputCode) {
        return this.answerCode.equals(inputCode);
    }
}
