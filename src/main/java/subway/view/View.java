package subway.view;

import java.util.LinkedHashMap;
import subway.Scene;
import subway.io.Request;
import subway.io.Response;

public abstract class View {
    abstract public String getTitle();

    abstract public LinkedHashMap<String, Command> getMenus();

    public boolean hasCommnad(String input) {
        return getMenus().containsKey(input);
    }

    public void executeCommand(String input, Scene scene, Request request, Response response) {
        getMenus().get(input).execute(scene, request, response);
    }
}
