package subway.userinterface;

public abstract class View {
    abstract void printGuidance();

    void processCommand(String command) {
        validateCommand(command);
        executeCommand(command);
        finish();
    }

    abstract void validateCommand(String command);

    abstract void executeCommand(String command);

    abstract void finish();
}
