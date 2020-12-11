package subway;

public interface BaseQuestion {
    String getQuestion();

    void nextAction(View view);

    boolean hasAnswerCode(String inputCode);
}
