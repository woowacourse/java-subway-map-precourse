package subway.option;

public interface BaseOption {
    String getOption();

    void nextAction();

    boolean hasCode(String inputCode);
}
