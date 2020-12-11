package subway.view;

import subway.CommandFunction;
import subway.Scene;
import subway.io.Request;
import subway.io.Response;

public class Command {
    private final String message;
    private final CommandFunction<Scene, Request, Response> process;

    public Command(String message, CommandFunction<Scene, Request, Response> process) {
        this.message = message;
        this.process = process;
    }

    public String getMessage() {
        return message;
    }

    public void execute(Scene scene, Request request, Response response) {
        process.apply(scene, request, response);
    }
}
