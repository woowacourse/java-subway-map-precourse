package subway;

import java.io.PrintStream;
import java.util.Scanner;
import subway.io.Request;
import subway.io.Response;

public class SubwayManager {
    private final Request request;
    private final Response response;
    private Scene scene;

    public SubwayManager(Scanner scanner, PrintStream printStream) {
        request = new Request(scanner, printStream);
        response = new Response(printStream);
        scene = new Scene();
    }

    public void run() {
        while (!scene.isFinished()) {
            response.printMenus(scene);
            String input = selectCommand(scene);
            scene.executeCommand(input, request, response);
        }
    }

    private String selectCommand(Scene scene) {
        String input = null;
        while (input == null) {
            response.printHeadlineMessage(Response.COMMAND_REQUEST_MESSAGE);
            input = request.requestCommand(scene);
            response.printEmptyMessage();
        }
        return input;
    }
}
