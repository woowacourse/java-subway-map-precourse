package subway.controller;

public interface Controller {

    String SELECT_FUNCTION = System.lineSeparator() + "## 원하는 기능을 선택하세요.";

    void runMenu();

    boolean isEnd(String input);
}
