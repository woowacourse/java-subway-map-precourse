package subway.menu;

public interface Menu {

    Menu run();

    Menu[] getValues();

    String getTitle();

    Menu change(String command);

    String getType();

    String getActionType();

}
