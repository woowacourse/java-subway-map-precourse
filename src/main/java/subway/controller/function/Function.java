package subway.controller.function;

public interface Function {
    String getCode();

    String getTitle();

    Runnable getFunction();
}
