package subway.service.menu;

public interface Menu {

    String getNumber();

    String getMessage();

    Runnable getFunction();

//    void callFunction(String input);
}
