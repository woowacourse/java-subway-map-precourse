package subway.view;

import java.util.function.Consumer;
import subway.Scene;

public class Command {
    private final String message;
    private final Consumer<Scene> process;

    public Command(String message, Consumer<Scene> process) {
        this.message = message;
        this.process = process;
    }

    public String getMessage() {
        return message;
    }

    public void execute(Scene scene) {
        process.accept(scene);
    }
}
