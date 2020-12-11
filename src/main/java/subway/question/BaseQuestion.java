package subway.question;

import subway.view.View;

public interface BaseQuestion {
    String getHeader();

    String getQuestion();

    void nextAction(View view);

    boolean hasAnswerCode(String inputCode);
}
