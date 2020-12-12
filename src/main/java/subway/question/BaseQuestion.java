package subway.question;

public interface BaseQuestion {
    String getHeader();

    String getQuestion();

    void nextAction();

    boolean hasAnswerCode(String inputCode);
}
