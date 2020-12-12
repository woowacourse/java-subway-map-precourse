package subway.question;

public interface BaseQuestion {
    String getHeader();

    String getOption();

    void nextAction();

    boolean hasAnswerCode(String inputCode);
}
