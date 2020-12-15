package subway;

import java.util.Stack;
import subway.io.Request;
import subway.io.Response;
import subway.view.MainView;
import subway.view.View;

public class Scene {
    private Stack<View> views = new Stack<View>();

    public Scene() {
        views.push(new MainView());
    }

    public boolean isFinished() {
        return views.isEmpty();
    }

    public void back() {
        views.pop();
    }

    public void go(View view) {
        views.push(view);
    }

    public void exit() {
        views.clear();
    }

    public boolean hasCommand(String input) {
        return getCurrentView().hasCommnad(input);
    }

    public void executeCommand(String input, Request request, Response response) {
        getCurrentView().executeCommand(input, this, request, response);
    }

    public View getCurrentView() {
        return views.peek();
    }
}
