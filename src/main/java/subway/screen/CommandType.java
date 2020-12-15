package subway.screen;

public enum CommandType {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    BACK("B"),
    QUIT("Q");
    
    private String command;
    
    CommandType(String command) {
        this.command = command;
    }
    
    public String toString() {
        return command;
    }
}
