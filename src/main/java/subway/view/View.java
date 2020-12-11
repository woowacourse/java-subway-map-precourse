package subway.view;

import java.util.LinkedHashMap;
import subway.Scene;

public abstract class View {
    abstract public String getTitle();

    abstract public LinkedHashMap<String, Command> getMenus();

    public boolean hasCommnad(String input) {
        return getMenus().containsKey(input);
    }

    public void executeCommand(String input, Scene scene) {
        getMenus().get(input).execute(scene);
    }
}
