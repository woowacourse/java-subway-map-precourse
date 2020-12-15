package subway.domain.menu;

public class MenuItem {
    private String key;
    private String name;
    private Runnable action;

    public MenuItem(String key, String name, Runnable action) {
        this.key = key;
        this.name = name;
        this.action = action;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public void execute() {
        action.run();
    }
}
