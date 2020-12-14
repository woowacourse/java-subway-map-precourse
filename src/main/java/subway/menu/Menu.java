package subway.menu;

public interface Menu {

    Menu run();

    Menu[] getValues();

    String getTitle();

    String getOrder();

    String getType();

    Action getAction();

}
